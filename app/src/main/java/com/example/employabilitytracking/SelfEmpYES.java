package com.example.employabilitytracking;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class SelfEmpYES extends AppCompatActivity {

Button b;
    private RadioGroup r,r1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_emp_y_e_s);

        b=findViewById(R.id.okid);

        r=findViewById(R.id.rgid);
        r1=findViewById(R.id.rgid1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton rr3 = findViewById(R.id.radioButton9);
                RadioButton rr4= findViewById(R.id.radioButton10);
                RadioButton rr1 = findViewById(R.id.ip23);
                RadioButton rr2= findViewById(R.id.ip24);

                if(rr3.isChecked())
                {
                    Decider.selfyesfed1="yes";
                }
                else if(rr4.isChecked())
                {
                    Decider.selfyesfed1="no";
                }

                   else if (rr1.isChecked()) {
                        Decider.statusRad="currently working";

                    }
                    else if(rr2.isChecked()){
                        Decider.statusRad="Not Working";
                    }

                    Intent intent=new Intent(getApplicationContext(), Final.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                }

        });
    }
}
