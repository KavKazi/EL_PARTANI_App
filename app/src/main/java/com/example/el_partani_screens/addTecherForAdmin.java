package com.example.el_partani_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.r0adkll.slidr.Slidr;

public class addTecherForAdmin extends AppCompatActivity implements View.OnClickListener {
    private Button btn_saveNewTecher,btn_goBackToMainForAdminFromeANT;
    EditText ETnewTecherName,ETnewTecherClass,ETnewTecherAvatar;
    DatabaseReference teacherRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_techer_for_admin);

        Slidr.attach(this);


        ETnewTecherName = findViewById(R.id.ETnewTecherName);
        ETnewTecherClass = findViewById(R.id.ETnewTecherClass);
        ETnewTecherAvatar = findViewById(R.id.ETnewTecherAvatar);
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
        String subject = ETnewTecherClass.getText().toString();
        String phone = ETnewTecherAvatar.getText().toString();
        Teacher t = new Teacher(name, subject, phone);
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
        teacherRef = FirebaseDatabase.getInstance().getReference("Teachers").push();
        teacherRef.setValue(t);
        return true;

    }


}