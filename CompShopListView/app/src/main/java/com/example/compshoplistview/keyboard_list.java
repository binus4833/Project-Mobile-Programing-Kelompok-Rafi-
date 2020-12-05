package com.example.compshoplistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class keyboard_list extends AppCompatActivity {

    private ListView lvProduct;
    private KeyboardAdapter adapter;
    private List<ProductKey> product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_list);

        lvProduct = (ListView) findViewById(R.id.listview_product_ssd);

        product = new ArrayList<>();

        product.add(new ProductKey(1, "Wired Keyboard", 300000));
        product.add(new ProductKey(2, "Wireless Keyboard", 500000));

        adapter = new KeyboardAdapter(getApplicationContext(),  product);
        lvProduct.setAdapter(adapter);


        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if(position == 0)
                {
                    startActivity(new Intent(view.getContext(), keyboard1.class));
                }

                else if(position == 1)
                {
                    startActivity(new Intent(view.getContext(), keyboard2.class));
                }


            }
        });
    }
}