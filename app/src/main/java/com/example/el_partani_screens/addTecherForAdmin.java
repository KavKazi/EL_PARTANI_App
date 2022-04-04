package com.example.el_partani_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.r0adkll.slidr.Slidr;

import java.util.ArrayList;

public class addTecherForAdmin extends AppCompatActivity implements View.OnClickListener {
    private Button btn_saveNewTecher,btn_goBackToMainForAdminFromeANT;
    EditText ETnewTecherName,ETnewTecherClass,ETnewTecherAvatar;
    ListView LVanpS;
    ArrayList<Profession> ProfessionList;
    professionAdapter professionAdapter;
    DatabaseReference teacherRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_techer_for_admin);
        Slidr.attach(this);

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

        ETnewTecherName = findViewById(R.id.ETnewTecherName);
        ETnewTecherClass = findViewById(R.id.ETnewTecherClass);
        ETnewTecherAvatar = findViewById(R.id.ETnewTecherAvatar);
        LVanpS = findViewById(R.id.LVanpS);
        btn_goBackToMainForAdminFromeANT = findViewById(R.id.btn_goBackToMainForAdminFromeANT);
        btn_saveNewTecher = findViewById(R.id.btn_saveNewTecher);
        btn_saveNewTecher.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

            if(addTeacher2Db()) {
                Intent intent = new Intent(addTecherForAdmin.this, adminMainScreen.class);
                startActivity(intent);
            }else{
                //todo- prompt error in adding teacher details
            }
        }

    private boolean addTeacher2Db() {
        //todo- input check
        String name = ETnewTecherName.getText().toString();
        String claas = ETnewTecherClass.getText().toString();

        Teacher t = new Teacher(name, claas);
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
        teacherRef = FirebaseDatabase.getInstance().getReference("Teachers").push();
        teacherRef.setValue(t);
        return true;

    }


}