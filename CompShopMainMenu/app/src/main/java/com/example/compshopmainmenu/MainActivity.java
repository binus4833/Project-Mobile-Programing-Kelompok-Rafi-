package com.example.compshopmainmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener  {

    public CardView card1, card2, card3, card4, card5, card6;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar Toolbar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        Toolbar = findViewById(R.id.toolbar);
        fAuth = FirebaseAuth.getInstance();

        setSupportActionBar(Toolbar);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(true);


        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                Toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);

        card1 = (CardView) findViewById(R.id.hardy);

        card2 = (CardView) findViewById(R.id.ssdy);

        card3 = (CardView) findViewById(R.id.memoryy);

        card4 = (CardView) findViewById(R.id.mousey);

        card5 = (CardView) findViewById(R.id.keyboardy);

        card6 = (CardView) findViewById(R.id.flashdisky);

        card1.setOnClickListener((View.OnClickListener) this);

        card2.setOnClickListener((View.OnClickListener) this);

        card3.setOnClickListener((View.OnClickListener) this);

        card4.setOnClickListener((View.OnClickListener) this);

        card5.setOnClickListener((View.OnClickListener) this);

        card6.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View view) {
        Intent a;

        switch (view.getId()){
            case R.id.hardy:
                a = new Intent(this, HardDiskList.class);
                startActivity(a);
                break;

            case R.id.ssdy:
                a = new Intent(this, Ssd_List.class);
                startActivity(a);
                break;

            case R.id.memoryy:
                a = new Intent(this, memory_list.class);
                startActivity(a);
                break;

            case R.id.mousey:
                a = new Intent(this, mouse_list.class);
                startActivity(a);
                break;

            case R.id.keyboardy:
                a = new Intent(this, keyboard_list.class);
                startActivity(a);
                break;

            case R.id.flashdisky:
                a = new Intent(this, FlashDiskList.class);
                startActivity(a);
                break;

        }
    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        switch (menuItem.getItemId()){
            case R.id.nav_home:
                break;

            case R.id.nav_logout:
                startActivity(new Intent(getApplicationContext(),TabsLogReg.class));
                fAuth.signOut();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}