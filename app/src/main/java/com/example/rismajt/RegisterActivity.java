package com.example.rismajt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtnama, edtAngkatan, edtEmail, edtPassword, edtWA;
    private Button btndaftar;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtnama = findViewById(R.id.edtnama);
        edtAngkatan = findViewById(R.id.edtAngkatan);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtWA = findViewById(R.id.edtWA);
        btndaftar = findViewById(R.id.btndaftar);

        progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Mendaftar...");

        btndaftar.setOnClickListener(v -> {
            if (edtnama.getText().length()>0 && edtAngkatan.getText().length()>0 && edtEmail.getText().length()>0 && edtPassword.getText().length()>0 && edtWA.getText().length()>12){
                saveData(edtnama.getText().toString(), edtAngkatan.getText().toString(), edtEmail.getText().toString(), edtPassword.getText().toString(), edtWA.getText().toString());
            }else {
                Toast.makeText(getApplicationContext(), "Silahkan isi semua data!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveData(String edtnama,String edtAngkatan ,String edtEmail, String edtPassword, String edtWA){
        Map<String, Object> user = new HashMap<>();
        user.put("edtnama", edtnama);
        user.put("edtAngkatan", edtAngkatan);
        user.put("edtEmail", edtEmail);
        user.put("edtPassword", edtPassword);
        user.put("edtWA", edtWA);

        progressDialog.show();
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"Berhasil!",Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });
    }
    public void Batal(View view) {
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
    }
}