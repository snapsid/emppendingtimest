package com.example.employabilitytracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button next;


    public static String name,address,city, district, pincode,phone,email;

EditText b1,b2,b3,b4,b5,b6;
EditText b7;

    FirebaseDatabase rootnode;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        next=(Button) findViewById(R.id.button14);

        b1 = findViewById(R.id.nameid);
        b2 = findViewById(R.id.addressid);
        b3 = findViewById(R.id.cityid);
        b4 = findViewById(R.id.districtid);
        b5 = findViewById(R.id.pincodeid);
        b6=findViewById(R.id.phoneid);
        b7=findViewById(R.id.emailid);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b1.length() == 0) {
                    b1.setError("field cannot be empty");
                } else if (b2.length() == 0) {
                    b2.setError("field cannot be empty");
                } else if (b3.length() == 0) {
                    b3.setError("field cannot be empty");
                } else if (b4.length() == 0) {
                    b4.setError("field cannot be empty");
                } else if (b5.length() == 0) {
                    b5.setError("field cannot be empty");
                } else {

                     name=b1.getText().toString();
                     address=b2.getText().toString();
                     city= b3.getText().toString();
                     district=b4.getText().toString();
                     pincode=b5.getText().toString();

                     phone=b6.getText().toString();

                     email=b7.getText().toString();
                    sharedpreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);



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
            }
        });
    }
}
