package com.android.raionpunten;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class cek extends AppCompatActivity {
    Button btnCari,btnMasuk,btnBuat,btnLowongan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek);
        btnBuat = findViewById(R.id.btnBuat);
        btnCari = findViewById(R.id.btnCari);
        btnMasuk = findViewById(R.id.btnMasuk);
        btnLowongan = findViewById(R.id.btnLowongan);

        btnLowongan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cek.this,LowonganActivity.class);
                startActivity(intent);
            }
        });
        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cek.this,CariKerjaActivity.class);
                startActivity(intent);
            }
        });
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cek.this,MasukKantorActivity.class);
                startActivity(intent);
            }
        });
        btnBuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cek.this,BuatKerjaActivity.class);
                startActivity(intent);
            }
        });
    }
}