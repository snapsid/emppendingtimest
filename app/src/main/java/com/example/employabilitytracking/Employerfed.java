package com.example.employabilitytracking;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class Employerfed extends AppCompatActivity {
  RadioButton b1,b;
  Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employerfed);
        b = findViewById(R.id.ip6);
        b1 = findViewById(R.id.ip7);
        b2 =findViewById(R.id.ip8);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b.isChecked())
                {
                    Decider.stillemp="yes";
                    Intent i = new Intent(Employerfed.this, EmployYES1.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                }
                else if(b1.isChecked())
                {
                    Decider.stillemp="no";
                    Intent i = new Intent(Employerfed.this,EmployNO1.class );
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                }
            }
        });
    }
}
