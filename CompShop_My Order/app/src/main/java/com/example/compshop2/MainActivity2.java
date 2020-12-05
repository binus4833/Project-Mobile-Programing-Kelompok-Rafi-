package com.example.compshop2;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    public CardView card1, card2, card3, card4, card5, card6;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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

        //        drawer


    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public void onClick(View view) {
        Intent a;

        switch (view.getId()){
            case R.id.hardy:
                a = new Intent(this, hardDisk.class);
                startActivity(a);
                break;

            case R.id.ssdy:
                a = new Intent(this, ssd.class);
                startActivity(a);
                break;

            case R.id.memoryy:
                a = new Intent(this, memory.class);
                startActivity(a);
                break;

            case R.id.mousey:
                a = new Intent(this, mouse.class);
                startActivity(a);
                break;

            case R.id.keyboardy:
                a = new Intent(this, keyboard.class);
                startActivity(a);
                break;

            case R.id.flashdisky:
                a = new Intent(this, flashdisk.class);
                startActivity(a);
                break;

        }
    }
}