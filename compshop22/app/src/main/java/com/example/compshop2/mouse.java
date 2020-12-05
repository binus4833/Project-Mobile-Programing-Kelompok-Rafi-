package com.example.compshop2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class mouse extends AppCompatActivity implements View.OnClickListener {
    public CardView card1, card2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouse);

        card1 = (CardView) findViewById(R.id.mouse);

        card2 = (CardView) findViewById(R.id.mouse2);


        card1.setOnClickListener((View.OnClickListener) this);

        card2.setOnClickListener((View.OnClickListener) this);


    }

    @Override
    public void onClick(View view) {
        Intent a;

        switch (view.getId()){
            case R.id.mouse:
                a = new Intent(this, mouse1.class);
                startActivity(a);
                break;

            case R.id.mouse2:
                a = new Intent(this, mouse2.class);
                startActivity(a);
                break;



        }
    }
}