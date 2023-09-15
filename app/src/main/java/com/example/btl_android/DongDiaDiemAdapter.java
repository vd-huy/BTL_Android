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
import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class DongDiaDiemAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<DiaDiem> diaDiemList;

    public DongDiaDiemAdapter(Context context, int layout, ArrayList<DiaDiem> diaDiemList) {
        this.context = context;
        this.layout = layout;
        this.diaDiemList = diaDiemList;
    }

    @Override
    public int getCount() {
        return diaDiemList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView tenDiaDiem,diaChiDiaDiem;
        MaterialRatingBar rate;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imageViewDiaDiem);
            viewHolder.tenDiaDiem = (TextView) view.findViewById(R.id.TenDiaDiem);
            viewHolder.diaChiDiaDiem = (TextView) view.findViewById(R.id.DiaChiCuThe);
            viewHolder.rate = (MaterialRatingBar) view.findViewById(R.id.rate);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        DiaDiem diaDiem = diaDiemList.get(i);
        viewHolder.tenDiaDiem.setText(diaDiem.getTenDiaDiem());
        viewHolder.diaChiDiaDiem.setText(diaDiem.getDiaChiCuThe());
        viewHolder.rate.setRating((float) diaDiem.getRate());

        // chuyen byte[] -> bitmap
        byte[] hinhAnh = diaDiem.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh, 0, hinhAnh.length);
        viewHolder.imageView.setImageBitmap(bitmap);

        return view;
    }
}
