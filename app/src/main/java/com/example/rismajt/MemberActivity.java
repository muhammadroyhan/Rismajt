package com.example.rismajt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.rismajt.databinding.ActivityMemberBinding;

public class MemberActivity extends AppCompatActivity {

    ActivityMemberBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMemberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if(intent != null){
            String nama = intent.getStringExtra("nama");
            String angkatan = intent.getStringExtra("angkatan");
            String alamat = intent.getStringExtra("alamat");
            String bisnis = intent.getStringExtra("bisnis");
            String email = intent.getStringExtra("email");
            String kampus = intent.getStringExtra("kampus");
            String jenjang = intent.getStringExtra("jenjang");
            String jurusan = intent.getStringExtra("jurusan");

            int imageid = intent.getIntExtra("imageId",R.drawable.men1);

            binding.namaProfile.setText(nama);
            binding.angkatanProfile.setText(angkatan);
            binding.alamatProfile.setText(alamat);
            binding.bisnisProfile.setText(bisnis);
            binding.profileImage.setImageResource(imageid);
            binding.emailProfile.setText(email);
            binding.kampusProfile.setText(kampus);
            binding.jenjangProfile.setText(jenjang);
            binding.jurusanProfile.setText(jurusan);
        }
    }
}