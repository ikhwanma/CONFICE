package com.android.raionpunten;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class BuatKerjaActivity extends AppCompatActivity {
    private EditText inputNama,inputBidang;
    private Button btnSetuju;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_kerja);
        inputNama = findViewById(R.id.inputNama);
        inputBidang = findViewById(R.id.inputBidang);
        btnSetuju = findViewById(R.id.btnSetuju);
        btnSetuju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuatKerja();
                Intent intent = new Intent(BuatKerjaActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void BuatKerja(){
        final String nama = inputNama.getText().toString();
        final String bidang = inputBidang.getText().toString();

        final DatabaseReference Rootref;
        Rootref = FirebaseDatabase.getInstance().getReference();
        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                HashMap<String, Object> userdataMap = new HashMap<>();
                userdataMap.put("Nama",nama);
                userdataMap.put("Bidang",bidang);

                Rootref.child("Perusahaan").child(nama).updateChildren(userdataMap);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}