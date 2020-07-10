package com.example.employabilitytracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Final3Months extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final3_months);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("candidate").child(ChatListAdapter.aadh11);
        Button b = findViewById(R.id.button11);

        Long tsLong = System.currentTimeMillis();
        String ts = Long.toString(tsLong);

        HashMap time=new HashMap();
        time.put("timestamp", ts);

        Map months = new HashMap();


        if(Decider.r3.equals("x"))
        {
            months.put("Are you currently employed with the same employer",Decider.r1);

        }
        if(Decider.r3.equals("y"))
        {
            months.put("Are you currently employed with the same employer",Decider.r1);

        }
        if(Decider.r3.equals("z"))
        {
            months.put("Are you currently employed",Decider.r1);

        }
        if(Decider.r3.equals("a"))
        {
            months.put("Are you currently employed",Decider.r1);

        }
        if(Decider.r3.equals("b"))
        {
            months.put("Are you self employed",Decider.r1);

        }
        if(Decider.r3.equals("c"))
        {
            months.put("Are you self employed",Decider.r1);

        }

        Map newdata = new HashMap<>();

        newdata.put("After Months",months);
        reference.updateChildren(time);
        reference.updateChildren(newdata);



      b.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i = new Intent(getApplicationContext(),Decider.class);
              startActivity(i);
          }
      });
    }
}
