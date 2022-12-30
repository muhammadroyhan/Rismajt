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

import com.example.rismajt.databinding.ActivityDataMemberBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class DataMember extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActivityDataMemberBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityDataMemberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Data Member");

        int[] imageId = {R.drawable.men1,R.drawable.women1,R.drawable.women2,R.drawable.women3,R.drawable.men2,R.drawable.men3,R.drawable.women4,R.drawable.women5,R.drawable.women6,};
        String[] nama = {"Andiar Pratama","Indah Puspita","Khansa Lutfia","Widya Astuti","Kurnia Sandi","Fadli Mus","Sabrina","Salsabilla Fatimah","Maharani"};
        String[] angkatan = {"2020","2019","2019","2020","2018","2018","2019","2019","2021"};
        String[] alamat = {"Jl Teluk Gong Raya 6 Dki Jakarta","Jl Proklamasi 56 Dki Jakarta","Jl Pemuda 33-37 Plaza Surabaya Lt 2 Jawa Timur","Jl Cikini Raya 84-86 Ged Cik's Dki Jakarta","Jl North Kav 34 Dki Jakarta","Jl Abdul Majid Raya 17, Dki Jakarta","Pasar Genteng Q1Genteng","Komplek Ciharum 24 RT 02/06"," Jl Pd Kacang Prima Bl I-2/5"};
        String[] bisnis = {"Perdagangan","Wisata","Perdagangan","Perdagangan","Kesehatan","Perdagangan","Pertanian","Perdagangan","Perdagangan"};
        String[] email = {"andiarpratama@gmail.com","indahpuspita1@gmail.com","khansaltf@gmail.com","w.astuti@gmail.com","kurnia123@gmail.com","fadlimustofa@gmail.com","sabrina@gmail.com","salsabilaf@gmail.com","maharani@gmail.com"};
        String[] kampus = {"Universitas Dian Nuswantoro","Universitas Negeri Semarang","Universitas Gadjah Mada","Universitas Diponegoro","Universitas Muhammadiyah Semarang","Universitas Muhammadiyah Semarang","-","Universitas Negeri Yogyakarta","Universitas Dian Nuswantoro"};
        String[] jenjang = {"Sarjana(S1)","Sarjana(S1)","Sarjana(S1)","Sarjana(S1)","Sarjana(S1)","Sarjana(S1)","-","Sarjana(S1)","Sarjana(S1)",};
        String[] jurusan = {"Teknik Elektro","Ilmu Komunikasi","Manajemen","Akuntansi","Sastra Inggris","Akuntansi Perpajakan","-","Manajemen","Matematika",};

        ArrayList<Member> memberArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){
            Member member = new Member(nama[i],angkatan[i],bisnis[i],alamat[i],email[i],kampus[i],jenjang[i],jurusan[i],imageId[i]);
            memberArrayList.add(member);
        }
        ListAdapter listAdapter = new ListAdapter(DataMember.this,memberArrayList);

        binding.listview.setAdapter((android.widget.ListAdapter) listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent i = new Intent(DataMember.this,MemberActivity.class);
                i.putExtra("nama",nama[position]);
                i.putExtra("angkatan",angkatan[position]);
                i.putExtra("alamat",alamat[position]);
                i.putExtra("bisnis",bisnis[position]);
                i.putExtra("imageId",imageId[position]);
                i.putExtra("email",email[position]);
                i.putExtra("kampus",kampus[position]);
                i.putExtra("jenjang",jenjang[position]);
                i.putExtra("jurusan",jurusan[position]);
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
                        Intent intent2 = new Intent(DataMember.this,home_page.class);
                        startActivity(intent2);
                        break;
                    case R.id.editProfil:
                        Intent intent7 = new Intent(DataMember.this,UserProfile.class);
                        startActivity(intent7);
                        break;
                    case R.id.tambahPendidikan:
                        Intent intent = new Intent(DataMember.this,TambahPendidikan.class);
                        startActivity(intent);
                        break;
                    case R.id.tambahBisnis:
                        Intent intent1 = new Intent(DataMember.this,TambahBisnis.class);
                        startActivity(intent1);
                        break;
                    case R.id.tambahKarir:
                        Intent intent3 = new Intent(DataMember.this,TambahKarir.class);
                        startActivity(intent3);
                        break;
                    case R.id.dataMember:
                        break;
                    case R.id.dataBisnis:
                        Intent intent4 = new Intent(DataMember.this,DataBisnis.class);
                        startActivity(intent4);
                        break;
                    case R.id.mitra:
                        Intent intent5 = new Intent(DataMember.this,Mitra.class);
                        startActivity(intent5);
                    case R.id.tentang:
                        Intent intent6 = new Intent(DataMember.this,RismaJT.class);
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