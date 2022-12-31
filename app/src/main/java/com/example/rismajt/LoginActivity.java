package com.example.rismajt;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin;
    private Button buttonRegister;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    EditText editTextEmail;
    EditText editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        editTextEmail = findViewById(R.id.edtEmail);
        editTextPassword = findViewById(R.id.edtPassword);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonLogin = findViewById(R.id.buttonLogin);

        db.collection("Users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Data gagal di ambil!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        buttonRegister.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
        });
    }
//    public void postLogin(View view) {
//        if (TextUtils.isEmpty(editTextEmail.getText().toString().trim())
//                &&
//                TextUtils.isEmpty(editTextPassword.getText().toString().trim())) {
//            Toast.makeText(view.getContext(), "Email dan Password tidak Boleh Kosong", Toast.LENGTH_LONG).show();
//        }
//        if (TextUtils.isEmpty(editTextEmail.getText().toString().trim())) {
//            Toast.makeText(view.getContext(), "Email Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
//        }
//        else
//        if (!isValidEmail(editTextEmail.getText().toString().trim())) {
//            Toast.makeText(view.getContext(), "Email Tidak Valid", Toast.LENGTH_SHORT).show();
//        }
//        else if (TextUtils.isEmpty(editTextPassword.getText().toString())) {
//            Toast.makeText(view.getContext(), "Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
//        } else {
//            Intent i = new Intent(LoginActivity.this, home_page.class);
//            startActivity(i);
//        }
//    }
//    public void clickLupa(View view) {
//        Intent i = new Intent(LoginActivity.this, ForgotActivity.class);
//        startActivity(i);
//    }
//    public static boolean isValidEmail (CharSequence email){
//        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
//    }
}