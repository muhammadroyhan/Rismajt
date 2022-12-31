package com.example.rismajt;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class RegisterActivity extends AppCompatActivity {
    EditText signupName, signupAngkatan, signupEmail, signupPassword, signupWa;
    Button btndaftar;
    Button btnbatal;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signupName = findViewById(R.id.signupName);
        signupAngkatan = findViewById(R.id.signupAngkatan);
        signupEmail = findViewById(R.id.signupEmail);
        signupPassword = findViewById(R.id.signupPassword);
        signupWa = findViewById(R.id.signupWa);
        btndaftar = findViewById(R.id.btndaftar);
        btnbatal = findViewById(R.id.btnbatal);

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = signupName.getText().toString();
                String angkatan = signupAngkatan.getText().toString();
                String email = signupEmail.getText().toString();
                String password = signupPassword.getText().toString();
                String wa = signupWa.getText().toString();

                users users = new users(name, angkatan, email, password, wa);
                reference.child(name).setValue(users);

                Toast.makeText(RegisterActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
        btnbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}