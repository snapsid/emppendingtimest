package com.example.employabilitytracking;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class place extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        Button next = findViewById(R.id.button8);
        Button clear = findViewById(R.id.button10);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton b1 =  findViewById(R.id.radioButton2);
                RadioButton b2 = findViewById(R.id.radioButton3);
                RadioButton b3 = findViewById(R.id.ip3);
                RadioButton b4 = findViewById(R.id.ip4);

                if (b1.isChecked()) {

                    Decider.placement="yes";
                    Intent i = new Intent(place.this, placementyesfeed.class);
                    startActivity(i);
                } else if (b2.isChecked()) {
                    Intent i = new Intent(place.this, placementnofeed.class);
                    startActivity(i);
                } else if (b3.isChecked()) {
                    Decider.self="yes";
                    Intent i = new Intent(place.this, SelfEmpYES.class);
                    startActivity(i);
                } else if (b4.isChecked()) {
                    Intent i = new Intent(place.this, SelfEmpNO.class);
                    startActivity(i);
                }


            }


        });


    }
}
