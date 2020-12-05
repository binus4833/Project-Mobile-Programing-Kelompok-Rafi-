package com.example.compshop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MemoryAdapter extends BaseAdapter {

    private Context mContext;
    private List<ProductMemory> product;

    public MemoryAdapter(Context mContext, List<ProductMemory> product) {
        this.mContext = mContext;
        this.product = product;
    }

    @Override
    public int getCount() {
        return product.size();
    }

    @Override
    public Object getItem(int position) {
        return product.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.row_memory, null);
        TextView tvName = (TextView)v.findViewById(R.id.name);
        TextView tvPrice = (TextView)v.findViewById(R.id.price);
//        TextView tvDescription = (TextView)v.findViewById(R.id.description);

        tvName.setText(product.get(position).getName());
        tvPrice.setText(String.valueOf( "Rp " + product.get(position).getPrice()));
//        tvDescription.setText(mProductList.get(position).getDescription());

        v.setTag(product.get(position).getId());

        return v;
    }

}
