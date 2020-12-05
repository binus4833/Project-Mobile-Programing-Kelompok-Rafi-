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

public class flashdisk1 extends AppCompatActivity {

    int flashdisk1_quantity = 0;
    private int message;
    public static final String PREFS_NAME = "PrefsFile";

    Button flashdisk1Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashdisk1);

        SharedPreferences flashdisk1 = getSharedPreferences(PREFS_NAME, 0);
        flashdisk1_quantity =flashdisk1.getInt("flashdisk1_quantity", flashdisk1_quantity);


        flashdisk1Button = (Button) findViewById(R.id.flashdisk1button);
    }

    public void increment(View view){//perintah tombol tambah
        if(flashdisk1_quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        flashdisk1_quantity = flashdisk1_quantity+1 ;
        SharedPreferences flashdisk1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =flashdisk1.edit();
        pEditor.putInt("flashdisk1_quantity", flashdisk1_quantity).apply();
        display(flashdisk1_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(flashdisk1_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void decrement(View view){//perintah tombol kurang
        if (flashdisk1_quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        flashdisk1_quantity = flashdisk1_quantity -1;
        SharedPreferences flashdisk1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =flashdisk1.edit();
        pEditor.putInt("flashdisk1_quantity", flashdisk1_quantity).apply();
        display(flashdisk1_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(flashdisk1_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }


    public void Submitorder(View view) {
        Toast.makeText(this,"Order Succesfully",Toast.LENGTH_SHORT).show();

        SharedPreferences flashdisk1 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =flashdisk1.edit();
        pEditor.putInt("flashdisk1_quantity", flashdisk1_quantity).apply();

        Intent f1 = new Intent(flashdisk1.this,myorder.class);
        f1.putExtra("FLASHDISK1_QUANTITY", flashdisk1_quantity);
        startActivity(f1);

    }

    private int calculateprice(int flashdisk1_quantity){//jumlah pesanan * harga
        int harga=30000;

//        if(addwhipedcream){
//            harga=harga+0000;//harga tambahan toping
//        }

        return flashdisk1_quantity * harga;
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