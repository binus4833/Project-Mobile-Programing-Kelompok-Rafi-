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

public class memory3 extends AppCompatActivity {

    int memory3_quantity = 0;
    private int message;
    public static final String PREFS_NAME = "PrefsFile";

    Button memory3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory3);

        SharedPreferences memory3 = getSharedPreferences(PREFS_NAME, 0);
        memory3_quantity =memory3.getInt("memory3_quantity", memory3_quantity);


        memory3Button = (Button) findViewById(R.id.memory3button);
    }

    public void increment(View view){//perintah tombol tambah
        if(memory3_quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        memory3_quantity = memory3_quantity+1 ;
        display(memory3_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(memory3_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void decrement(View view){//perintah tombol kurang
        if (memory3_quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        memory3_quantity = memory3_quantity -1;
        display(memory3_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(memory3_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }


    public void Submitorder(View view) {
        Toast.makeText(this,"Order Succesfully",Toast.LENGTH_SHORT).show();

        SharedPreferences memory3 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =memory3.edit();
        pEditor.putInt("memory3_quantity", memory3_quantity).apply();

        Intent k2 = new Intent(memory3.this,myorder.class);
        k2.putExtra("MEMORY3_QUANTITY", memory3_quantity);
        startActivity(k2);

    }

    private int calculateprice(int memory3_quantity){//jumlah pesanan * harga
        int harga=1200000;

//        if(addwhipedcream){
//            harga=harga+0000;//harga tambahan toping
//        }

        return memory3_quantity * harga;
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