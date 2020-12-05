package com.example.compshoplistview;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class harddisk3 extends AppCompatActivity {

    int hardisk3_quantity = 0;
    private int message;
    public static final String PREFS_NAME = "PrefsFile";

    Button hardDisk3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harddisk3);

        SharedPreferences harddisk3 = getSharedPreferences(PREFS_NAME, 0);
        hardisk3_quantity =harddisk3.getInt("hardisk3_quantity", hardisk3_quantity);


        hardDisk3Button = (Button) findViewById(R.id.hardDisk3button);
    }

    public void increment(View view){//perintah tombol tambah
        if(hardisk3_quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        hardisk3_quantity = hardisk3_quantity+1 ;
        display(hardisk3_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(hardisk3_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void decrement(View view){//perintah tombol kurang
        if (hardisk3_quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        hardisk3_quantity = hardisk3_quantity -1;
        display(hardisk3_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(hardisk3_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }


    public void Submitorder(View view) {
        Toast.makeText(this,"Order Succesfully",Toast.LENGTH_SHORT).show();

        SharedPreferences harddisk3 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =harddisk3.edit();
        pEditor.putInt("harddisk3_quantity", hardisk3_quantity).apply();

//        Intent h3 = new Intent(com.example.compshop.harddisk3.this,myorder.class);
//        h3.putExtra("HARDDISK3_QUANTITY", hardisk3_quantity);
//        startActivity(h3);

    }

    private int calculateprice(int hardisk3_quantity){//jumlah pesanan * harga
        int harga=1700000;

//        if(addwhipedcream){
//            harga=harga+0000;//harga tambahan toping
//        }

        return hardisk3_quantity * harga;
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