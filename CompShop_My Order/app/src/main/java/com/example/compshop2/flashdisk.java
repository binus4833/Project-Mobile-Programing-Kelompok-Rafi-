package com.example.compshop2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class flashdisk extends AppCompatActivity  implements View.OnClickListener{
    public CardView card1, card2, card3, card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashdisk);

        card1 = (CardView) findViewById(R.id.flashdisk1);

        card2 = (CardView) findViewById(R.id.flashdisk2);

        card3 = (CardView) findViewById(R.id.hflashdisk3);

        card4 = (CardView) findViewById(R.id.flashdisk4);


        card1.setOnClickListener((View.OnClickListener) this);

        card2.setOnClickListener((View.OnClickListener) this);

        card3.setOnClickListener((View.OnClickListener) this);

        card4.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View view) {
        Intent a;

        switch (view.getId()){
            case R.id.flashdisk1:
                a = new Intent(this, flashdisk1.class);
                startActivity(a);
                break;

            case R.id.flashdisk2:
                a = new Intent(this, flashdisk2.class);
                startActivity(a);
                break;

            case R.id.hflashdisk3:
                a = new Intent(this, flashdisk3.class);
                startActivity(a);
                break;

            case R.id.flashdisk4:
                a = new Intent(this, flashdisk4.class);
                startActivity(a);
                break;



        }
    }
}