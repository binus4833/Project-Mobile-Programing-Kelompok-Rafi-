package com.example.compshoplistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Ssd_List extends AppCompatActivity {

    private ListView lvProduct;
    private SSDAdapter adapter;
    private List<ProductSSD> product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssd__list);

        lvProduct = (ListView) findViewById(R.id.listview_product_ssd);

        product = new ArrayList<>();

        product.add(new ProductSSD(1, "SSD 1 TB", 500000));
        product.add(new ProductSSD(2, "SSD 2 TB", 800000));
        product.add(new ProductSSD(3, "SSD 3 TB", 1200000));
        product.add(new ProductSSD(4, "SSD 4 TB", 1700000));

        adapter = new SSDAdapter(getApplicationContext(),  product);
        lvProduct.setAdapter(adapter);


        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if(position == 0)
                {
                    startActivity(new Intent(view.getContext(), ssd1.class));
                }

                else if(position == 1)
                {
                    startActivity(new Intent(view.getContext(), ssd2.class));
                }

                else if(position == 2)
                {
                    startActivity(new Intent(view.getContext(), ssd3.class));
                }


                else if(position == 3)
                {
                    startActivity(new Intent(view.getContext(), ssd4.class));
                }



            }
        });
    }
}
