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

import com.google.android.material.navigation.NavigationView;

public class TambahBisnis extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_bisnis);
        setTitle("Tambah Bisnis");

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
                        Intent intent1 = new Intent(TambahBisnis.this,home_page.class);
                        startActivity(intent1);
                        break;
                    case R.id.editProfil:
                        Intent intent7 = new Intent(TambahBisnis.this,UserProfile.class);
                        startActivity(intent7);
                        break;
                    case R.id.tambahPendidikan:
                        Intent intent = new Intent(TambahBisnis.this,TambahPendidikan.class);
                        startActivity(intent);
                        break;
                    case R.id.tambahBisnis:
                        break;
                    case R.id.tambahKarir:
                        Intent intent3 = new Intent(TambahBisnis.this,TambahKarir.class);
                        startActivity(intent3);
                        break;
                    case R.id.dataMember:
                        Intent intent2 = new Intent(TambahBisnis.this,DataMember.class);
                        startActivity(intent2);
                        break;
                    case R.id.dataBisnis:
                        break;
                    case R.id.mitra:
                        Intent intent5 = new Intent(TambahBisnis.this,Mitra.class);
                        startActivity(intent5);
                        break;
                    case R.id.tentang:
                        Intent intent6 = new Intent(TambahBisnis.this,RismaJT.class);
                        startActivity(intent6);
                        break;

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

    public void btnTambah(View view) {
        Intent i = new Intent(TambahBisnis.this, home_page.class);
        startActivity(i);
    }
}