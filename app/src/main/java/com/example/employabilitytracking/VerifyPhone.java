package com.example.employabilitytracking;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.employabilitytracking.MainActivity.email;

public class VerifyPhone extends AppCompatActivity {

    SharedPreferences sharedpreferences;
 Button verify;
 EditText phn;
 ProgressBar pb;
 String id;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mFireBaseAuthSateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone);

        mAuth=FirebaseAuth.getInstance();

        sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        verify=findViewById(R.id.verify_btn);
        phn=findViewById(R.id.verification_code_entered_by_user);
        pb=findViewById(R.id.progress_bar);
        pb.setVisibility(View.GONE);

        String phone=getIntent().getStringExtra("phone");
        send(phone);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code=phn.getText().toString();
                if (code.isEmpty()||code.length()<6)
                {
                    phn.setError("wrong otp");
                    phn.requestFocus();
                    return;
                }
                pb.setVisibility(View.VISIBLE);
                verifycode(code);
            }

        });
    }
    private void send(String phone){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
               "+91"+phone,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                TaskExecutors.MAIN_THREAD,               // Activity (for callback binding)
                mCallbacks);
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks= new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            id=s;


        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {


            String code= phoneAuthCredential.getSmsCode();
            if(code!=null)
            {
                pb.setVisibility(View.VISIBLE);
                verifycode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(VerifyPhone.this,e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    };

    private void verifycode(String vcode)
    {
        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(id,vcode);
        sign(credential);
    }

    private void sign(PhoneAuthCredential credential) {




        FirebaseAuth fbAuth= FirebaseAuth.getInstance();
        fbAuth.signInWithCredential(credential)
                .addOnCompleteListener(VerifyPhone.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful())
                     {
                         SharedPreferences.Editor editor = sharedpreferences.edit();
                         editor.putString("check1", "1");
                         editor.commit();

                         DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("operator").child(MainActivity.phone);

                         Map userData=new HashMap<>();
                         userData.put("name", MainActivity.name);
                         userData.put("address", MainActivity.address);
                         userData.put("city", MainActivity.city);
                         userData.put("district", MainActivity.district);
                         userData.put("pincode", MainActivity.pincode);
                         userData.put("email", email);

                         reference.updateChildren(userData);



                         Intent intent=new Intent(getApplicationContext(),Decider.class);
                         intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                         startActivity(intent);

                         finish();
                     }
                     else
                     {
                         Toast.makeText(VerifyPhone.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                     }

                    }
                });
    }
}

