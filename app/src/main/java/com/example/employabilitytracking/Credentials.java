package com.example.employabilitytracking;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Credentials extends AppCompatActivity {
 private Button next;
AutoCompleteTextView b3,b4;
EditText  b1,b2,b5,b6,b7,b8;
    private static final String[] block= new String[]{"AUGUSTMUNI","BAGESHWAR","BAHADRABAD","BAJPUR","BARAKOT","BERINAG","BETALGHAT","BHAGWANPUR","BHAISIYA CHHANA","BHATWARI",
            "BHIKIYASAIN","BHILANGNA","BHIMTAL","BIRONKHAL","CHAKRATA","CHAMBA","CHAMPAWAT","CHAUKHUTIYA","CHINYALISAUR","DASHOLI","DEOPRAYAG","DEWAL","DHARCHULA","DHARI","DHAULADEVI",
            "DIDIHAT","DOIWALA","DUGGADA","DUNDA","DWARAHAT","DWARIKHAL","EKESHWAR","GADARPUR","GAIRSAIN","GANGOLIHAT","GARUR","GHAT","HALDWANI","HAWALBAG","JAKHNIDHAR","JAKHOLI","JASPUR"
            ,"JAUNPUR","JOSHIMATH","KALJIKHAL","KALSI","KANALICHINA","KAPKOTE","KARNAPRAYAG","KASHIPUR","KHANPUR","KHATIMA","KHIRSU","KIRTINAGAR","KOT","KOTABAG","LAKSAR","LAMGARA","LOHAGHAT"
            ,"MORI","MUNAKOT","MUNSYARI","NAINIDANDA","NARAYANBAGAR","NARENDRA NAGAR","NARSAN","NAUGAON","OKHALKANDA","PABAU","PATI","PAURI","PITHORAGARH","POKHARI","POKHRA","PRATAPNAGAR"
            ,"PUROLA","RAIPUR","RAMGARH","RAMNAGAR","RIKHNIKHAL","ROORKEE","RUDRAPUR","SAHASPUR","SITARGANJ","SULT","SYALDEY","TAKULA","TARIKHET","THALISAIN","THARALI","THAULDHAR","UKHIMATH"
            ,"VIKASNAGAR","YAMKESHWAR","ZAHRIKHAL"};

    private static final String[] district= new String[]{"ALMORA","BAGESHWAR","CHAMOLI","CHAMPAWAT","DEHRADUN","HARIDWAR","NAINITAL","PAURI GARHWAL","PITHORAGARH","RUDRA PRAYAG"
            ,"TEHRI GARHWAL","UDAM SINGH NAGAR","UTTAR KASHI"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credentials);
        next = (Button)findViewById(R.id.button);
        b1=findViewById(R.id.editText27);
        b2=findViewById(R.id.nameid);
        b3=findViewById(R.id.addressid);
        b4=findViewById(R.id.cityid);
        b5=findViewById(R.id.districtid);
        b6=findViewById(R.id.editText);
        b7=findViewById(R.id.editText2);
        b8=findViewById(R.id.editText4);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,block);
        b3.setAdapter(adapter);
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,district);
        b4.setAdapter(adapter1);
        next.setOnClickListener(new View.OnClickListener() {
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
                else if(b6.length()==0)
                {
                    b6.setError("field cannot be empty");
                }
                else if(b7.length()==0)
                {
                    b6.setError("field cannot be empty");
                }
                else if(b8.length()==0)
                {
                    b6.setError("field cannot be empty");
                }


                else {

                    Decider.name1=b1.getText().toString();
                    Decider.village1=b2.getText().toString() ;
                    Decider.block1=b3.getText().toString();
                    Decider.mandal1=b4.getText().toString();
                    Decider.resadd1=b5.getText().toString();
                    Decider.phone1=b6.getText().toString();
                    Decider.aadhar1=b7.getText().toString();
                    Decider.ref1=b8.getText().toString();
                    Intent i = new Intent(Credentials.this, courseDET.class);
                    startActivity(i);
                }
            }
        });
    }
}
