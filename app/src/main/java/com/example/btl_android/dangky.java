package com.example.btl_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dangky extends AppCompatActivity {

    Button dangky,dangnhap;

    EditText EDHoTen,EDtendangnhap,EDmatkhau,EDnhaplaimatkhau;

    String sHoten,sTendangnhap,smatkhau,snhaplaimatkhau;

   public static SQLite db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        anhxa();

        db = new SQLite(dangky.this,"dulich.sqlite",null,1);

        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sHoten = EDHoTen.getText().toString();
                sTendangnhap = EDtendangnhap.getText().toString();
                smatkhau = EDmatkhau.getText().toString();
                snhaplaimatkhau = EDnhaplaimatkhau.getText().toString();

                if(smatkhau.equals(snhaplaimatkhau) && !sHoten.isEmpty() && !sTendangnhap.isEmpty())
                {
                    db.INSERT_Taikhoan(sTendangnhap,sHoten,smatkhau);
                    Toast.makeText(dangky.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                }
                else if ( sHoten.isEmpty() || sTendangnhap.isEmpty())
                {
                    Toast.makeText(dangky.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(dangky.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                }

            }
        });

        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangky.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void anhxa() {
        dangnhap = (Button) findViewById(R.id.dangnhap);
        dangky = (Button) findViewById(R.id.dangky);
        EDHoTen = (EditText) findViewById(R.id.Hoten);
        EDtendangnhap = (EditText) findViewById(R.id.tendangnhap);
        EDmatkhau = (EditText) findViewById(R.id.matkhau);
        EDnhaplaimatkhau = (EditText) findViewById(R.id.nhaplaimatkhau);

    }
}


