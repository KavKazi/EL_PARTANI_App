package com.example.el_partani_screens;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class WeTrip extends AppCompatActivity {
    Button btn_add, btnAll;
    DatabaseReference proffessionRef;
    ListView listView_profession;
    ArrayList<Profession>professions;
    AllPRofessionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we_trip);
        Profession pr1 = new Profession("math");
        proffessionRef = FirebaseDatabase.getInstance().getReference("Profession").push();
        listView_profession = findViewById(R.id.lv_professions);

        btn_add = findViewById(R.id.btn_add_wetrip);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProfession2Firebase(pr1);
            }
        });

        btnAll = findViewById(R.id.btn_all);
        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrivedata();
            }
        });
    }

    private void retrivedata() {
        proffessionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                professions = new ArrayList<Profession>();


                for(DataSnapshot data : dataSnapshot.getChildren())
                {
                    Profession p = data.getValue(Profession.class);
                    professions.add(p);
                    Log.d("ofri", p.getName());
                }


                adapter = new AllPRofessionAdapter(WeTrip.this,
                        0,0,professions);

                listView_profession.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addProfession2Firebase(Profession pr1) {

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();

       // Post p = new Post(et_title.getText().toString(),et_body.getText().toString(), uid, "" );

        proffessionRef = FirebaseDatabase.getInstance().getReference("Profession").push();
        //p.key = proffessionRef.getKey();
        proffessionRef.setValue(pr1);
    }


}