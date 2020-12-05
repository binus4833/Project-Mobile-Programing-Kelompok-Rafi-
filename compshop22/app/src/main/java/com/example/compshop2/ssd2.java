package com.example.compshop2;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.R.string.no;
import static android.os.Build.VERSION_CODES.N;


public class ssd2 extends AppCompatActivity {


    int quantity = 0;
    private int message;

    Button ssd2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssd2);
        ssd2Button = (Button) findViewById(R.id.ssd2button);
    }

    public void increment(View view){//perintah tombol tambah
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }

    public void decrement(View view){//perintah tombol tambah
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }


    public void Submitorder(View view) {


        Toast.makeText(this,"Order Succesfully",Toast.LENGTH_SHORT).show();

        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(haswhippedcream);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price,haswhippedcream);


        displayMessage(pricemessage);

        Intent i = new Intent(ssd2.this,myorder.class);
        startActivity(i);

    }

    private int calculateprice(boolean addwhipedcream){//jumlah pesanan * harga
        int harga=800000;

        if(addwhipedcream){
            harga=harga+0000;//harga tambahan toping
        }

        return quantity * harga;
    }

    private String createOrderSummary(int price, boolean addWhippedCream) {//hasil pemesanan
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