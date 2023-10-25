package com.example.btl_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class trangchu extends AppCompatActivity {

    LinearLayout hanoi,danang,ninhbinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);

        anhXa();

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
    }
}