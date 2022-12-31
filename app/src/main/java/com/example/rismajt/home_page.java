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
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class home_page extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ImageSlider imageSlider = findViewById(R.id.image_slider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.imgslide1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgslide2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgslide3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgslide4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imgslide5, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels);

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
                        break;
                    case R.id.editProfil:
                        Intent intent7 = new Intent(home_page.this,UserProfile.class);
                        startActivity(intent7);
                        break;
                    case R.id.tambahPendidikan:
                        Intent intent = new Intent(home_page.this,TambahPendidikan.class);
                        startActivity(intent);
                        break;
                    case R.id.tambahBisnis:
                        Intent intent1 = new Intent(home_page.this,TambahBisnis.class);
                        startActivity(intent1);
                        break;
                    case R.id.tambahKarir:
                        Intent intent3 = new Intent(home_page.this,TambahKarir.class);
                        startActivity(intent3);
                        break;
                    case R.id.dataMember:
                        Intent intent2 = new Intent(home_page.this,DataMember.class);
                        startActivity(intent2);
                        break;
                    case R.id.dataBisnis:
                        Intent intent4 = new Intent(home_page.this,DataBisnis.class);
                        startActivity(intent4);
                        break;
                    case R.id.mitra:
                        Intent intent5 = new Intent(home_page.this,Mitra.class);
                        startActivity(intent5);
                        break;
                    case R.id.tentang:
                        Intent intent6 = new Intent(home_page.this,RismaJT.class);
                        startActivity(intent6);
                        break;
                }
                return true;
            }
        });
    }
    public void clickDataMember(View view){
        Intent i = new Intent(home_page.this, DataMember.class);
        startActivity(i);
    }

    public void clickDataBisnis(View view){
        Intent i = new Intent(home_page.this, DataBisnis.class);
        startActivity(i);
    }

    public void clickMitra(View view){
        Intent i = new Intent(home_page.this, RismaJT.class);
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