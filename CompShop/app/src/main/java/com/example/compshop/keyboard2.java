package com.example.compshop;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class keyboard2 extends AppCompatActivity {

    int keyboard2_quantity = 0;
    private int message;
    public static final String PREFS_NAME = "PrefsFile";

    Button keyboard2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard2);

        SharedPreferences keyboard2 = getSharedPreferences(PREFS_NAME, 0);
        keyboard2_quantity =keyboard2.getInt("keyboard2_quantity", keyboard2_quantity);


        keyboard2Button = (Button) findViewById(R.id.keyboard2button);
    }

    public void increment(View view){//perintah tombol tambah
        if(keyboard2_quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        keyboard2_quantity = keyboard2_quantity+1 ;
        display(keyboard2_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(keyboard2_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void decrement(View view){//perintah tombol kurang
        if (keyboard2_quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        keyboard2_quantity = keyboard2_quantity -1;
        display(keyboard2_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(keyboard2_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }


    public void Submitorder(View view) {
        Toast.makeText(this,"Order Succesfully",Toast.LENGTH_SHORT).show();

        SharedPreferences keyboard2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =keyboard2.edit();
        pEditor.putInt("keyboard2_quantity", keyboard2_quantity).apply();

        Intent k2 = new Intent(com.example.compshop.keyboard2.this,myorder.class);
        k2.putExtra("KEYBOARD2_QUANTITY", keyboard2_quantity);
        startActivity(k2);

    }

    private int calculateprice(int keyboard2_quantity){//jumlah pesanan * harga
        int harga=500000;

//        if(addwhipedcream){
//            harga=harga+0000;//harga tambahan toping
//        }

        return keyboard2_quantity * harga;
    }

    private String createOrderSummary(int price) {//hasil pemesanan
        String pricemessage = "";
        pricemessage+="Rp "+price;

        return  pricemessage;
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }


}