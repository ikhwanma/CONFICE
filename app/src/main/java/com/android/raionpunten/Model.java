package com.android.raionpunten;

public class Model {
    private String Bidang;

    private String Nama;

    public Model() {
    }

    public Model(String bidang, String nama) {
        Bidang = bidang;
        Nama = nama;
    }

    public String getBidang() {
        return Bidang;
    }

    public void setBidang(String bidang) {
        Bidang = bidang;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }
}
