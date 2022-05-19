package com.example.el_partani_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.r0adkll.slidr.Slidr;

import java.util.ArrayList;

public class addNewProfession extends AppCompatActivity {
    private static final String[]PROFESSION=new String[]{
            "מטמתיקה", "אנגלית", "אזרחות", "ספרות","מדעי המחשב",
    };
    private static final String[]LEVELS=new String[]{
            "א", "ב", "ג", "3"," 4","5"
    };
    ArrayList<Profession> ProfessionList;
    professionAdapter professionAdapter;
    ListView LVanpS;
    Button btn_saveNewProfession,btn_moveToPs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_profession);

        AutoCompleteTextView edittext =findViewById(R.id.ACTnewProfessionName);
        AutoCompleteTextView edittext2 =findViewById(R.id.ATCnewProfessionLevel);

        Profession p1= new Profession("אנגלית");
        Profession p2= new Profession("מדעי המחשב");
        Profession p3= new Profession("ספורט");
        Profession p4= new Profession("אזרחות");
        Profession p5= new Profession("ספרות");
        Profession p6= new Profession("לשון");

        ProfessionList = new ArrayList<>();
        ProfessionList.add(p1);
        ProfessionList.add(p2);
        ProfessionList.add(p3);
        ProfessionList.add(p4);
        ProfessionList.add(p5);
        ProfessionList.add(p6);

        //professionAdapter = new professionAdapter(this,"",0,ProfessionList);
        LVanpS = findViewById(R.id.LVanpS);
        LVanpS.setAdapter((ListAdapter) professionAdapter);

        LVanpS =findViewById(R.id.LVanpS);
        btn_saveNewProfession =findViewById(R.id.btn_saveNewProfession);
        btn_moveToPs =findViewById(R.id.btn_moveToPs);
        ArrayAdapter<String>adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,PROFESSION);
        edittext.setAdapter(adapter);
        ArrayAdapter<String>adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,LEVELS);
        edittext2.setAdapter(adapter2);

        btn_saveNewProfession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //לשמור את המקצוע לתוך הפייר בייס ולעשות TOAST
            }
        });

        btn_moveToPs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(addNewProfession.this, Profession_screen.class));

            }
        });
        //צריך לסדר את הקטע שאתה מחליק אחורה אז זה מחזיר רק למסך שאני רוצה ולא לכל מסך שהיה לפני.







    }
}