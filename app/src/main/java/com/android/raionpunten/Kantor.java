package com.android.raionpunten;

public class Kantor {
    private String Nama,Domisili,Bidang,Pemilik,Kode;

    public Kantor() {
    }

    public Kantor(String nama, String domisili, String bidang, String pemilik, String kode) {
        Nama = nama;
        Domisili = domisili;
        Bidang = bidang;
        Pemilik = pemilik;
        Kode = kode;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getDomisili() {
        return Domisili;
    }

    public void setDomisili(String domisili) {
        Domisili = domisili;
    }

    public String getBidang() {
        return Bidang;
    }

    public void setBidang(String bidang) {
        Bidang = bidang;
    }

    public String getPemilik() {
        return Pemilik;
    }

    public void setPemilik(String pemilik) {
        Pemilik = pemilik;
    }

    public String getKode() {
        return Kode;
    }

    public void setKode(String kode) {
        Kode = kode;
    }
}
