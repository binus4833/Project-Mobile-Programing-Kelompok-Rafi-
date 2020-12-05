package com.example.customlistviewadapterexam;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView lvProduct;
    private ProductListAdapter adapter;
    private List<Product> mProductList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProduct = (ListView) findViewById(R.id.listview_product);

        mProductList = new ArrayList<>();

        mProductList.add(new Product(1, "Flash Disc Sand Disc", 25000, "High Speed"));
        mProductList.add(new Product(2, "Flash Disc Kingston", 25000, "High Speed"));
        mProductList.add(new Product(3, "Flash Disc V-Gen", 25000, "High Speed"));
        mProductList.add(new Product(4, "Flash Disc Toshiba", 25000, "High Speed"));
        mProductList.add(new Product(5, "Flash Disc Evo", 25000, "High Speed"));

        adapter = new ProductListAdapter(getApplicationContext(), mProductList);
        lvProduct.setAdapter(adapter);

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicked Product Id = " + view.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
