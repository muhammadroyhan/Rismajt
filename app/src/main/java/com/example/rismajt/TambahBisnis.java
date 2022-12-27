package com.example.rismajt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TambahBisnis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_bisnis);
    }
    public void btnTambah(View view) {
        Intent i = new Intent(TambahBisnis.this, home_page.class);
        startActivity(i);
    }
}