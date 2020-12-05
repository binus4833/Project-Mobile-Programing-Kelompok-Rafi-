package com.example.compshop_myorder;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class ssd2 extends AppCompatActivity {

    int ssd2_quantity = 0;
    private int message;
    public static final String PREFS_NAME = "PrefsFile";

    Button ssd2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssd2);

        SharedPreferences ssd2 = getSharedPreferences(PREFS_NAME, 0);
        ssd2_quantity =ssd2.getInt("ssd2_quantity", ssd2_quantity);


        ssd2Button = (Button) findViewById(R.id.ssd2button);
    }

    public void increment(View view){//perintah tombol tambah
        if(ssd2_quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        ssd2_quantity = ssd2_quantity+1 ;
        display(ssd2_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(ssd2_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void decrement(View view){//perintah tombol kurang
        if (ssd2_quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        ssd2_quantity = ssd2_quantity -1;
        display(ssd2_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(ssd2_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }


    public void Submitorder(View view) {
        Toast.makeText(this,"Order Succesfully",Toast.LENGTH_SHORT).show();

        SharedPreferences ssd2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =ssd2.edit();
        pEditor.putInt("ssd2_quantity", ssd2_quantity).apply();

        Intent m2 = new Intent(ssd2.this,myorder.class);
        m2.putExtra("SSD2_QUANTITY", ssd2_quantity);
        startActivity(m2);

    }

    private int calculateprice(int ssd2_quantity){//jumlah pesanan * harga
        int harga=800000;

//        if(addwhipedcream){
//            harga=harga+0000;//harga tambahan toping
//        }

        return ssd2_quantity * harga;
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