package com.example.compshop_myorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class mouse_list extends AppCompatActivity {

    private ListView lvProduct;
    private MouseAdapter adapter;
    private List<ProductMouse> product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mouse_list);

        lvProduct = (ListView) findViewById(R.id.listview_product_hard);

        product = new ArrayList<>();

        product.add(new ProductMouse(1, "Wired Mouse", 80000));
        product.add(new ProductMouse(2, "Wireless Mouse", 150000));

        adapter = new MouseAdapter(getApplicationContext(), product);
        lvProduct.setAdapter(adapter);


        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if(position == 0)
                {
                    startActivity(new Intent(view.getContext(), mouse1.class));
                }

                else if(position == 1)
                {
                    startActivity(new Intent(view.getContext(), mouse2.class));
                }

            }
        });
    }
}