package com.example.compshoplistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HardDiskList extends AppCompatActivity {

    private ListView lvProduct;
    private HardAdapter adapter;
    private List<ProductHard> mProductHardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_disk_list);

        lvProduct = (ListView) findViewById(R.id.listview_product_hard);

        mProductHardList = new ArrayList<>();

        mProductHardList.add(new ProductHard(1, "Hard Disk 1 TB", 800000));
        mProductHardList.add(new ProductHard(2, "Hard Disk 2 TB", 1200000));
        mProductHardList.add(new ProductHard(3, "Hard Disk 3 TB", 1700000));
        mProductHardList.add(new ProductHard(4, "Hard Disk 4 TB", 2200000));

        adapter = new HardAdapter(getApplicationContext(), mProductHardList);
        lvProduct.setAdapter(adapter);


        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if(position == 0)
                {
                    startActivity(new Intent(view.getContext(), harddisk1.class));
                }

                else if(position == 1)
                {
                    startActivity(new Intent(view.getContext(), harddisk2.class));
                }

                else if(position == 2)
                {
                    startActivity(new Intent(view.getContext(), harddisk3.class));
                }


                else if(position == 3)
                {
                    startActivity(new Intent(view.getContext(), harddisk4.class));
                }



            }
        });
    }
}
