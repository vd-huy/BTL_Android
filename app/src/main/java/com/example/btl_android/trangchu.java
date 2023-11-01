package com.example.btl_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class trangchu extends AppCompatActivity {

    LinearLayout hanoi,danang,ninhbinh;

    public static SQLite db;

    ArrayAdapter adapterTinh;

    ArrayList<String> listTenTinh;

    AutoCompleteTextView autoCompleteTenTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);

        anhXa();

        db = new SQLite(trangchu.this, "dulich.sqlite", null, 1);

        listTenTinh = new ArrayList<>();

        Cursor data = db.GetData("Select * from Tinh");
        while(data.moveToNext()){
            listTenTinh.add(data.getString(1));
        }

        adapterTinh = new ArrayAdapter(trangchu.this, android.R.layout.simple_dropdown_item_1line,listTenTinh);

        autoCompleteTenTinh.setAdapter(adapterTinh);

        autoCompleteTenTinh.setThreshold(1);

        autoCompleteTenTinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(trangchu.this,InforLocation.class);
                intent.putExtra("Tinh", listTenTinh.get(i));
                startActivity(intent);
            }
        });


        hanoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(trangchu.this,InforLocation.class);
                intent.putExtra("Tinh", "Hà Nội");
                startActivity(intent);
            }
        });

        danang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(trangchu.this,InforLocation.class);
                intent.putExtra("Tinh", "Đà Nẵng");
                startActivity(intent);
            }
        });

        ninhbinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(trangchu.this,InforLocation.class);
                intent.putExtra("Tinh", "Ninh Bình");
                startActivity(intent);
            }
        });
    }


    private void anhXa(){
        hanoi = (LinearLayout) findViewById(R.id.hanoi);
        danang = (LinearLayout) findViewById(R.id.danang);
        ninhbinh = (LinearLayout) findViewById(R.id.ninhbinh);
        autoCompleteTenTinh = (AutoCompleteTextView) findViewById(R.id.autoCompleteTenTinh);
    }
}