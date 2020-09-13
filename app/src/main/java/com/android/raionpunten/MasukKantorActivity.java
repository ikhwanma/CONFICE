package com.android.raionpunten;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class MasukKantorActivity extends AppCompatActivity {
    EditText inputKode;
    Button btnCari;
    private String parentDb = "Kantor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk_kantor);
        inputKode = findViewById(R.id.inputKode);
        btnCari = findViewById(R.id.btnCari);

        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cariKantor();
            }
        });
    }
    private void cariKantor(){
        String kode = inputKode.getText().toString();

        if(TextUtils.isEmpty(kode)){
            Toast.makeText(this,"Masukkan Kode Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }else{
            allowAccess(kode);
        }
    }
    private void allowAccess(final String kode){
        final DatabaseReference Rootref;
        Rootref = FirebaseDatabase.getInstance().getReference();
        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(parentDb).child(kode).exists()){
                    Kantor dataUser = dataSnapshot.child(parentDb).child(kode).getValue(Kantor.class);
                    Intent intent = new Intent(MasukKantorActivity.this,KantorActivity.class);
                    ActiveKantor.currentOnlineKantor = dataUser;
                    startActivity(intent);
                    Toast.makeText(MasukKantorActivity.this, "Anda Login Sebagai Admin", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MasukKantorActivity.this, "Kode "+kode+" Tidak Tersedia", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}