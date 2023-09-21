package com.example.btl_android;

public class taikhoan {
    private  String email,hoten,matkhau;

    public taikhoan(String email, String hoten, String matkhau) {
        this.email = email;
        this.hoten = hoten;
        this.matkhau = matkhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
