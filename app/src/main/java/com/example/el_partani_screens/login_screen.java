package com.example.el_partani_screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login_screen extends AppCompatActivity {
    Button login_btn, toSignUp_btn;
    EditText inputName,inputEmail,inputPassword;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        inputName = findViewById(R.id.inputNameLIS);
        inputEmail = findViewById(R.id.inputEmailLIS);
        inputPassword = findViewById(R.id.inputPasswordLIS);
        login_btn = findViewById(R.id.loginbtnLIS);
        toSignUp_btn = findViewById(R.id.toSignUp_btnLIS);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        toSignUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((v == toSignUp_btn)) {
                    Intent intent = new Intent(login_screen.this, Signup_screen.class);
                    startActivity(intent);
                }
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perForLogin();
            }
        });
    }

    private void perForLogin() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();


        if (!email.matches(emailPattern)) {
            inputEmail.setError("ENTER CORECT EMIAL");
            inputEmail.requestFocus();
        } else if (password.isEmpty() || password.length() < 6) {
            inputPassword.setError("ENTER PROPER PASSWORD");
            inputPassword.requestFocus();

        } else {
            progressDialog.setMessage("Please wait while Login...");
            progressDialog.setTitle("LOGIN");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(login_screen.this, "Login succesful", Toast.LENGTH_SHORT).show();
                    } else{
                        progressDialog.dismiss();
                        Toast.makeText(login_screen.this, "" + task.getException(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
    private void sendUserToNextActivity () {
        if(FirebaseAuth.getInstance().getCurrentUser().getUid().equals("iG5d65Ml2JhzechQzHGNBVqYVci2"))
            startActivity(new Intent(getApplicationContext(), WeTrip.class));
        else{
            Intent intent = new Intent(login_screen.this, studentSchedule.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}


