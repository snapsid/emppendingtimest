package com.example.employabilitytracking;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CredEmp extends AppCompatActivity {
    Button b;
    EditText b1, b2, b3, b4, b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cred_emp);
        b = findViewById(R.id.ap1);
        b1 = findViewById(R.id.editText31);
        b2 = findViewById(R.id.editText33);
        b3 = findViewById(R.id.editText35);
        b4 = findViewById(R.id.editText36);
        b5 = findViewById(R.id.editText37);

        b.setOnClickListener(new View.OnClickListener() {
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
                }

                else {
                    Decider.name2=b1.getText().toString();
                    Decider.address2=b2.getText().toString();
                    Decider.aadhar2=b3.getText().toString();
                    Decider.resadd2=b4.getText().toString();
                    Decider.phone2=b5.getText().toString();

                    Intent i = new Intent(CredEmp.this, employerhome.class);
                    startActivity(i);
                }
            }


        });

    }



}
