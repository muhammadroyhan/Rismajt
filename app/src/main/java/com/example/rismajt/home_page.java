package com.example.rismajt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class home_page extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.editProfil:
                    {
                        Toast.makeText(home_page.this,"Home Selected",Toast.LENGTH_SHORT).show();
                    }
                    case R.id.tambahPendidikan:
                    {
                        Toast.makeText(home_page.this,"Contact Selected",Toast.LENGTH_SHORT).show();
                    }
                    case R.id.tambahBisnis:
                    {
                        Toast.makeText(home_page.this,"Gallery Selected",Toast.LENGTH_SHORT).show();
                    }
                    case R.id.tambahKarir:
                    {
                        Toast.makeText(home_page.this,"About Selected",Toast.LENGTH_SHORT).show();
                    }
                    case R.id.dataMember:
                    {
                        Toast.makeText(home_page.this,"Share Selected",Toast.LENGTH_SHORT).show();
                    }
                    case R.id.dataBisnis:
                    {
                        Toast.makeText(home_page.this,"Rate Us Selected",Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });
    }
    public void clickDataMember(View view){
        Intent i = new Intent(home_page.this, DataMember.class);
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