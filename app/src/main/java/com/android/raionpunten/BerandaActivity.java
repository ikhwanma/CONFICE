package com.android.raionpunten;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BerandaActivity extends AppCompatActivity {
    private Button btncarikerja;
    private Button btnmasukkantor;
    private Button btnbuatkantor;
    private Button btnbuatlowongan;
    private Button btnProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        btnbuatkantor = findViewById(R.id.btnbuatkantor);
        btnmasukkantor = findViewById(R.id.btnmasukkantor);
        btncarikerja = findViewById(R.id.btncaripekerjaan);
        btnbuatlowongan = findViewById(R.id.btnbuatlowongan);
        btnProfile = findViewById(R.id.btnProfile);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BerandaActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });

        btncarikerja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCariPekerjaan = new Intent(BerandaActivity.this,CariKerjaActivity.class);
                startActivity(goToCariPekerjaan);
            }
        });

        btnmasukkantor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMasukKantor = new Intent(BerandaActivity.this,MasukKantorActivity.class);
                startActivity(goToMasukKantor);
            }
        });

        btnbuatkantor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToBuatKantor = new Intent(BerandaActivity.this,BuatKerjaActivity.class);
                startActivity(goToBuatKantor);
            }
        });

        btnbuatlowongan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToBuatLowongan = new Intent(BerandaActivity.this,LowonganActivity.class);
                startActivity(goToBuatLowongan);
            }
        });




    }


}