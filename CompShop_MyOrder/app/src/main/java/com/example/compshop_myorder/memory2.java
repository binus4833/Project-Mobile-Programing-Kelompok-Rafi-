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

public class memory2 extends AppCompatActivity {

    int memory2_quantity = 0;
    private int message;
    public static final String PREFS_NAME = "PrefsFile";

    Button memory2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory2);

        SharedPreferences memory2 = getSharedPreferences(PREFS_NAME, 0);
        memory2_quantity =memory2.getInt("memory2_quantity", memory2_quantity);


        memory2Button = (Button) findViewById(R.id.memory2button);
    }

    public void increment(View view){//perintah tombol tambah
        if(memory2_quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        memory2_quantity = memory2_quantity+1 ;
        display(memory2_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(memory2_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void decrement(View view){//perintah tombol kurang
        if (memory2_quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        memory2_quantity = memory2_quantity -1;
        display(memory2_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(memory2_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }


    public void Submitorder(View view) {
        Toast.makeText(this,"Order Succesfully",Toast.LENGTH_SHORT).show();

        SharedPreferences memory2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =memory2.edit();
        pEditor.putInt("memory2_quantity", memory2_quantity).apply();

        Intent k2 = new Intent(memory2.this,myorder.class);
        k2.putExtra("MEMORY2_QUANTITY", memory2_quantity);
        startActivity(k2);

    }

    private int calculateprice(int memory2_quantity){//jumlah pesanan * harga
        int harga=800000;

//        if(addwhipedcream){
//            harga=harga+0000;//harga tambahan toping
//        }

        return memory2_quantity * harga;
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