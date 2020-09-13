package com.android.raionpunten;

public class DataFB {
    private String nama;
    private String bidang;

    public DataFB(String nama, String bidang) {
        this.nama = nama;
        this.bidang = bidang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBidang() {
        return bidang;
    }

    public void setBidang(String bidang) {
        this.bidang = bidang;
    }
}
