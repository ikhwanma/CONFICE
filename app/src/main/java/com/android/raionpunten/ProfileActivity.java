package com.android.raionpunten;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    Button btnProfil,btnKantor,btnInfo;
    TextView viewNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        btnProfil = findViewById(R.id.btnProfil);
        btnKantor = findViewById(R.id.btnKantor);
        btnInfo = findViewById(R.id.btnInfo);
        viewNama = findViewById(R.id.viewNamaProfile);
        viewNama.setText(Prevalent.currentOnlineUser.getNama());

        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,AkunActivity.class);
                startActivity(intent);
            }
        });
    }
}