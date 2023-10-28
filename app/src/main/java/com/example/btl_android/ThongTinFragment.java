package com.example.btl_android;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ThongTinFragment extends Fragment {

    public static SQLite db;

    public static DiaDiem diaDiem;

    public  ImageView imageViewDiaDiem;

    public  TextView textViewDiaDiem;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  (ViewGroup)inflater.inflate(R.layout.fragment_thong_tin,container,false);


        imageViewDiaDiem = view.findViewById(R.id.imgAnhDiaDiem);
        textViewDiaDiem = view.findViewById(R.id.tvThongTinDiaDiem);

        if (diaDiem != null) {
            textViewDiaDiem.setText(diaDiem.getThongTin());

            byte[] hinhAnh = diaDiem.getHinh();
            Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh, 0, hinhAnh.length);
            imageViewDiaDiem.setImageBitmap(bitmap);
        }

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new SQLite(getContext(), "dulich.sqlite", null, 1);

        Bundle args = getArguments();
        if(args != null){
            String tenDiaDiem = args.getString("tenDiaDiem");
            Log.e("Ten Dia Diem", tenDiaDiem );
            loadDiaDiemData(tenDiaDiem);
        }


    }

    private void loadDiaDiemData(String tenDiaDiem) {


        Cursor data = db.GetData("SELECT * FROM DiaDiem WHERE tenDiaDiem = '" + tenDiaDiem + "'");

        if (data != null && data.moveToFirst()) {
            diaDiem = new DiaDiem(
                    data.getInt(0),
                    data.getString(1),
                    data.getString(4),
                    data.getString(2),
                    data.getDouble(5),
                    data.getBlob(6)
            );

            data.close(); // Đóng Cursor sau khi sử dụng
        }


    }
}