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

public class flashdisk4 extends AppCompatActivity {

    int flashdisk4_quantity = 0;
    private int message;
    public static final String PREFS_NAME = "PrefsFile";

    Button flashdisk4Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashdisk4);

        SharedPreferences flashdisk4 = getSharedPreferences(PREFS_NAME, 0);
        flashdisk4_quantity =flashdisk4.getInt("flashdisk4_quantity", flashdisk4_quantity);


        flashdisk4Button = (Button) findViewById(R.id.flashdisk4button);
    }

    public void increment(View view){//perintah tombol tambah
        if(flashdisk4_quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        flashdisk4_quantity = flashdisk4_quantity+1 ;
        display(flashdisk4_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(flashdisk4_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }

    public void decrement(View view){//perintah tombol kurang
        if (flashdisk4_quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        flashdisk4_quantity = flashdisk4_quantity -1;
        display(flashdisk4_quantity);

//        CheckBox whippedcreamChekBox= (CheckBox) findViewById(R.id.WhippedCream_checkbox);
//        boolean haswhippedcream=whippedcreamChekBox.isChecked();//mengidentifikasi check
//        Log.v("MainActivity","has whippedcream:"+haswhippedcream);


        int price=calculateprice(flashdisk4_quantity);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);
    }


    public void Submitorder(View view) {
        Toast.makeText(this,"Order Succesfully",Toast.LENGTH_SHORT).show();

        SharedPreferences flashdisk4 = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor pEditor =flashdisk4.edit();
        pEditor.putInt("flashdisk4_quantity", flashdisk4_quantity).apply();

        Intent f4 = new Intent(com.example.compshop.flashdisk4.this,myorder.class);
        f4.putExtra("FLASHDISK4_QUANTITY", flashdisk4_quantity);
        startActivity(f4);

    }

    private int calculateprice(int flashdisk1_quantity){//jumlah pesanan * harga
        int harga=200000;

//        if(addwhipedcream){
//            harga=harga+0000;//harga tambahan toping
//        }

        return flashdisk4_quantity * harga;
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