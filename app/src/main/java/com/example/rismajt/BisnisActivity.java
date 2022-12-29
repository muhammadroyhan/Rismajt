package com.example.rismajt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.rismajt.databinding.ActivityBisnisBinding;
import com.example.rismajt.databinding.ActivityMemberBinding;

public class BisnisActivity extends AppCompatActivity {
    ActivityBisnisBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBisnisBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if(intent != null){
            String nama = intent.getStringExtra("nama");
            String angkatan = intent.getStringExtra("angkatan");
            String alamat = intent.getStringExtra("alamat");
            String namab = intent.getStringExtra("namab");
            String email = intent.getStringExtra("email");
            String produk = intent.getStringExtra("produk");
            String nohp = intent.getStringExtra("nohp");
            String bidang = intent.getStringExtra("bidang");

            int imageid = intent.getIntExtra("imageId",R.drawable.no_image);

            binding.namaProfile.setText(nama);
            binding.angkatan.setText(angkatan);
            binding.alamatBisnis.setText(alamat);
            binding.namaBisnis.setText(namab);
            binding.usahaProfile.setImageResource(imageid);
            binding.emailBisnis.setText(email);
            binding.produk.setText(produk);
            binding.nomorHP.setText(nohp);
            binding.bidangUsaha.setText(bidang);
        }
    }
}