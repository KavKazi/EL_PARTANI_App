package com.example.el_partani_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.r0adkll.slidr.Slidr;

public class addProfessionForAdmin extends AppCompatActivity implements View.OnClickListener  {
    private Button btn_saveNewProfession,btn_goBackToMainForAdminFromeANP;
    EditText ETnewProfessionName,ETnewProfessionImg;
    DatabaseReference professionRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profession_for_admin);

        Slidr.attach(this);


        ETnewProfessionName = findViewById(R.id.ETnewProfessionName);
        ETnewProfessionImg = findViewById(R.id.ETnewProfessionImg);
        btn_goBackToMainForAdminFromeANP = findViewById(R.id.btn_goBackToMainForAdminFromeANP);
        btn_saveNewProfession = findViewById(R.id.btn_saveNewProfession);
        btn_saveNewProfession.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v==btn_goBackToMainForAdminFromeANP){
            Intent intent = new Intent(addProfessionForAdmin.this, adminMainScreen.class);
            startActivity(intent);
        }
        else if(v == btn_saveNewProfession){
            if(addPtofession2Db()) {
                Intent intent = new Intent(addProfessionForAdmin.this, Profession_screen.class);
                startActivity(intent);
            }else{
                //todo- prompt error in adding teacher details
            }
        }

    }

    private boolean addPtofession2Db() {
        //todo- input check
        String name = ETnewProfessionName.getText().toString();
        //String img = ETnewProfessionImg.getText().toString();
        //todo - צריך להוסחף תמונה למקצוע

        Profession p = new Profession(name);
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
        professionRef = FirebaseDatabase.getInstance().getReference("Profession").push();
        professionRef.setValue(p);
        return true;

    }
}