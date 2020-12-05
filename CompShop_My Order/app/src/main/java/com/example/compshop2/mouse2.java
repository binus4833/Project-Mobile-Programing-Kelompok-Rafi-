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
import android.content.SharedPreferences;

import java.text.NumberFormat;

import static android.R.string.no;
import static android.os.Build.VERSION_CODES.N;

public class mouse2 extends AppCompatActivity {

    int mouse2_quantity = 0;
    private int message;
    public static final String PREFS_NAME = "PrefsFile";

    Button mouse2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouse2);

        SharedPreferences mouse2 = getSharedPreferences(PREFS_NAME, 0);
        mouse2_quantity =mouse2.getInt("mouse1_quantity", mouse2_quantity);


        mouse2Button = (Button) findViewById(R.id.mouse2button);
    }

    public void increment(View view){//perintah tombol tambah
        if(mouse2_quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        mouse2_quantity = mouse2_quantity+1 ;
        display(mouse2_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(mouse2_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void decrement(View view){//perintah tombol kurang
        if (mouse2_quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        mouse2_quantity = mouse2_quantity -1;
        display(mouse2_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(mouse2_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }


    public void Submitorder(View view) {
        Toast.makeText(this,"Order Succesfully",Toast.LENGTH_SHORT).show();

        SharedPreferences mouse2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =mouse2.edit();
        pEditor.putInt("mouse2_quantity", mouse2_quantity).apply();

        Intent m2 = new Intent(mouse2.this,myorder.class);
        m2.putExtra("MOUSE2_QUANTITY", mouse2_quantity);
        startActivity(m2);

    }

    private int calculateprice(int mouse2_quantity){//jumlah pesanan * harga
        int harga=150000;

//        if(addwhipedcream){
//            harga=harga+0000;//harga tambahan toping
//        }

        return mouse2_quantity * harga;
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