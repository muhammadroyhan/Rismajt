package com.example.rismajt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class home_page extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerLayout.bringToFront(

        );
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                    {
                        Intent intent = new Intent(home_page.this,home_page.class);
                        startActivity(intent);
                    }
                    case R.id.contact:
                    {
                        Intent intent = new Intent(home_page.this,home_page.class);
                        startActivity(intent);                    }
                    case R.id.gallery:
                    {
                        Toast.makeText(home_page.this,"Gallery Selected",Toast.LENGTH_SHORT).show();
                    }
                    case R.id.about:
                    {
                        Toast.makeText(home_page.this,"About Selected",Toast.LENGTH_SHORT).show();
                    }
                    case R.id.share:
                    {
                        Toast.makeText(home_page.this,"Share Selected",Toast.LENGTH_SHORT).show();
                    }
                    case R.id.rateus:
                    {
                        Toast.makeText(home_page.this,"Rate Us Selected",Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });
        ImageSlider imageSlider = findViewById(R.id.image_slider);

        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.imgslide1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgslide2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgslide3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgslide4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgslide5, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            super.onBackPressed();
        } else {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

//    public void clickDataMember(View view) {
//        Intent i = new Intent(home_page.this, DataMember.class);
//        startActivity(i);
//    }

//    public void clickDataBisnis(View view) {
//        Intent i = new Intent(home_page.this, Data_Bisnis.class);
//        startActivity(i);
//    }
//
//    public void clickMitra(View view) {
//        Intent i = new Intent(home_page.this, Mitra_page.class);
//        startActivity(i);
//    }
//
//    public void clickDataMember(View view) {
//        Intent i = new Intent(home_page.this, Market_place.class);
//        startActivity(i);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}