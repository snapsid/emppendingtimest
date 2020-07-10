package com.example.employabilitytracking;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Decider extends AppCompatActivity {

    public Button pending;

    public static String placement="no";
    public static String self="no";

    public  static String stillemp;

    public static String statusRad="";
    public static String selfyesfed1="";


    private RadioGroup r;
  public static String name1,village1,block1,mandal1,resadd1,phone1,coursename1,centername1,centeradd1,centerid1,leave1,fired1,exp1,reasnojob1,skills1,dskills1,nameemp1,trade1,sal1,poc1,prob1,selfxp1,nworkself1;
  public static String workexp1,recom1,aadhar1,ref1;
  public static String name2,address2,aadhar2,resadd2,phone2,reasforfir2,reasforsel2,reason21,reason22,reason23,qual2,empcand2;
  public static String collab2,collabskill2;
  public static String r1;
  public static String r3;
  public static String r4="after months";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decider);

        pending=(Button) findViewById(R.id.pendingid);

        Button next1 = findViewById(R.id.button6);
        Button clear = findViewById(R.id.button2);
        r=findViewById(R.id.rad1);
        r.clearCheck();



        pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(), MainChatActivity.class);
                startActivity(intent);

            }
        });





        next1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               RadioButton b1 = findViewById(R.id.ap3);
               RadioButton b2 = findViewById(R.id.ap4);
               if (b1.isChecked()) {
                   Intent i = new Intent(Decider.this, CheckAadhar.class);
                   startActivity(i);
               }
               else if (b2.isChecked()) {
                   Intent i = new Intent(Decider.this, CredEmp.class);
                   startActivity(i);
               }
               else
               {
                   r.clearCheck();
               }

           }


       });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.clearCheck();
                Toast.makeText(Decider.this, "No buttons pressed",Toast.LENGTH_SHORT).show();
            }
        });

       }
    }



