package com.example.rismajt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmail = findViewById(R.id.edtEmail);
        editTextPassword = findViewById(R.id.edtPassword);
    }
    public void postLogin(View view) {
        if (TextUtils.isEmpty(editTextEmail.getText().toString().trim())
                &&
                TextUtils.isEmpty(editTextPassword.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email dan Password tidak Boleh Kosong", Toast.LENGTH_LONG).show();
        }
        if (TextUtils.isEmpty(editTextEmail.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
        else
        if (!isValidEmail(editTextEmail.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email Tidak Valid", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(editTextPassword.getText().toString())) {
            Toast.makeText(view.getContext(), "Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(LoginActivity.this, home_page.class);
            startActivity(i);
        }
    }
    public void postRegister(View view) {
        Intent i = new Intent(LoginActivity.this, TambahPendidikan.class);
        startActivity(i);

    }
    public static boolean isValidEmail (CharSequence email){
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}