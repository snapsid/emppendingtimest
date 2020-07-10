package com.example.employabilitytracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Consent extends AppCompatActivity {
Button b;

RadioButton m,n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consent);
        b=findViewById(R.id.button9);
        m=findViewById(R.id.radioButton13);
        n=findViewById(R.id.radioButton14);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m.isChecked())
                {
                    Decider.collab2="yes";
                    Intent i = new Intent(getApplicationContext(),FinalEmployer.class);
                    startActivity(i);

                }
                else if(n.isChecked())
                {

                    Decider.collab2="no";
                    Intent i = new Intent(getApplicationContext(),FinalEmployer.class);
                    startActivity(i);

                }

            }
        });
    }
}
