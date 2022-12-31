package com.example.rismajt;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    EditText loginemail, loginpassword;
    Button buttonLogin;
    Button buttonRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        loginemail = findViewById(R.id.loginemail);
        loginpassword = findViewById(R.id.loginpassword);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateEmail() | !validatePassword()){

                }else {
                    Intent intent = new Intent(LoginActivity.this, home_page.class);
                    startActivity(intent);
                }
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    public Boolean validateEmail(){
        String val = loginemail.getText().toString();
            if (val.isEmpty()){
                loginemail.setError("Email cannot be empty!");
                return false;
            } else {
                loginemail.setError(null);
                return true;
            }
    }

    public Boolean validatePassword(){
        String val = loginpassword.getText().toString();
            if (val.isEmpty()){
                loginpassword.setError("Password cannot be empty!");
                return false;
            } else {
                loginpassword.setError(null);
                return true;
            }

    }

//    public void checkUser(){
//        String userEmail = loginemail.getText().toString().trim();
//        String userPassword = loginpassword.getText().toString().trim();
//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
//        Query checkUserDatabase = reference.orderByChild("email").equalTo(userEmail);
//
//        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                if (snapshot.exists()){
//                    loginemail.setError(null);
//                    String passwordFormDB = snapshot.child(userEmail).child("password").getValue(String.class);
//
//                    if (!Objects.equals(passwordFormDB, userPassword)){
//                        loginemail.setError(null);
//                        Intent intent = new Intent(LoginActivity.this, home_page.class);
//                        startActivity(intent);
//                    }else {
//                        loginpassword.setError("Invalid Credential");
//                        loginpassword.requestFocus();
//                    }
//                }else {
//                    loginemail.setError("User does not exist");
//                    loginemail.requestFocus();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
}