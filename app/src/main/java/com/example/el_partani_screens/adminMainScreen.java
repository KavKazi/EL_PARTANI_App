package com.example.el_partani_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminMainScreen extends AppCompatActivity implements View.OnClickListener {
    private Button btn_goToAddTecharScreen,btn_goToAddProfessionScreen,btn_goToAddPrivateHourScreen;
    //TODO - check if realtime database retrive and saves daya from all places

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_screen);

       
        btn_goToAddTecharScreen.setOnClickListener(this);

/* btn_goToAddTecharScreen = findViewById(R.id.btn_goToAddTecharScreen);
        btn_goToAddProfessionScreen = findViewById(R.id.btn_goToAddProfessionScreen);
        btn_goToAddPrivateHourScreen = findViewById(R.id.btn_goToAddPrivateHourScreen);*/    }
    public void onClick(View v) {
        if(v == btn_goToAddTecharScreen){
                Intent intent = new Intent(adminMainScreen.this, addTecherForAdmin.class);
                startActivity(intent);
            }
        else if (v ==btn_goToAddProfessionScreen){
            Intent intent = new Intent(adminMainScreen.this, addProfessionForAdmin.class);
            startActivity(intent);
            }
        else if (v ==btn_goToAddPrivateHourScreen){
            Intent intent = new Intent(adminMainScreen.this, addPrivateHourForAdmin.class);
            startActivity(intent);
        }
        }
}