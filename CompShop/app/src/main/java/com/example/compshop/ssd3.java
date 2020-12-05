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

public class ssd3 extends AppCompatActivity {

    int ssd3_quantity = 0;
    private int message;
    public static final String PREFS_NAME = "PrefsFile";

    Button ssd3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssd3);

        SharedPreferences ssd3 = getSharedPreferences(PREFS_NAME, 0);
        ssd3_quantity =ssd3.getInt("ssd3_quantity", ssd3_quantity);


        ssd3Button = (Button) findViewById(R.id.ssd3button);
    }

    public void increment(View view){//perintah tombol tambah
        if(ssd3_quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        ssd3_quantity = ssd3_quantity+1 ;
        display(ssd3_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(ssd3_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void decrement(View view){//perintah tombol kurang
        if (ssd3_quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        ssd3_quantity = ssd3_quantity -1;
        display(ssd3_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(ssd3_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }


    public void Submitorder(View view) {
        Toast.makeText(this,"Order Succesfully",Toast.LENGTH_SHORT).show();

        SharedPreferences ssd3 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =ssd3.edit();
        pEditor.putInt("ssd3_quantity", ssd3_quantity).apply();

        Intent m2 = new Intent(com.example.compshop.ssd3.this,myorder.class);
        m2.putExtra("SSD3_QUANTITY", ssd3_quantity);
        startActivity(m2);

    }

    private int calculateprice(int ssd3_quantity){//jumlah pesanan * harga
        int harga=1200000;

//        if(addwhipedcream){
//            harga=harga+0000;//harga tambahan toping
//        }

        return ssd3_quantity * harga;
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