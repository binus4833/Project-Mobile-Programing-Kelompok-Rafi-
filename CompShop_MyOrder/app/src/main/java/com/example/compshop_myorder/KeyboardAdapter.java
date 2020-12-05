package com.example.compshop_myorder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class KeyboardAdapter extends BaseAdapter {

    private Context mContext;
    private List<ProductKey> Product;

    public KeyboardAdapter(Context mContext, List<ProductKey> Product) {
        this.mContext = mContext;
        this.Product = Product;
    }

    @Override
    public int getCount() {
        return Product.size();
    }

    @Override
    public Object getItem(int position) {
        return Product.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.row_keyboard, null);
        TextView tvName = (TextView)v.findViewById(R.id.name);
        TextView tvPrice = (TextView)v.findViewById(R.id.price);
//        TextView tvDescription = (TextView)v.findViewById(R.id.description);

        tvName.setText(Product.get(position).getName());
        tvPrice.setText(String.valueOf( "Rp " + Product.get(position).getPrice()));
//        tvDescription.setText(mProductList.get(position).getDescription());

        v.setTag(Product.get(position).getId());

        return v;
    }

}
