package com.android.raionpunten;

public class Model {
    private String Posisi,Deskripsi,Nama;

    public Model() {
    }

    public Model(String posisi, String deskripsi, String nama) {
        Posisi = posisi;
        Deskripsi = deskripsi;
        Nama = nama;
    }

    public String getPosisi() {
        return Posisi;
    }

    public void setPosisi(String posisi) {
        Posisi = posisi;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        Deskripsi = deskripsi;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }
}
