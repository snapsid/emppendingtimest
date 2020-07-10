package com.example.employabilitytracking;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

public class NWorking extends AppCompatActivity {
EditText b1,b2,b3;

Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_working);
        b1=findViewById(R.id.editText18);
        b2=findViewById(R.id.editText19);
        b3=findViewById(R.id.editText20);

        ok=findViewById(R.id.okid);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b1.length()==0)
                {
                    b1.setError("field cannot be empty");
                }

                else if(b2.length()==0)
                {
                    b2.setError("field cannot be empty");
                }
                else if(b3.length()==0)
                {
                    b3.setError("field cannot be empty");
                }
                else
                {

                    Decider.leave1=b1.getText().toString();
                    Decider.fired1=b2.getText().toString();
                    Decider.exp1=b3.getText().toString();


                    Intent intent=new Intent(getApplicationContext(), Final.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            }
        });



    }
}
