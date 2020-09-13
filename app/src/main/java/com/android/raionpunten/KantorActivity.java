package com.android.raionpunten;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class KantorActivity extends AppCompatActivity {
    TextView viewKantor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kantor);
        viewKantor = findViewById(R.id.viewKantor);
        viewKantor.setText(ActiveKantor.currentOnlineKantor.getNama());
    }
}