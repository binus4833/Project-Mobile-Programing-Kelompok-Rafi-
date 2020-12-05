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

public class flashdisk3 extends AppCompatActivity {

    int flashdisk3_quantity = 0;
    private int message;
    public static final String PREFS_NAME = "PrefsFile";

    Button flashdisk3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashdisk3);

        SharedPreferences flashdisk3 = getSharedPreferences(PREFS_NAME, 0);
        flashdisk3_quantity =flashdisk3.getInt("flashdisk3_quantity", flashdisk3_quantity);


        flashdisk3Button = (Button) findViewById(R.id.flashdisk2button);
    }

    public void increment(View view){//perintah tombol tambah
        if(flashdisk3_quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        flashdisk3_quantity = flashdisk3_quantity+1 ;
        display(flashdisk3_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(flashdisk3_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void decrement(View view){//perintah tombol kurang
        if (flashdisk3_quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        flashdisk3_quantity = flashdisk3_quantity -1;
        display(flashdisk3_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(flashdisk3_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }


    public void Submitorder(View view) {
        Toast.makeText(this,"Order Succesfully",Toast.LENGTH_SHORT).show();

        SharedPreferences flashdisk3 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =flashdisk3.edit();
        pEditor.putInt("flashdisk3_quantity", flashdisk3_quantity).apply();

        Intent f3 = new Intent(flashdisk3.this,myorder.class);
        f3.putExtra("FLASHDISK3_QUANTITY", flashdisk3_quantity);
        startActivity(f3);

    }

    private int calculateprice(int flashdisk1_quantity){//jumlah pesanan * harga
        int harga=120000;

//        if(addwhipedcream){
//            harga=harga+0000;//harga tambahan toping
//        }

        return flashdisk3_quantity * harga;
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