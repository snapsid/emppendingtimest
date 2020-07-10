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

public class FinalEmployer extends AppCompatActivity {

    Button addbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_employer);

        addbut=findViewById(R.id.addid);

       DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("employer").child(Decider.aadhar2);


        Map review=new HashMap<>();

        if(Decider.stillemp.equals("yes"))
        {

            review.put("reason for selecting", Decider.reasforsel2);
        }

        if(Decider.stillemp.equals("no"))
        {

            review.put("reason for leaving the job", Decider.reasforfir2);
        }

        if(Decider.collab2.equals("yes"))
        {
            review.put("would the employer like to collaborate with other programs",Decider.collabskill2);
        }
        if(Decider.collab2.equals("no"))
        {
            review.put("would the employer like to collaborate with other programs",Decider.collabskill2);
        }



        Map employerData=new HashMap<>();

        employerData.put("name", Decider.name2);
        employerData.put("address", Decider.address2);
        employerData.put("phone", Decider.phone2);
        employerData.put("res address", Decider.resadd2);
        employerData.put("phone", Decider.phone2);

        employerData.put("reason1", Decider.reason21);
        employerData.put("reason2", Decider.reason22);
        employerData.put("reason3", Decider.reason21);
        employerData.put("quality", Decider.qual2);
        employerData.put("num of employed candidate", Decider.empcand2);
        employerData.put("candidate still employed", Decider.stillemp);
        employerData.put("collaboration with other skilling programs", Decider.collab2);
        employerData.put("review", review);


        reference.updateChildren(employerData);


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
