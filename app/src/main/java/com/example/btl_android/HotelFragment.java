package com.example.btl_android;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class HotelFragment extends Fragment {

    public static SQLite db;

    ListView lvKhachSan;

    ArrayList<KhachSan> khachSanArrayList;

    DongKhachSanAdapter adapter ;

    private String tenDiaDiem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = (ViewGroup)inflater.inflate(R.layout.fragment_hotel, container, false);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new SQLite(getContext(), "dulich.sqlite", null, 1);
        khachSanArrayList = new ArrayList<>();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lvKhachSan = (ListView) view.findViewById(R.id.lvKhachSan);

        //lay du lieu tu bundle
        ThongTinDiaDiem thongTinDiaDiem = (ThongTinDiaDiem)getActivity();
        Bundle result = thongTinDiaDiem.getData();
        tenDiaDiem = result.getString("tenDiaDiem");
        Log.e("Tên địa điểm", tenDiaDiem );

        adapter = new DongKhachSanAdapter(getActivity(),R.layout.dong_khach_san,khachSanArrayList);
        lvKhachSan.setAdapter(adapter);

        Cursor data = db.GetData("SELECT * FROM KhachSan WHERE tenDiaDiem = " + "'"  + tenDiaDiem + "'");
        while (data.moveToNext()){
            khachSanArrayList.add(new KhachSan(
                    data.getInt(0),
                    data.getString(1),
                    data.getString(4),
                    data.getString(2),
                    data.getDouble(5),
                    data.getBlob(6)
                    )
            );
        }

        Log.e("log", khachSanArrayList.get(0).getTenKhachSan() );

        adapter.notifyDataSetChanged();

        data.close();

        lvKhachSan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri number = Uri.parse("tel:" + khachSanArrayList.get(i).getSoDienThoai() );
                Intent dial = new Intent(Intent.ACTION_DIAL,number);
                startActivity(dial);
            }
        });

    }
}