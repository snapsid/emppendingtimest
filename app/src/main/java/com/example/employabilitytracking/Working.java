package com.example.employabilitytracking;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Working extends AppCompatActivity {
EditText b1,b2;
Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working);
        b1=findViewById(R.id.editText13);
        b2=findViewById(R.id.editText14);

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
                else
                {


                    Decider.workexp1=b1.getText().toString();
                    Decider.recom1=b2.getText().toString();

                    Intent intent=new Intent(getApplicationContext(), Final.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }

            }
        });


    }
}
