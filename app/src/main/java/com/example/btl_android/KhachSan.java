package com.example.btl_android;

public class KhachSan {
    private int IDKhachSan;

    private String TenKhachSan, DiaChi,  SoDienThoai;

    private double Rate;

    private byte[] Hinh;

    public KhachSan(int IDKhachSan, String tenKhachSan, String diaChi, String soDienThoai, double rate, byte[] hinh) {
        this.IDKhachSan = IDKhachSan;
        TenKhachSan = tenKhachSan;
        DiaChi = diaChi;
        SoDienThoai = soDienThoai;
        Rate = rate;
        Hinh = hinh;
    }

    public int getIDKhachSan() {
        return IDKhachSan;
    }

    public void setIDKhachSan(int IDKhachSan) {
        this.IDKhachSan = IDKhachSan;
    }

    public String getTenKhachSan() {
        return TenKhachSan;
    }

    public void setTenKhachSan(String tenKhachSan) {
        TenKhachSan = tenKhachSan;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double rate) {
        Rate = rate;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] hinh) {
        Hinh = hinh;
    }
}
