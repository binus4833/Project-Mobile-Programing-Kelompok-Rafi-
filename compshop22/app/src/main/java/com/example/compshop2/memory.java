package com.example.compshop2;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class memory extends AppCompatActivity implements View.OnClickListener {
    public CardView card1, card2, card3, card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        card1 = (CardView) findViewById(R.id.memory1);

        card2 = (CardView) findViewById(R.id.memory2);

        card3 = (CardView) findViewById(R.id.memory3);

        card4 = (CardView) findViewById(R.id.memory4);


        card1.setOnClickListener((View.OnClickListener) this);

        card2.setOnClickListener((View.OnClickListener) this);

        card3.setOnClickListener((View.OnClickListener) this);

        card4.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        Intent a;

        switch (view.getId()){
            case R.id.memory1:
                a = new Intent(this, memory1.class);
                startActivity(a);
                break;

            case R.id.memory2:
                a = new Intent(this, memory2.class);
                startActivity(a);
                break;

            case R.id.memory3:
                a = new Intent(this, memory3.class);
                startActivity(a);
                break;

            case R.id.memory4:
                a = new Intent(this, memory4.class);
                startActivity(a);
                break;



        }
    }
}