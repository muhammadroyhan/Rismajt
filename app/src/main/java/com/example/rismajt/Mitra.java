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

public class Mitra extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitra);
        setTitle("Mitra");

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
                        Intent intent5 = new Intent(Mitra.this,home_page.class);
                        startActivity(intent5);
                        break;
                    case R.id.editProfil:
                        Intent intent7 = new Intent(Mitra.this,UserProfile.class);
                        startActivity(intent7);
                        break;
                    case R.id.tambahPendidikan:
                        Intent intent = new Intent(Mitra.this,TambahPendidikan.class);
                        startActivity(intent);
                        break;
                    case R.id.tambahBisnis:
                        Intent intent1 = new Intent(Mitra.this,TambahBisnis.class);
                        startActivity(intent1);
                        break;
                    case R.id.tambahKarir:
                        Intent intent3 = new Intent(Mitra.this,TambahKarir.class);
                        startActivity(intent3);
                        break;
                    case R.id.dataMember:
                        Intent intent2 = new Intent(Mitra.this,DataMember.class);
                        startActivity(intent2);
                        break;
                    case R.id.dataBisnis:
                        Intent intent4 = new Intent(Mitra.this,DataBisnis.class);
                        startActivity(intent4);
                        break;
                    case R.id.mitra:
                        break;
                    case R.id.tentang:
                        Intent intent6 = new Intent(Mitra.this,RismaJT.class);
                        startActivity(intent6);
                        break;
                }
                return true;
            }
        });
    }
    public void clickMitra1(View view){
        Intent i = new Intent(Mitra.this, Mitra1.class);
        startActivity(i);
    }
    public void clickMitra2(View view){
        Intent i = new Intent(Mitra.this, Mitra2.class);
        startActivity(i);
    }
    public void clickMitra3(View view){
        Intent i = new Intent(Mitra.this, Mitra3.class);
        startActivity(i);
    }
    public void clickMitra4(View view){
        Intent i = new Intent(Mitra.this, Mitra4.class);
        startActivity(i);
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