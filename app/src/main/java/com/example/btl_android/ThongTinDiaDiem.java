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
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.w3c.dom.Text;

public class ThongTinDiaDiem extends FragmentActivity {
    ViewPager2 viewPager;

    TabLayout tabLayout;

    TextView tvTenDiaDiem;

    private String tenDiaDiem;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_dia_diem );

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager2) findViewById(R.id.view_pager);
        tvTenDiaDiem = (TextView) findViewById(R.id.tvTittle);

        // lay du lieu tu intent cua inforlocation ra de su dung
        Intent intent = getIntent();
        tenDiaDiem = intent.getStringExtra("diadiem");
        tvTenDiaDiem.setText(tenDiaDiem);

        // truyen du lieu vao fragment
        ThongTinFragment thongTinFragment = new ThongTinFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tenDiaDiem", tenDiaDiem);
        thongTinFragment.setArguments(bundle);

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


}