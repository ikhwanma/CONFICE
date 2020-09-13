package com.android.raionpunten;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PilihDaftarActivity extends AppCompatActivity {
    private Button btnKaryawan,btnAdmin;
    String karyawan = "karyawan";
    String admin = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_daftar);
        btnKaryawan = findViewById(R.id.btnKaryawan);
        btnAdmin = findViewById(R.id.btnAdmin);
        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PilihDaftarActivity.this,DaftarAdminActivity.class);
                intent.putExtra("jenis",admin);
                startActivity(intent);
            }
        });
        btnKaryawan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PilihDaftarActivity.this,DaftarAdminActivity.class);
                intent.putExtra("jenis",karyawan);
                startActivity(intent);
            }
        });
    }
}