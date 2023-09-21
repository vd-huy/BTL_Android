package com.example.btl_android;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {


    public SQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //truy van kh tra ket qua
    public void QueryData(String query){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(query);
    }

    //truy van co ket qua tra ve
    public Cursor GetData(String query){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(query,null);
    }

    // lenh insert
    public void INSERT_Tinh(String tenTinh) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO Tinh values (null,?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,tenTinh);
        statement.executeInsert();
    }

    public void INSERT_DiaDiem(String TenDiaDiem, String ThongTin, String TenTinh, String DiaChi, double Rate, byte[] HinhAnh) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO DiaDiem VALUES (null, ?, ?, ?, ?, ?, ?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,TenDiaDiem);
        statement.bindString(2,ThongTin);
        statement.bindString(3,TenTinh);
        statement.bindString(4,DiaChi);
        statement.bindDouble(5,Rate);
        statement.bindBlob(6,HinhAnh);
        statement.executeInsert();

    }

    public void INSERT_Taikhoan(String email, String hoten, String matkhau){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO TaiKhoan VALUES (?, ?, ?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,email);
        statement.bindString(2,hoten);
        statement.bindString(3,matkhau);
        statement.executeInsert();
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}

