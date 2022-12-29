package com.example.rismajt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;


import com.example.rismajt.databinding.ActivityDataBisnisBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class DataBisnis extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActivityDataBisnisBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityDataBisnisBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Data Bisnis");

        String[] namab = {"Salamadinah Travel Umroh","Nabil Tour & Travel","Griya Persada","Sembako","Healtycare","Sinar Rembulan","Tunas Agri Farm","UD Barokah","PT Rutan",};
        String[] alamat = {"Jl Teluk Gong Raya 6 Dki Jakarta","Jl Proklamasi 56 Dki Jakarta","Jl Pemuda 33-37 Plaza Surabaya Lt 2 Jawa Timur","Jl Cikini Raya 84-86 Ged Cik's Dki Jakarta","Jl North Kav 34 Dki Jakarta","Jl Abdul Majid Raya 17, Dki Jakarta","Pasar Genteng Q1Genteng","Komplek Ciharum 24 RT 02/06"," Jl Pd Kacang Prima Bl I-2/5"};
        String[] email = {"andiarpratama@gmail.com","indahpuspita1@gmail.com","khansaltf@gmail.com","w.astuti@gmail.com","kurnia123@gmail.com","fadlimustofa@gmail.com","sabrina@gmail.com","salsabilaf@gmail.com","maharani@gmail.com"};
        String[] bidang = {"Wisata","Wisata","Perdagangan","Perdagangan","Kesehatan","Perdagangan","Pertanian","Perdagangan","Perdagangan"};
        String[] nohp = {"628545542750","628562845728","628574949448","628567691156","628522498782","628555182577","628512399158","628564916165","628534369887"};
        String[] produk = {"-","-","-","-","-","-","-","-","-"};
        String[] nama = {"Andiar Pratama","Indah Puspita","Khansa Lutfia","Widya Astuti","Kurnia Sandi","Fadli Mus","Sabrina","Salsabilla Fatimah","Maharani"};
        String[] angkatan = {"2020","2019","2019","2020","2018","2018","2019","2019","2021"};
        int[] imageId = {R.drawable.no_image,R.drawable.no_image,R.drawable.no_image,R.drawable.no_image,R.drawable.no_image,R.drawable.no_image,R.drawable.no_image,R.drawable.no_image,R.drawable.no_image,};

        ArrayList<Bisnis> bisnisArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){
            Bisnis bisnis = new Bisnis(namab[i],bidang[i],alamat[i],email[i],nohp[i],produk[i],nama[i],angkatan[i],imageId[i]);
            bisnisArrayList.add(bisnis);
        }
        BisnisAdapter bisnisAdapter = new BisnisAdapter(DataBisnis.this,bisnisArrayList);

        binding.bisnisview.setAdapter((android.widget.ListAdapter) bisnisAdapter);
        binding.bisnisview.setClickable(true);
        binding.bisnisview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent i = new Intent(DataBisnis.this,BisnisActivity.class);
                i.putExtra("namab",namab[position]);
                i.putExtra("bidang",bidang[position]);
                i.putExtra("alamat",alamat[position]);
                i.putExtra("email",email[position]);
                i.putExtra("nohp",nohp[position]);
                i.putExtra("produk",produk[position]);
                i.putExtra("nama",nama[position]);
                i.putExtra("angkatan",angkatan[position]);
                i.putExtra("imageId",imageId[position]);
                startActivity(i);
            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle drawerToggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Intent intent2 = new Intent(DataBisnis.this,home_page.class);
                        startActivity(intent2);
                        break;
                    case R.id.editProfil:

                    case R.id.tambahPendidikan:
                        Intent intent = new Intent(DataBisnis.this,TambahPendidikan.class);
                        startActivity(intent);
                        break;
                    case R.id.tambahBisnis:
                        Intent intent1 = new Intent(DataBisnis.this,TambahBisnis.class);
                        startActivity(intent1);
                        break;
                    case R.id.tambahKarir:
                        Intent intent3 = new Intent(DataBisnis.this,TambahKarir.class);
                        startActivity(intent3);
                        break;
                    case R.id.dataMember:
                        Intent intent4 = new Intent(DataBisnis.this,DataMember.class);
                        startActivity(intent4);
                        break;
                    case R.id.dataBisnis:
                        break;
                    case R.id.mitra:
                        Intent intent5 = new Intent(DataBisnis.this,Mitra.class);
                        startActivity(intent5);
                    case R.id.tentang:
                        Intent intent6 = new Intent(DataBisnis.this,RismaJT.class);
                        startActivity(intent6);
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}