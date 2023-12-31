package com.example.btl_android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.w3c.dom.Text;

public class ThongTinDiaDiem extends FragmentActivity {
    public static SQLite db;

    ViewPager2 viewPager;

    TabLayout tabLayout;

    TextView tvTenDiaDiem;

    private String tenDiaDiem;

    private String tinh;

    ImageView btnBack;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_dia_diem );

        db = new SQLite(ThongTinDiaDiem.this, "dulich.sqlite", null, 1);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager2) findViewById(R.id.view_pager);
        tvTenDiaDiem = (TextView) findViewById(R.id.tvTittle);
        btnBack = (ImageView) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThongTinDiaDiem.this, InforLocation.class);

                Cursor data = db.GetData("SELECT * FROM DiaDiem WHERE tenDiaDiem = " + "'"  + tenDiaDiem + "'");
            while (data.moveToNext()){
                tinh = data.getString(3);
            }


                intent.putExtra("Tinh", tinh);
                startActivity(intent);


            }
        });

        // lay du lieu tu intent cua inforlocation ra de su dung
        Intent intent = getIntent();
        tenDiaDiem = intent.getStringExtra("diadiem");
        tvTenDiaDiem.setText(tenDiaDiem);

        // truyen du lieu vao fragment
//        Bundle bundle = new Bundle();
//        bundle.putString("tenDiaDiem", tenDiaDiem);
//        Log.e("Ten Dia Diem", bundle.getString("tenDiaDiem") );
//        ThongTinFragment thongTinFragment = new ThongTinFragment();
//        thongTinFragment.setArguments(bundle);


        FragmentAdapter adapter = new FragmentAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0 :
                        tab.setText("Thông tin");
                        break;
                    case 1:
                        tab.setText("Khách sạn");
                        break;
                    default:
                        tab.setText("Thông tin");
                        break;
                }
            }
        }).attach();

    }

    public Bundle getData(){
        Bundle bundle = new Bundle();
        bundle.putString("tenDiaDiem", tenDiaDiem);
        return bundle;
    }


}