package com.example.compshop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class FlashAdapter extends BaseAdapter {

    private Context mContext;
    private List<ProductFlash> mProductFlashList;

    public FlashAdapter(Context mContext, List<ProductFlash> mProductFlashList) {
        this.mContext = mContext;
        this.mProductFlashList = mProductFlashList;
    }

    @Override
    public int getCount() {
        return mProductFlashList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductFlashList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.row_flashdisk, null);
        TextView tvName = (TextView)v.findViewById(R.id.name);
        TextView tvPrice = (TextView)v.findViewById(R.id.price);
//        TextView tvDescription = (TextView)v.findViewById(R.id.description);

        tvName.setText(mProductFlashList.get(position).getName());
        tvPrice.setText(String.valueOf( "Rp " + mProductFlashList.get(position).getPrice()));
//        tvDescription.setText(mProductList.get(position).getDescription());

        v.setTag(mProductFlashList.get(position).getId());

        return v;
    }
}
