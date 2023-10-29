package com.example.btl_android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class DongKhachSanAdapter extends BaseAdapter {

    private Context context ;
    private int layout;
    private ArrayList<KhachSan> khachSanList;

    public DongKhachSanAdapter(Context context, int layout, ArrayList<KhachSan> khachSanList) {
        this.context = context;
        this.layout = layout;
        this.khachSanList = khachSanList;
    }

    @Override
    public int getCount() {
        return khachSanList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder{
        ImageView imageView;

        TextView tenKhachSan,diaChiKhachSan;

        MaterialRatingBar rate;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imageViewKhachSan);
            viewHolder.tenKhachSan = (TextView) view.findViewById(R.id.TenKhachSan);
            viewHolder.diaChiKhachSan = (TextView) view.findViewById(R.id.DiaChiKhachSan);
            viewHolder.rate = (MaterialRatingBar) view.findViewById(R.id.rateKhachSan);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        KhachSan khachSan = khachSanList.get(i);
        viewHolder.tenKhachSan.setText(khachSan.getTenKhachSan());
        viewHolder.diaChiKhachSan.setText(khachSan.getDiaChi());
        viewHolder.rate.setRating((float) khachSan.getRate());

        // chuyen byte[] -> bitmap
        byte[] hinhAnh = khachSan.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh, 0, hinhAnh.length);
        viewHolder.imageView.setImageBitmap(bitmap);

        return view;
    }
}
