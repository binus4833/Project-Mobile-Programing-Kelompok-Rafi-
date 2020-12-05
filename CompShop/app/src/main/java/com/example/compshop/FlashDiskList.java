package com.example.compshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FlashDiskList extends AppCompatActivity {

    private ListView lvProduct;
    private FlashAdapter adapter;
    private List<ProductFlash> mProductFlashList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_disk_list);

        lvProduct = (ListView) findViewById(R.id.listview_product_flash);

        mProductFlashList = new ArrayList<>();

        mProductFlashList.add(new ProductFlash(1, "Flash Disc 8 GB", 30000));
        mProductFlashList.add(new ProductFlash(2, "Flash Disc 16 GB", 50000));
        mProductFlashList.add(new ProductFlash(3, "Flash Disc 32 GB", 120000));
        mProductFlashList.add(new ProductFlash(4, "Flash Disc 64 GB", 200000));

        adapter = new FlashAdapter(getApplicationContext(),  mProductFlashList);
        lvProduct.setAdapter(adapter);


        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if(position == 0)
                {
                    startActivity(new Intent(view.getContext(), flashdisk1.class));
                }

                else if(position == 1)
                {
                    startActivity(new Intent(view.getContext(), flashdisk2.class));
                }

                else if(position == 2)
                {
                    startActivity(new Intent(view.getContext(), flashdisk3.class));
                }


                else if(position == 3)
                {
                    startActivity(new Intent(view.getContext(), flashdisk4.class));
                }



            }
        });
    }
}