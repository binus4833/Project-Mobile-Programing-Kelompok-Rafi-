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

public class memory4 extends AppCompatActivity {

    int memory4_quantity = 0;
    private int message;
    public static final String PREFS_NAME = "PrefsFile";

    Button memory4Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory4);

        SharedPreferences memory4 = getSharedPreferences(PREFS_NAME, 0);
        memory4_quantity =memory4.getInt("memory4_quantity", memory4_quantity);


        memory4Button = (Button) findViewById(R.id.memory4button);
    }

    public void increment(View view){//perintah tombol tambah
        if(memory4_quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        memory4_quantity = memory4_quantity+1 ;
        display(memory4_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(memory4_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void decrement(View view){//perintah tombol kurang
        if (memory4_quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        memory4_quantity = memory4_quantity -1;
        display(memory4_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(memory4_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }


    public void Submitorder(View view) {
        Toast.makeText(this,"Order Succesfully",Toast.LENGTH_SHORT).show();

        SharedPreferences memory4 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =memory4.edit();
        pEditor.putInt("memory4_quantity", memory4_quantity).apply();

        Intent k2 = new Intent(memory4.this,myorder.class);
        k2.putExtra("MEMORY4_QUANTITY", memory4_quantity);
        startActivity(k2);

    }

    private int calculateprice(int memory4_quantity){//jumlah pesanan * harga
        int harga=1500000;

//        if(addwhipedcream){
//            harga=harga+0000;//harga tambahan toping
//        }

        return memory4_quantity * harga;
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