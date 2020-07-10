package com.example.employabilitytracking;

;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class employerhome extends AppCompatActivity {
 Button b;
 EditText b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employerhome);
   b = findViewById(R.id.button13);
   b1=findViewById(R.id.editText24);
   b2=findViewById(R.id.editText25);
   b3=findViewById(R.id.editText26);
   b4=findViewById(R.id.editText28);
   b5=findViewById(R.id.editText29);
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

                Decider.reason21=b1.getText().toString();
                Decider.reason22=b2.getText().toString();
                Decider.reason23=b3.getText().toString();
                Decider.qual2=b4.getText().toString();
                Decider.empcand2=b5.getText().toString();

                Intent i = new Intent(employerhome.this, Employerfed.class);
                startActivity(i);
            }
        }
    });
    }

}
