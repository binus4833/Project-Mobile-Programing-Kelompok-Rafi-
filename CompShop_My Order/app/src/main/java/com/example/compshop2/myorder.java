package com.example.compshop2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class myorder extends AppCompatActivity {

    int flashdisk1_quantity; int flashdisk1_price = 30000;
    int flashdisk2_quantity; int flashdisk2_price = 50000;
    int flashdisk3_quantity; int flashdisk3_price = 120000;
    int flashdisk4_quantity; int flashdisk4_price = 200000;
    int harddisk1_quantity; int harddisk1_price = 800000;
    int harddisk2_quantity; int harddisk2_price = 1200000;
    int harddisk3_quantity; int harddisk3_price = 1700000;
    int harddisk4_quantity; int harddisk4_price = 2200000;
    int keyboard1_quantity; int keyboard1_price = 300000;
    int keyboard2_quantity; int keyboard2_price = 500000;
    int memory1_quantity; int memory1_price = 150000;
    int memory2_quantity; int memory2_price = 800000;
    int memory3_quantity; int memory3_price = 1200000;
    int memory4_quantity; int memory4_price = 1500000;
    int mouse1_quantity; int mouse1_price = 80000;
    int mouse2_quantity; int mouse2_price = 150000;
    int ssd1_quantity; int ssd1_price = 500000;
    int ssd2_quantity; int ssd2_price = 800000;
    int ssd3_quantity; int ssd3_price = 1200000;
    int ssd4_quantity; int ssd4_price = 1700000;

    @BindView(R.id.flashdisk1_card)
    CardView flashdisk1_card;
    @BindView(R.id.flashdisk2_card)
    CardView flashdisk2_card;
    @BindView(R.id.flashdisk3_card)
    CardView flashdisk3_card;
    @BindView(R.id.flashdisk4_card)
    CardView flashdisk4_card;
    @BindView(R.id.harddisk1_card)
    CardView harddisk1_card;
    @BindView(R.id.harddisk2_card)
    CardView harddisk2_card;
    @BindView(R.id.harddisk3_card)
    CardView harddisk3_card;
    @BindView(R.id.harddisk4_card)
    CardView harddisk4_card;
    @BindView(R.id.keyboard1_card)
    CardView keyboard1_card;
    @BindView(R.id.keyboard2_card)
    CardView keyboard2_card;
    @BindView(R.id.memory1_card)
    CardView memory1_card;
    @BindView(R.id.memory2_card)
    CardView memory2_card;
    @BindView(R.id.memory3_card)
    CardView memory3_card;
    @BindView(R.id.memory4_card)
    CardView memory4_card;
    @BindView(R.id.mouse1_card)
    CardView mouse1_card;
    @BindView(R.id.mouse2_card)
    CardView mouse2_card;
    @BindView(R.id.ssd1_card)
    CardView ssd1_card;
    @BindView(R.id.ssd2_card)
    CardView ssd2_card;
    @BindView(R.id.ssd3_card)
    CardView ssd3_card;
    @BindView(R.id.ssd4_card)
    CardView ssd4_card;

    public static final String PREFS_NAME = "PrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);
        ButterKnife.bind(this);

        //Ambil nilai dari tiap variabel item
        SharedPreferences flashdisk1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences flashdisk2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences flashdisk3 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences flashdisk4 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences harddisk1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences harddisk2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences harddisk3 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences harddisk4 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences keyboard1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences keyboard2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences memory1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences memory2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences memory3 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences memory4 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences mouse1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences mouse2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences ssd1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences ssd2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences ssd3 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences ssd4 = getSharedPreferences(PREFS_NAME, 0);

        flashdisk1_quantity = flashdisk1.getInt("flashdisk1_quantity", 0);
        flashdisk2_quantity = flashdisk2.getInt("flashdisk2_quantity", 0);
        flashdisk3_quantity = flashdisk3.getInt("flashdisk3_quantity", 0);
        flashdisk4_quantity = flashdisk4.getInt("flashdisk4_quantity", 0);
        harddisk1_quantity = harddisk1.getInt("harddisk1_quantity", 0);
        harddisk2_quantity = harddisk2.getInt("harddisk2_quantity", 0);
        harddisk3_quantity = harddisk3.getInt("harddisk3_quantity", 0);
        harddisk4_quantity = harddisk4.getInt("harddisk4_quantity", 0);
        keyboard1_quantity = keyboard1.getInt("keyboard1_quantity", 0);
        keyboard2_quantity = keyboard2.getInt("keyboard2_quantity", 0);
        memory1_quantity = memory1.getInt("memory1_quantity", 0);
        memory2_quantity = memory2.getInt("memory2_quantity", 0);
        memory3_quantity = memory3.getInt("memory3_quantity", 0);
        memory4_quantity = memory4.getInt("memory4_quantity", 0);
        mouse1_quantity = mouse1.getInt("mouse1_quantity", 0);
        mouse2_quantity = mouse2.getInt("mouse2_quantity", 0);
        ssd1_quantity = ssd1.getInt("ssd1_quantity", 0);
        ssd2_quantity = ssd2.getInt("ssd2_quantity", 0);
        ssd3_quantity = ssd3.getInt("ssd3_quantity", 0);
        ssd4_quantity = ssd4.getInt("ssd4_quantity", 0);

        //Items Totals
        int flashdisk1_total = flashdisk1_quantity*flashdisk1_price;
        int flashdisk2_total = flashdisk2_quantity*flashdisk2_price;
        int flashdisk3_total = flashdisk3_quantity*flashdisk3_price;
        int flashdisk4_total = flashdisk4_quantity*flashdisk4_price;
        int harddisk1_total = harddisk1_quantity*harddisk1_price;
        int harddisk2_total = harddisk2_quantity*harddisk2_price;
        int harddisk3_total = harddisk3_quantity*harddisk3_price;
        int harddisk4_total = harddisk4_quantity*harddisk4_price;
        int keyboard1_total = keyboard1_quantity*keyboard1_price;
        int keyboard2_total = keyboard2_quantity*keyboard2_price;
        int memory1_total = memory1_quantity*memory1_price;
        int memory2_total = memory2_quantity*memory2_price;
        int memory3_total = memory3_quantity*memory3_price;
        int memory4_total = memory4_quantity*memory4_price;
        int mouse1_total = mouse1_quantity*mouse1_price;
        int mouse2_total = mouse2_quantity*mouse2_price;
        int ssd1_total = ssd1_quantity*ssd1_price;
        int ssd2_total = ssd2_quantity*ssd2_price;
        int ssd3_total = ssd3_quantity*ssd3_price;
        int ssd4_total = ssd4_quantity*ssd4_price;

        //MyOrder TextViews
//        final TextView tvTotalItems = (TextView) findViewById(R.id.total_price_items);
//        tvTotalItems.setText(getString(R.string.total_price_items,
//                flashdisk1_total+flashdisk2_total+flashdisk3_total+flashdisk4_total
//                            +harddisk1_total+harddisk2_total+harddisk3_total+harddisk4_total
//                            +keyboard1_total+keyboard2_total
//                            +memory1_total+memory2_total+memory3_total+memory4_total
//                            +mouse1_total+mouse2_total
//                            +ssd1_total+ssd2_total+ssd3_total+ssd4_total));

        final TextView header = (TextView) findViewById(R.id.order_header);
        header.setText(getString(R.string.order_header));
        final TextView tvFlashdisk1 = (TextView) findViewById(R.id.flashdisk1_detail);
        tvFlashdisk1.setText(getString(R.string.flashdisk1_detail, flashdisk1_quantity, flashdisk1_price, flashdisk1_total));
        final TextView tvFlashdisk2 = (TextView) findViewById(R.id.flashdisk2_detail);
        tvFlashdisk2.setText(getString(R.string.flashdisk2_detail, flashdisk2_quantity, flashdisk2_price, flashdisk2_total));
        final TextView tvFlashdisk3 = (TextView) findViewById(R.id.flashdisk3_detail);
        tvFlashdisk3.setText(getString(R.string.flashdisk3_detail, flashdisk3_quantity, flashdisk3_price, flashdisk3_total));
        final TextView tvFlashdisk4 = (TextView) findViewById(R.id.flashdisk4_detail);
        tvFlashdisk4.setText(getString(R.string.flashdisk4_detail, flashdisk4_quantity, flashdisk4_price, flashdisk4_total));
        final TextView tvHarddisk1 = (TextView) findViewById(R.id.harddisk1_detail);
        tvHarddisk1.setText(getString(R.string.harddisk1_detail, harddisk1_quantity, harddisk1_price, harddisk1_total));
        final TextView tvHarddisk2 = (TextView) findViewById(R.id.harddisk2_detail);
        tvHarddisk2.setText(getString(R.string.harddisk2_detail, harddisk2_quantity, harddisk2_price, harddisk2_total));
        final TextView tvHarddisk3 = (TextView) findViewById(R.id.harddisk3_detail);
        tvHarddisk3.setText(getString(R.string.harddisk3_detail, harddisk3_quantity, harddisk3_price, harddisk3_total));
        final TextView tvHarddisk4 = (TextView) findViewById(R.id.harddisk4_detail);
        tvHarddisk4.setText(getString(R.string.harddisk4_detail, harddisk4_quantity, harddisk4_price, harddisk4_total));
        final TextView tvKeyboard1 = (TextView) findViewById(R.id.keyboard1_detail);
        tvKeyboard1.setText(getString(R.string.keyboard1_detail, keyboard1_quantity, keyboard1_price, keyboard1_total));
        final TextView tvKeyboard2 = (TextView) findViewById(R.id.keyboard2_detail);
        tvKeyboard2.setText(getString(R.string.keyboard2_detail, keyboard2_quantity, keyboard2_price, keyboard2_total));
        final TextView tvMemory1 = (TextView) findViewById(R.id.memory1_detail);
        tvMemory1.setText(getString(R.string.memory1_detail, memory1_quantity, memory1_price, memory1_total));
        final TextView tvMemory2 = (TextView) findViewById(R.id.memory2_detail);
        tvMemory2.setText(getString(R.string.memory2_detail, memory2_quantity, memory2_price, memory2_total));
        final TextView tvMemory3 = (TextView) findViewById(R.id.memory3_detail);
        tvMemory3.setText(getString(R.string.memory3_detail, memory3_quantity, memory3_price, memory3_total));
        final TextView tvMemory4 = (TextView) findViewById(R.id.memory4_detail);
        tvMemory4.setText(getString(R.string.memory4_detail, memory4_quantity, memory4_price, memory4_total));
        final TextView tvMouse1 = (TextView) findViewById(R.id.mouse1_detail);
        tvMouse1.setText(getString(R.string.mouse1_detail, mouse1_quantity, mouse1_price, mouse1_total));
        final TextView tvMouse2 = (TextView) findViewById(R.id.mouse2_detail);
        tvMouse2.setText(getString(R.string.mouse2_detail, mouse2_quantity, mouse2_price, mouse2_total));
        final TextView tvSsd1 = (TextView) findViewById(R.id.ssd1_detail);
        tvSsd1.setText(getString(R.string.ssd1_detail, ssd1_quantity, ssd1_price, ssd1_total));
        final TextView tvSsd2 = (TextView) findViewById(R.id.ssd2_detail);
        tvSsd2.setText(getString(R.string.ssd2_detail, ssd2_quantity, ssd2_price, ssd2_total));
        final TextView tvSsd3 = (TextView) findViewById(R.id.ssd3_detail);
        tvSsd3.setText(getString(R.string.ssd3_detail, ssd3_quantity, ssd3_price, ssd3_total));
        final TextView tvSsd4 = (TextView) findViewById(R.id.ssd4_detail);
        tvSsd4.setText(getString(R.string.ssd4_detail, ssd4_quantity, ssd4_price, ssd4_total));


        //Hide & Show Cards
        if (flashdisk1_quantity == 0) {
            flashdisk1_card.setVisibility(View.GONE);
        } else if(flashdisk1_quantity > 0){
            flashdisk1_card.setVisibility(View.VISIBLE);
        }
        if (flashdisk2_quantity == 0) {
            flashdisk2_card.setVisibility(View.GONE);
        } else if(flashdisk2_quantity > 0){
            flashdisk2_card.setVisibility(View.VISIBLE);
        }
        if (flashdisk3_quantity == 0) {
            flashdisk3_card.setVisibility(View.GONE);
        } else if(flashdisk3_quantity > 0){
            flashdisk3_card.setVisibility(View.VISIBLE);
        }
        if (flashdisk4_quantity == 0) {
            flashdisk4_card.setVisibility(View.GONE);
        } else if(flashdisk4_quantity > 0){
            flashdisk4_card.setVisibility(View.VISIBLE);
        }
        if (harddisk1_quantity == 0) {
            harddisk1_card.setVisibility(View.GONE);
        } else if(harddisk1_quantity > 0){
            harddisk1_card.setVisibility(View.VISIBLE);
        }
        if (harddisk2_quantity == 0) {
            harddisk2_card.setVisibility(View.GONE);
        } else if(harddisk2_quantity > 0){
            harddisk2_card.setVisibility(View.VISIBLE);
        }
        if (harddisk3_quantity == 0) {
            harddisk3_card.setVisibility(View.GONE);
        } else if(harddisk3_quantity > 0){
            harddisk3_card.setVisibility(View.VISIBLE);
        }
        if (harddisk4_quantity == 0) {
            harddisk4_card.setVisibility(View.GONE);
        } else if(harddisk4_quantity > 0){
            harddisk4_card.setVisibility(View.VISIBLE);
        }
        if (keyboard1_quantity == 0) {
            keyboard1_card.setVisibility(View.GONE);
        } else if(keyboard1_quantity > 0){
            keyboard1_card.setVisibility(View.VISIBLE);
        }
        if (keyboard2_quantity == 0) {
            keyboard2_card.setVisibility(View.GONE);
        } else if(keyboard2_quantity > 0){
            keyboard2_card.setVisibility(View.VISIBLE);
        }
        if (memory1_quantity == 0) {
            memory1_card.setVisibility(View.GONE);
        } else if(memory1_quantity > 0){
            memory1_card.setVisibility(View.VISIBLE);
        }
        if (memory2_quantity == 0) {
            memory2_card.setVisibility(View.GONE);
        } else if(memory2_quantity > 0){
            memory2_card.setVisibility(View.VISIBLE);
        }
        if (memory3_quantity == 0) {
            memory3_card.setVisibility(View.GONE);
        } else if(memory3_quantity > 0){
            memory3_card.setVisibility(View.VISIBLE);
        }
        if (memory4_quantity == 0) {
            memory4_card.setVisibility(View.GONE);
        } else if(memory4_quantity > 0){
            memory4_card.setVisibility(View.VISIBLE);
        }
        if (mouse1_quantity == 0) {
            mouse1_card.setVisibility(View.GONE);
        } else if(mouse1_quantity > 0){
            mouse1_card.setVisibility(View.VISIBLE);
        }
        if (mouse2_quantity == 0) {
            mouse2_card.setVisibility(View.GONE);
        } else if(mouse2_quantity > 0){
            mouse2_card.setVisibility(View.VISIBLE);
        }
        if (ssd1_quantity == 0) {
            ssd1_card.setVisibility(View.GONE);
        } else if(ssd1_quantity > 0){
            ssd1_card.setVisibility(View.VISIBLE);
        }
        if (ssd2_quantity == 0) {
            ssd2_card.setVisibility(View.GONE);
        } else if(ssd2_quantity > 0){
            ssd2_card.setVisibility(View.VISIBLE);
        }
        if (ssd3_quantity == 0) {
            ssd3_card.setVisibility(View.GONE);
        } else if(ssd3_quantity > 0){
            ssd3_card.setVisibility(View.VISIBLE);
        }
        if (ssd4_quantity == 0) {
            ssd4_card.setVisibility(View.GONE);
        } else if(ssd4_quantity > 0){
            ssd4_card.setVisibility(View.VISIBLE);
        }
    }

    //Tombol Remove set quantity ke 0 -> Hide Card
    public void removeFlashdisk1(View view) {
        flashdisk1_quantity = 0;
        SharedPreferences flashdisk1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =flashdisk1.edit();
        pEditor.putInt("flashdisk1_quantity", flashdisk1_quantity).apply();
        flashdisk1_card.setVisibility(View.GONE);
    }
    public void removeFlashdisk2(View view) {
        flashdisk2_quantity = 0;
        SharedPreferences flashdisk2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =flashdisk2.edit();
        pEditor.putInt("flashdisk2_quantity", flashdisk2_quantity).apply();
        flashdisk2_card.setVisibility(View.GONE);
    }
    public void removeFlashdisk3(View view) {
        flashdisk3_quantity = 0;
        SharedPreferences flashdisk3 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =flashdisk3.edit();
        pEditor.putInt("flashdisk3_quantity", flashdisk3_quantity).apply();
        flashdisk3_card.setVisibility(View.GONE);
    }
    public void removeFlashdisk4(View view) {
        flashdisk4_quantity = 0;
        SharedPreferences flashdisk4 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =flashdisk4.edit();
        pEditor.putInt("flashdisk4_quantity", flashdisk4_quantity).apply();
        flashdisk4_card.setVisibility(View.GONE);
    }
    public void removeHarddisk1(View view) {
        harddisk1_quantity = 0;
        SharedPreferences harddisk1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =harddisk1.edit();
        pEditor.putInt("harddisk1_quantity", harddisk1_quantity).apply();
        harddisk1_card.setVisibility(View.GONE);
    }
    public void removeHarddisk2(View view) {
        harddisk2_quantity = 0;
        SharedPreferences harddisk2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =harddisk2.edit();
        pEditor.putInt("harddisk2_quantity", harddisk2_quantity).apply();
        harddisk2_card.setVisibility(View.GONE);
    }
    public void removeHarddisk3(View view) {
        harddisk3_quantity = 0;
        SharedPreferences harddisk3 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =harddisk3.edit();
        pEditor.putInt("harddisk3_quantity", harddisk3_quantity).apply();
        harddisk3_card.setVisibility(View.GONE);
    }
    public void removeHarddisk4(View view) {
        harddisk4_quantity = 0;
        SharedPreferences harddisk4 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =harddisk4.edit();
        pEditor.putInt("harddisk4_quantity", harddisk4_quantity).apply();
        harddisk4_card.setVisibility(View.GONE);
    }
    public void removeKeyboard1(View view) {
        keyboard1_quantity = 0;
        SharedPreferences keyboard1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =keyboard1.edit();
        pEditor.putInt("keyboard1_quantity", keyboard1_quantity).apply();
        keyboard1_card.setVisibility(View.GONE);
    }
    public void removeKeyboard2(View view) {
        keyboard2_quantity = 0;
        SharedPreferences keyboard2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =keyboard2.edit();
        pEditor.putInt("keyboard2_quantity", keyboard2_quantity).apply();
        keyboard2_card.setVisibility(View.GONE);
    }
    public void removeMemory1(View view) {
        memory1_quantity = 0;
        SharedPreferences memory1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =memory1.edit();
        pEditor.putInt("memory1_quantity", memory1_quantity).apply();
        memory1_card.setVisibility(View.GONE);
    }
    public void removeMemory2(View view) {
        memory2_quantity = 0;
        SharedPreferences memory2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =memory2.edit();
        pEditor.putInt("memory2_quantity", memory2_quantity).apply();
        memory2_card.setVisibility(View.GONE);
    }
    public void removeMemory3(View view) {
        memory3_quantity = 0;
        SharedPreferences memory3 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =memory3.edit();
        pEditor.putInt("memory3_quantity", memory3_quantity).apply();
        memory3_card.setVisibility(View.GONE);
    }
    public void removeMemory4(View view) {
        memory4_quantity = 0;
        SharedPreferences memory4 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =memory4.edit();
        pEditor.putInt("memory4_quantity", memory4_quantity).apply();
        memory4_card.setVisibility(View.GONE);
    }
    public void removeMouse1(View view) {
        mouse1_quantity = 0;
        SharedPreferences mouse1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor = mouse1.edit();
        pEditor.putInt("mouse1_quantity", mouse1_quantity).apply();
        mouse1_card.setVisibility(View.GONE);
    }

    public void removeMouse2(View view) {
        mouse2_quantity = 0;
        SharedPreferences mouse2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =mouse2.edit();
        pEditor.putInt("mouse2_quantity", mouse2_quantity).apply();
        mouse2_card.setVisibility(View.GONE);
    }
    public void removeSsd1(View view) {
        ssd1_quantity = 0;
        SharedPreferences ssd1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =ssd1.edit();
        pEditor.putInt("ssd1_quantity", ssd1_quantity).apply();
        ssd1_card.setVisibility(View.GONE);
    }
    public void removeSsd2(View view) {
        ssd2_quantity = 0;
        SharedPreferences ssd2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =ssd2.edit();
        pEditor.putInt("ssd2_quantity", ssd2_quantity).apply();
        ssd2_card.setVisibility(View.GONE);
    }
    public void removeSsd3(View view) {
        ssd3_quantity = 0;
        SharedPreferences ssd3 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =ssd3.edit();
        pEditor.putInt("ssd3_quantity", ssd3_quantity).apply();
        ssd3_card.setVisibility(View.GONE);
    }
    public void removeSsd4(View view) {
        ssd4_quantity = 0;
        SharedPreferences ssd4 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =ssd4.edit();
        pEditor.putInt("ssd4_quantity", ssd4_quantity).apply();
        ssd4_card.setVisibility(View.GONE);
    }
}