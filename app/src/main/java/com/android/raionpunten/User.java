package com.android.raionpunten;

public class User {
    private String nama,email,password,tanggal,domisili;

    public User() {
    }

    public User(String nama, String email, String password, String tanggal, String domisili) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.tanggal = tanggal;
        this.domisili = domisili;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getDomisili() {
        return domisili;
    }

    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }
}
