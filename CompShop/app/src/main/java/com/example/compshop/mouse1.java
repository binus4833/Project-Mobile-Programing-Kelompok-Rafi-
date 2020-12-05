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

public class mouse1 extends AppCompatActivity {

    int mouse1_quantity = 0;
    private int message;
    public static final String PREFS_NAME = "PrefsFile";

    Button mouse1Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouse1);

        SharedPreferences mouse1 = getSharedPreferences(PREFS_NAME, 0);
        mouse1_quantity =mouse1.getInt("mouse1_quantity", mouse1_quantity);


        mouse1Button = (Button) findViewById(R.id.mouse1button);
    }

    public void increment(View view){//perintah tombol tambah
        if(mouse1_quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        mouse1_quantity = mouse1_quantity+1 ;
        display(mouse1_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(mouse1_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void decrement(View view){//perintah tombol kurang
        if (mouse1_quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        mouse1_quantity = mouse1_quantity -1;
        display(mouse1_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(mouse1_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }


    public void Submitorder(View view) {
        Toast.makeText(this,"Order Succesfully",Toast.LENGTH_SHORT).show();

        SharedPreferences mouse1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =mouse1.edit();
        pEditor.putInt("mouse1_quantity", mouse1_quantity).apply();

        Intent m1 = new Intent(com.example.compshop.mouse1.this,myorder.class);
        m1.putExtra("MOUSE1_QUANTITY", mouse1_quantity);
        startActivity(m1);

    }

    private int calculateprice(int mouse1_quantity){//jumlah pesanan * harga
        int harga=80000;

//        if(addwhipedcream){
//            harga=harga+0000;//harga tambahan toping
//        }

        return mouse1_quantity * harga;
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