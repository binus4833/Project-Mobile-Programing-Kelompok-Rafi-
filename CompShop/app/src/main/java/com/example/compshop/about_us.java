package com.example.compshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayDeque;
import java.util.Deque;

public class about_us extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar Toolbar;
    FirebaseAuth fAuth;

    BottomNavigationView bottomNavigationView;
    Deque<Integer> integerDeque = new ArrayDeque<>(2);
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

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

        navigationView.setCheckedItem(R.id.nav_aboutUs);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Add Home Fragments
        integerDeque.push(R.id.bot_Description);
        //Load Fragment
        loadFragment(new Description());
        //Set Home as Default fragment
        bottomNavigationView.setSelectedItemId(R.id.bot_Description);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(integerDeque.contains(id)){

                    if(id == R.id.bot_Description){

                        if(integerDeque.size() != 0){

                            if(flag){
                                integerDeque.addFirst(R.id.bot_Description);
                                flag = false;
                            }
                        }
                    }

                    integerDeque.remove(id);

                }

                integerDeque.push(id);

                loadFragment(getFragment(item.getItemId()));

                return true;
            }
        });
    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

        integerDeque.pop();

        if(!integerDeque.isEmpty()){
            loadFragment(getFragment(integerDeque.peek()));
        }

        else{
            finish();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        switch (menuItem.getItemId()){
            case R.id.nav_home:
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                break;

            case R.id.MyOrder:
                Intent intent = new Intent(getApplicationContext(), myorder.class);
                startActivity(intent);
                break;

            case R.id.nav_aboutUs:
                break;

            case R.id.nav_logout:
                startActivity(new Intent(getApplicationContext(),TabsLogReg.class));
                fAuth.signOut();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    private Fragment getFragment(int itemId) {
        switch (itemId){
            case R.id.bot_Description:

                bottomNavigationView.getMenu().getItem(0).setChecked(true);

                return new Description();

            case R.id.bot_Location:

                bottomNavigationView.getMenu().getItem(1).setChecked(true);

                return new Location();
        }

        bottomNavigationView.getMenu().getItem(0).setChecked(true);

        return new Description();

    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment,fragment,fragment.getClass().getSimpleName())
                .commit();

    }
}