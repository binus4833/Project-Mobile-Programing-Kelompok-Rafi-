package com.example.compshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class memory_list extends AppCompatActivity {

    private ListView lvProduct;
    private MemoryAdapter adapter;
    private List<ProductMemory> product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_list);

        lvProduct = (ListView) findViewById(R.id.listview_product_ram);

        product = new ArrayList<>();

        product.add(new ProductMemory(1, "Memory 2 GB", 150000));
        product.add(new ProductMemory(2, "Memory 4 GB", 800000));
        product.add(new ProductMemory(3, "Memory 8 GB", 1200000));
        product.add(new ProductMemory(4, "Memory 16 GB", 1500000));

        adapter = new MemoryAdapter(getApplicationContext(),  product);
        lvProduct.setAdapter(adapter);


        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if(position == 0)
                {
                    startActivity(new Intent(view.getContext(), memory1.class));
                }

                else if(position == 1)
                {
                    startActivity(new Intent(view.getContext(), memory2.class));
                }

                else if(position == 2)
                {
                    startActivity(new Intent(view.getContext(), memory3.class));
                }


                else if(position == 3)
                {
                    startActivity(new Intent(view.getContext(), memory4.class));
                }



            }
        });
    }
}