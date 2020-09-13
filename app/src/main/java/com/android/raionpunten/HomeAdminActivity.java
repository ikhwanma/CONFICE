package com.android.raionpunten;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class HomeAdminActivity extends AppCompatActivity {
    Button btnBuat,btnSubmit;
    EditText inputKode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);
        btnBuat = findViewById(R.id.btnBuat);
        btnSubmit = findViewById(R.id.btnCari);
        inputKode = findViewById(R.id.inputKode);

        btnBuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeAdminActivity.this,BuatKerjaActivity.class);
                startActivity(intent);
            }
        });
    }
}