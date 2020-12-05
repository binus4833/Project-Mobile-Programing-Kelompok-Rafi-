package com.example.compshop2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class hardDisk extends AppCompatActivity implements View.OnClickListener  {
    public CardView card1, card2, card3, card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_disk);

        card1 = (CardView) findViewById(R.id.hardDisk1);

        card2 = (CardView) findViewById(R.id.hardDisk2);

        card3 = (CardView) findViewById(R.id.hardDisk3);

        card4 = (CardView) findViewById(R.id.hardDisk4);


        card1.setOnClickListener((View.OnClickListener) this);

        card2.setOnClickListener((View.OnClickListener) this);

        card3.setOnClickListener((View.OnClickListener) this);

        card4.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View view) {
        Intent a;

        switch (view.getId()){
            case R.id.hardDisk1:
                a = new Intent(this, harddisk1.class);
                startActivity(a);
                break;

            case R.id.hardDisk2:
                a = new Intent(this, harddisk2.class);
                startActivity(a);
                break;

            case R.id.hardDisk3:
                a = new Intent(this, harddisk3.class);
                startActivity(a);
                break;

            case R.id.hardDisk4:
                a = new Intent(this, harddisk4.class);
                startActivity(a);
                break;



        }
    }
}