package com.android.raionpunten;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class AkunActivity extends AppCompatActivity {
    EditText editNama,editTanggal,editDomisili;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);
        editNama = findViewById(R.id.editNama);
        editDomisili = findViewById(R.id.editDomisili);
        editTanggal = findViewById(R.id.editTanggal);
        btnSimpan = findViewById(R.id.btnSimpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanData();
            }
        });
    }

    private void simpanData(){
        String nama = editNama.getText().toString();
        String domisili = editDomisili.getText().toString();
        String tanggal = editTanggal.getText().toString();

        if(nama.isEmpty()){
            editNama.setError("Nama Tidak Boleh Kosong");
            editNama.setFocusable(true);
        }else if(domisili.isEmpty()){
            editDomisili.setError("Domisili Tidak Boleh Kosong");
            editDomisili.setFocusable(true);
        }else if(tanggal.length()!=6){
            editTanggal.setError("Tanggal Tidak Boleh Kosong");
            editTanggal.setFocusable(true);
        }else{
            registerUser(nama,tanggal,domisili);
        }
    }

    private void registerUser(final String nama, final String tanggal, final String domisili){
        final DatabaseReference Rootref;
        Rootref = FirebaseDatabase.getInstance().getReference();
        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                HashMap<String, Object> userdataMap = new HashMap<>();
                userdataMap.put("nama",nama);
                userdataMap.put("tanggal",tanggal);
                userdataMap.put("domisili",domisili);

                Rootref.child("User").child(Prevalent.currentOnlineUser.getEmail()).updateChildren(userdataMap);
                Prevalent.currentOnlineUser.setNama(nama);
                Prevalent.currentOnlineUser.setTanggal(tanggal);
                Prevalent.currentOnlineUser.setDomisili(domisili);

                Intent intent = new Intent(AkunActivity.this,BerandaActivity.class);
                startActivity(intent);
                Toast.makeText(AkunActivity.this, "Akun Diupdate", Toast.LENGTH_SHORT).show();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}