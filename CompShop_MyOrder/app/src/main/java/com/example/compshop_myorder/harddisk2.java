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

public class harddisk2 extends AppCompatActivity {

    int hardisk2_quantity = 0;
    private int message;
    public static final String PREFS_NAME = "PrefsFile";

    Button hardDisk2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harddisk2);

        SharedPreferences harddisk2 = getSharedPreferences(PREFS_NAME, 0);
        hardisk2_quantity =harddisk2.getInt("hardisk2_quantity", hardisk2_quantity);


        hardDisk2Button = (Button) findViewById(R.id.hardDisk2button);
    }

    public void increment(View view){//perintah tombol tambah
        if(hardisk2_quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        hardisk2_quantity = hardisk2_quantity+1 ;
        display(hardisk2_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(hardisk2_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void decrement(View view){//perintah tombol kurang
        if (hardisk2_quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        hardisk2_quantity = hardisk2_quantity -1;
        display(hardisk2_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(hardisk2_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }


    public void Submitorder(View view) {
        Toast.makeText(this,"Order Succesfully",Toast.LENGTH_SHORT).show();

        SharedPreferences harddisk2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =harddisk2.edit();
        pEditor.putInt("harddisk2_quantity", hardisk2_quantity).apply();

        Intent h2 = new Intent(harddisk2.this,myorder.class);
        h2.putExtra("HARDDISK2_QUANTITY", hardisk2_quantity);
        startActivity(h2);

    }

    private int calculateprice(int hardisk2_quantity){//jumlah pesanan * harga
        int harga=1200000;

//        if(addwhipedcream){
//            harga=harga+0000;//harga tambahan toping
//        }

        return hardisk2_quantity * harga;
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