package com.example.compshop2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;


public class ssd extends AppCompatActivity implements View.OnClickListener {
    public CardView card1, card2, card3, card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssd);

        card1 = (CardView) findViewById(R.id.ssd1);

        card2 = (CardView) findViewById(R.id.ssd2);

        card3 = (CardView) findViewById(R.id.ssd3);

        card4 = (CardView) findViewById(R.id.ssd4);


        card1.setOnClickListener((View.OnClickListener) this);

        card2.setOnClickListener((View.OnClickListener) this);

        card3.setOnClickListener((View.OnClickListener) this);

        card4.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View view) {
        Intent a;

        switch (view.getId()){
            case R.id.ssd1:
                a = new Intent(this, ssd1.class);
                startActivity(a);
                break;

            case R.id.ssd2:
                a = new Intent(this, ssd2.class);
                startActivity(a);
                break;

            case R.id.ssd3:
                a = new Intent(this, ssd3.class);
                startActivity(a);
                break;

            case R.id.ssd4:
                a = new Intent(this, ssd4.class);
                startActivity(a);
                break;



        }
    }
}