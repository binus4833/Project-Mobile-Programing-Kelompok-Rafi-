package com.example.compshop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class HardAdapter extends BaseAdapter {

    private Context mContext;
    private List<ProductHard> mProductHardList;

    public HardAdapter(Context mContext, List<ProductHard> mProductHardList) {
        this.mContext = mContext;
        this.mProductHardList = mProductHardList;
    }

    @Override
    public int getCount() {
        return mProductHardList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductHardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.row_harddisk, null);
        TextView tvName = (TextView)v.findViewById(R.id.name);
        TextView tvPrice = (TextView)v.findViewById(R.id.price);
//        TextView tvDescription = (TextView)v.findViewById(R.id.description);

        tvName.setText(mProductHardList.get(position).getName());
        tvPrice.setText(String.valueOf( "Rp " + mProductHardList.get(position).getPrice()));
//        tvDescription.setText(mProductList.get(position).getDescription());

        v.setTag(mProductHardList.get(position).getId());

        return v;
    }
}
