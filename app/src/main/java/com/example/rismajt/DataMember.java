package com.example.rismajt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.rismajt.databinding.ActivityDataMemberBinding;

import java.util.ArrayList;

public class DataMember extends AppCompatActivity {

    ActivityDataMemberBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityDataMemberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.men,R.drawable.women,R.drawable.women1,R.drawable.women,R.drawable.men,R.drawable.men,R.drawable.women1,R.drawable.women,R.drawable.women1,};
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

    }
}