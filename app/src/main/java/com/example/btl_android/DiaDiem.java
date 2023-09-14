package com.example.btl_android;

public class DiaDiem {
    private int IdDiaDiem;
    private String TenDiaDiem, DiaChiCuThe, ThongTin;
    private double Rate;
    private byte[] Hinh;

    public DiaDiem(int idDiaDiem, String tenDiaDiem, String diaChiCuThe, String thongTin, double rate, byte[] hinh) {
        IdDiaDiem = idDiaDiem;
        TenDiaDiem = tenDiaDiem;
        DiaChiCuThe = diaChiCuThe;
        ThongTin = thongTin;
        Rate = rate;
        Hinh = hinh;
    }

    public int getIdDiaDiem() {
        return IdDiaDiem;
    }

    public void setIdDiaDiem(int idDiaDiem) {
        IdDiaDiem = idDiaDiem;
    }

    public String getTenDiaDiem() {
        return TenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        TenDiaDiem = tenDiaDiem;
    }

    public String getDiaChiCuThe() {
        return DiaChiCuThe;
    }

    public void setDiaChiCuThe(String diaChiCuThe) {
        DiaChiCuThe = diaChiCuThe;
    }

    public String getThongTin() {
        return ThongTin;
    }

    public void setThongTin(String thongTin) {
        ThongTin = thongTin;
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