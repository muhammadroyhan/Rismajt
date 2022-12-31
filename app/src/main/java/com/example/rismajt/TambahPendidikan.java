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

public class TambahPendidikan extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pendidikan);
        setTitle("Tambah Pendidikan");

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
                        Intent intent1 = new Intent(TambahPendidikan.this,home_page.class);
                        startActivity(intent1);
                        break;
                    case R.id.editProfil:
                        Intent intent7 = new Intent(TambahPendidikan.this,UserProfile.class);
                        startActivity(intent7);
                        break;
                    case R.id.tambahPendidikan:
                        break;
                    case R.id.tambahBisnis:
                        Intent intent = new Intent(TambahPendidikan.this,TambahBisnis.class);
                        startActivity(intent);
                        break;
                    case R.id.tambahKarir:
                        Intent intent3 = new Intent(TambahPendidikan.this,TambahKarir.class);
                        startActivity(intent3);
                        break;
                    case R.id.dataMember:
                        Intent intent2 = new Intent(TambahPendidikan.this,DataMember.class);
                        startActivity(intent2);
                        break;
                    case R.id.dataBisnis:
                        Intent intent4 = new Intent(TambahPendidikan.this,DataBisnis.class);
                        startActivity(intent4);
                        break;
                    case R.id.mitra:
                        Intent intent5 = new Intent(TambahPendidikan.this,Mitra.class);
                        startActivity(intent5);
                        break;
                    case R.id.tentang:
                        Intent intent6 = new Intent(TambahPendidikan.this,RismaJT.class);
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
        Intent i = new Intent(TambahPendidikan.this, home_page.class);
        startActivity(i);
    }
}