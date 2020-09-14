package com.android.raionpunten;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class LowonganActivity extends AppCompatActivity {
    EditText inputPosisi,inputNama,inputDeskripsi;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lowongan);
        inputPosisi = findViewById(R.id.inputPosisi);
        inputNama = findViewById(R.id.inputNama);
        inputDeskripsi = findViewById(R.id.inputDeskripsi);
        btnSubmit = findViewById(R.id.button);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuatLowongan();
            }
        });
    }
    public void BuatLowongan(){
        final String nama = inputNama.getText().toString();
        final String posisi = inputPosisi.getText().toString();
        final String deskripsi = inputDeskripsi.getText().toString();
        if(posisi.isEmpty()){
            inputPosisi.setError("Posisi Tidak Boleh Kosong");
            inputPosisi.setFocusable(true);
        }else if(nama.isEmpty()){
            inputNama.setError("Nama Tidak Boleh Kosong");
            inputNama.setFocusable(true);
        }else if(deskripsi.isEmpty()){
            inputDeskripsi.setError("Deskripsi Tidak Boleh Kosong");
            inputDeskripsi.setFocusable(true);
        }else{
            final DatabaseReference Rootref;

            Rootref = FirebaseDatabase.getInstance().getReference();
            Rootref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("Nama",nama);
                    userdataMap.put("Posisi",posisi);
                    userdataMap.put("Deskripsi",deskripsi);
                    Rootref.child("Perusahaan").child(nama).updateChildren(userdataMap);
                    Intent intent = new Intent(LowonganActivity.this,BerandaActivity.class);
                    startActivity(intent);
                    Toast.makeText(LowonganActivity.this, "Lowongan Pekerjaan Dibuat", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

    }
}