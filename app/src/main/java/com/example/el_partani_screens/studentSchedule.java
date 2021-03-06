package com.example.el_partani_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class studentSchedule extends AppCompatActivity {
    ListView lsvoss;
    FloatingActionButton btn_moveToPS;
    Dialog dialogss;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_schedule_screen);

        lsvoss = findViewById(R.id.lvStudentSchedule);
        ArrayList<Teacher_schedule_row> arr = new ArrayList<>();
        arr.add(new Teacher_schedule_row(R.drawable.teacherpic4,11,"יום ראשון שיעור רביעי:"));
        arr.add(new Teacher_schedule_row(R.drawable.teacherpic1,8,"יום שני שיעור ראשון:"));
        arr.add(new Teacher_schedule_row(R.drawable.teacherpic6,10,"יום חמישי שיעור שלישי:"));

        Teacher_scheduleAdapter adapter = new Teacher_scheduleAdapter(this,0,arr);
        lsvoss.setAdapter(adapter);
        dialogss = new Dialog(studentSchedule.this);
        dialogss.setContentView(R.layout.custom_dialog_sss);
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            dialogss.getWindow().setBackgroundDrawable(getDrawable(R.drawable.bg_teacher_schedule));
        }
        dialogss.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogss.setCancelable(false);

        Button btn_okey_tss = dialogss.findViewById(R.id.btn_okey_tss);
        Button btn_cancel_tss = dialogss.findViewById(R.id.btn_cancel_tss);

        btn_okey_tss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(studentSchedule.this, "you deleted your apoiment in this hour. :)", Toast.LENGTH_SHORT).show();
                dialogss.dismiss();
            }
        });
        btn_cancel_tss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(studentSchedule.this, "you saved your apoiment in this hour. :(", Toast.LENGTH_SHORT).show();
                dialogss.dismiss();
            }
        });
        lsvoss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialogss.show();
            }
        });

        btn_moveToPS = findViewById(R.id.btn_moveToPS);
        btn_moveToPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(studentSchedule.this, Profession_screen.class));            }
        });

    }
}