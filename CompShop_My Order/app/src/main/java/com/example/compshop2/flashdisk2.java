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

public class flashdisk2 extends AppCompatActivity {

    int flashdisk2_quantity = 0;
    private int message;
    public static final String PREFS_NAME = "PrefsFile";

    Button flashdisk2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashdisk3);

        SharedPreferences flashdisk2 = getSharedPreferences(PREFS_NAME, 0);
        flashdisk2_quantity =flashdisk2.getInt("flashdisk2_quantity", flashdisk2_quantity);


        flashdisk2Button = (Button) findViewById(R.id.flashdisk2button);
    }

    public void increment(View view){//perintah tombol tambah
        if(flashdisk2_quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        flashdisk2_quantity = flashdisk2_quantity+1 ;
        display(flashdisk2_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(flashdisk2_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void decrement(View view){//perintah tombol kurang
        if (flashdisk2_quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        flashdisk2_quantity = flashdisk2_quantity -1;
        display(flashdisk2_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(flashdisk2_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }


    public void Submitorder(View view) {
        Toast.makeText(this,"Order Succesfully",Toast.LENGTH_SHORT).show();

        SharedPreferences flashdisk2 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =flashdisk2.edit();
        pEditor.putInt("flashdisk2_quantity", flashdisk2_quantity).apply();

        Intent f2 = new Intent(flashdisk2.this,myorder.class);
        f2.putExtra("FLASHDISK2_QUANTITY", flashdisk2_quantity);
        startActivity(f2);

    }

    private int calculateprice(int flashdisk2_quantity){//jumlah pesanan * harga
        int harga=50000;

//        if(addwhipedcream){
//            harga=harga+0000;//harga tambahan toping
//        }

        return flashdisk2_quantity * harga;
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