package com.example.employabilitytracking;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class placementyesfeed extends AppCompatActivity {
Button b;
RadioButton b12,b23;
EditText b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placementyesfeed);
        b=findViewById(R.id.button3);
        b12=findViewById(R.id.radioButton);
        b23=findViewById(R.id.radioButton6);
        b1 = findViewById(R.id.editText6);
        b2 = findViewById(R.id.editText7);
        b3 = findViewById(R.id.editText9);
        b4 = findViewById(R.id.editText10);
        b5 = findViewById(R.id.editText11);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b12.isChecked())
                {
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
                        Decider.nameemp1=b1.getText().toString();
                        Decider.trade1=b2.getText().toString();
                        Decider.sal1=b3.getText().toString();
                        Decider.poc1=b4.getText().toString();
                        Decider.prob1=b5.getText().toString();
                        Intent i = new Intent(placementyesfeed.this, Working.class);
                        startActivity(i);
                    }

                }
                else if(b23.isChecked())
                {
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
                        Decider.nameemp1=b1.getText().toString();
                        Decider.trade1=b2.getText().toString();
                        Decider.sal1=b3.getText().toString();
                        Decider.poc1=b4.getText().toString();
                        Decider.prob1=b5.getText().toString();
                        Intent i = new Intent(placementyesfeed.this, NWorking.class);
                        startActivity(i);
                    }

                }
                else
                {
                    Toast.makeText(placementyesfeed.this,"No options chosen",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
