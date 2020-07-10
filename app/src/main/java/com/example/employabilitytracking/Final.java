package com.example.employabilitytracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;



public class Final extends AppCompatActivity {

    Button addbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        addbut=findViewById(R.id.addid);

        Long tsLong = System.currentTimeMillis();
        String ts = Long.toString(tsLong);







        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("candidate").child(Decider.aadhar1);




        Map placeyes=new HashMap();

        if(Decider.placement.equals("yes"))
        {
            placeyes.put("employer name",Decider.nameemp1 );
            placeyes.put("trade",Decider.trade1 );
            placeyes.put("salary", Decider.sal1);
            placeyes.put("contract",Decider.poc1 );
            placeyes.put("probation offered",Decider.prob1 );
        }

        if(Decider.placement.equals("no"))
        {
            placeyes.put("reason", Decider.reasnojob1);
            placeyes.put("skill lacking", Decider.skills1);
            placeyes.put("desired skill", Decider.dskills1);

        }

        Map selfyes=new HashMap();


        if(Decider.self.equals("yes")) {
            selfyes.put("Did skill center help you?", Decider.selfyesfed1);
            selfyes.put("current status", Decider.statusRad);
        }


        if(Decider.self.equals("no"))
        {

            selfyes.put("reason", Decider.nworkself1);
        }












        Map userData=new HashMap<>();

        userData.put("name1", Decider.name1);
        userData.put("city", Decider.village1);
        userData.put("block", Decider.block1);
        userData.put("district", Decider.mandal1);
        userData.put("address", Decider.resadd1);
        userData.put("course name", Decider.coursename1);
        userData.put("centre", Decider.centername1);
        userData.put("centre address", Decider.centeradd1);
        userData.put("centre id", Decider.centerid1);
        userData.put("phone",Decider.phone1);
        userData.put("referral code:",Decider.ref1);
        userData.put("placement info", placeyes);
        userData.put("selfemployment info", selfyes);
        userData.put("placement", Decider.placement);
        userData.put("self employed", Decider.self);
        userData.put("timestamp", ts);
        userData.put("aadhar", Decider.aadhar1);
       

        reference.updateChildren(userData);



        addbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Decider.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });



    }
}
