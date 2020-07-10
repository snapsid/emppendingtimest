package com.example.employabilitytracking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class courseDET extends AppCompatActivity {
private LinearLayout l;
private Button b,b23;
private EditText b3,b4;
    AutoCompleteTextView b2,b1;
    private static final String[] centreName= new String[]{"WEBLINE K01","Power To Empower Skills Private Limited","SSDC - US Nagar","LIFE CHAMOLI","De Unique Skill Training Centre"
            ,"Bhavya Skills Training Institute","Skillpro Technologies Learning Center Bahadrabad","PMKVY JITM Dehradun","LALA RAJA RAM SHIKSHA SAMITI","PMKVY JITM DIDI HAT Pithoragarh",
            "PMKVY JITM Barechina Almora","PMKVY JITM Champawat","PMKVY JITM Someshwar Almora","PMKVY JITM Hali Haldwani Uttar Ujala","Dhanya Infomedia Private Limited","PMKVY JITM Gangolighat Pithoragarh","PMKVY JITM Garur Bageshwar",
            "Shugan Hospitality Pvt Ltd","Kaaya Learning Centre","INLM Dehradun","GD Goenka Skills_Tehrigarhwal","Ascent Skill Development Center-Dehradun","LIFE UTTARKASHI","Tech Mech International Pvt Ltd Pauri","Mahila Utthan Evam Bal Kalyan Sansthan"
            ,"Marg Academy Haldwani","Asset Infotech Limited - Haridwar","Neel Metal Products Limited SDC","Ascent Skill Development Center - Haldwani","Sarv Jan Sarv Dharm Hitaye Sewa Samiti","Amass Skill Ventures Pvt. Ltd.",
            "Aarnova Skill Centre","LIFE PAURI","LIFE HARIDWAR","LIFE DEHRADUN","INLM Rudrapur","BHARTIYA PRODHUAGIKI EVAM UDYAMI VIKAS SANSTHAN","NNOVERS INFO LEARNING PRIAVTE LIMITED","Dexter Skill Development Centre US NAGAR",
            "KDM Dehradun2","GD Goenka Skills_Ramnagar Nainital","Marg Academy Dehradun","Ascent Skill Development Center - Khatima","LALA RAJA RAM SHIKSHA SAMITI","GRAMIN SHIKSHA SKILL DEVELOPMENT CENTER","PMKVY JITM Kapkote Bageshwar",
            "PMKVY JITM Dwarahat Almora","PMKVY JITM Haldwani","Uttarakhand Institute of Education & Technology","Youth Educational Society","SHUGAN GARHINEGI","S. G. B. G. MEMORIAL P. G. COLLEGE","GD Goenka Skills_Ranikhet Almora"
            ,"Kdm Dehradun","Dexter Skill Development Centre Haridwar","SHUGAN RUDRAPUR","Marg Academy Roorkee","Sarv Jan Sarv Dharm Hitaye Sewa Samiti","Sarvodaya Institute Of Electric And Welding","GEWAR SANKALP SAMITI",
            "TECHNOPAK CENTRE 9","TECHNOPAK CENTRE 7","TECHNOPAK CENTRE 1","Technopak Manglour Roorkee","Technopak Haldwani Center","Technopak Centre 3","Technopak Centre 4","Technopak Centre 6","Technopak Centre 5","Technopak Centre 8"
            ,"Technopak Centre 2","Daksh Institute Of Hotel Management","Gurcharan Foundation Roshnabad","Aarnova Skill Centre","Fly Wings Skill Development Center","Anamaya Inc","Amazon Institute Of Hotel Tourism & management"
            ,"Anamaya Inc","Skillpro Jamunikhal","Skillpro Almora","FACE Skill Center","ASSET INFOTECH LIMITED","Taqgene training & research Institute","Ansi Skill Development Training Centre","Sarvodaya Skill Development Center",
            "GKVS Skill Center","Amity Education Services Pvt Ltd","Skillpro Technologies Learning Center","Skillpro Technologies Learning Center- Govindghar","Fusion Institute Of Hotel Management","N. I. A. C. E. Foundation"
            ,"Society for Promotion of Youth & Mass","Bhavya Skills Training Institute","Rockman Skill Development Centre","VAP TECHNOLOGY"};


    private static final String[] courseName= new String[]{"Documentation Assistant","Trainee Chef","Housekeeper cum Cook","Sewing Machine Operator","Food & Beverage Service - Steward","Self Employed Tailor"
            ,"Web Developer","Multi-Cuisine Cook","Domestic IT Helpdesk Attendant","Consignment Booking Assistant","Broadband Technician","Field Technician Computing And Peripherals","Sewing Machine Operator","Mobile Phone Hardware Repair Technician"
            ,"CCTV Installation Technician","Solar Panel Installation Technician","Field Technician Networking And Storage","Solar Panel Installation Technician","Organic Grower","Draughtsman Mechanical","Consignment Booking Assistant"
            ,"Airline Cabin Crew","Field Technician Ups And Inverter","Retail Trainee Associate","Assistant Spa Therapist","Quality Seed Grower","Floriculturist-Open Cultivation","Housekeeping Attendant (Manual Cleaner)",
            "Mason Tiling","Mason General","General Duty Assistant","Front Office Associate","General Duty Assistant","Assistant Electrician","Manual Metal Arc Welding/ Shielded Metal Arc Welding Welder",
            "Stitching Operator","Fitter Fabrication","Welding Technician Level 3","LED Light Repair Technician","Animal Health Worker","EMS Technician","Medical Laboratory Technician","Electrical Technician","Emergency Medical Technician (EMT) - Advanced"
            ,"Home Delivery Boy","Counter Sales Executive","Retail Trainee Associate","Assistant Electrician","Field Engineer RACW","Customer Care Executive-Call Center","Pedicurist and Manicurist","Front Office Executive"
            ,"Secretary","Assistant Beauty Therapist","Airline Customer Service Executive","CRM Domestic Voice","Junior Software Developer","Broadband Technician","Mushroom Grower","Web Developer","Retail Team Leader"
            ,"Domestic IT Helpdesk Attendant","CRM Domestic Voice","Draughtsman Mechanical","CNC Operator Turning","Fitter Mechanical Assembly"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_d_e_t);
        l=(LinearLayout)findViewById(R.id.ap1);

        b=(Button)findViewById(R.id.button7);
        b23=(Button)findViewById(R.id.ip5);
         b1=findViewById(R.id.editText3);
        b2 = findViewById(R.id.editText41);
        b3 = findViewById(R.id.editText42);
        b4 = findViewById(R.id.editText43);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,centreName);
        b2.setAdapter(adapter);
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,courseName);
        b1.setAdapter(adapter1);



     b23.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

              if (b2.length() == 0) {
                 b2.setError("field cannot be empty");
             } else if (b3.length() == 0) {
                 b3.setError("field cannot be empty");
             } else if (b4.length() == 0) {
                 b4.setError("field cannot be empty");
             } else {

                 Decider.coursename1=b1.getText().toString();
                 Decider.centername1=b2.getText().toString();
                 Decider.centeradd1=b3.getText().toString();
                 Decider.centerid1=b4.getText().toString();
                 Intent i = new Intent(courseDET.this, place.class);
                 startActivity(i);
             }
         }
     });
    }
}
