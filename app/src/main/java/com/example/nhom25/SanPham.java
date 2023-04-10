package com.example.nhom25;

public class SanPham {
    private String maSp, tenSP, soLuong;

    public SanPham(String maSp, String tenSP, String soLuong) {
        this.maSp = maSp;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
    }

    public SanPham() {
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSp='" + maSp + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", soLuong='" + soLuong + '\'' +
                '}';
    }
}
