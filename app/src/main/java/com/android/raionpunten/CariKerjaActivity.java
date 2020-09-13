package com.android.raionpunten;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class CariKerjaActivity extends AppCompatActivity {
    private RecyclerView mList;
    private DatabaseReference Rootref;
    TextView ada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_kerja);
        Rootref = FirebaseDatabase.getInstance().getReference().child("Perusahaan");
        Rootref.keepSynced(true);
        ada = findViewById(R.id.textView2);
        mList = (RecyclerView) findViewById(R.id.viewKerja);
        mList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<DataFB>().setQuery(Rootref,DataFB.class).build();
        FirebaseRecyclerAdapter<DataFB, DataViewHolder> adapter = new FirebaseRecyclerAdapter<DataFB, DataViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final DataViewHolder holder, int position, @NonNull final DataFB model) {
                final String name = getRef(position).getKey();
                Rootref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(name.isEmpty()){
                            ada.setText("aaaa");
                        }else{
                            String nama = snapshot.child("nama").getValue().toString();
                            String bidang = snapshot.child("bidang").getValue().toString();
                            holder.lihatNama.setText(nama);
                            holder.lihatBidang.setText(bidang);
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }

            @NonNull
            @Override
            public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.style_row,parent,false);
                DataViewHolder viewHolder = new DataViewHolder(view);
                return viewHolder;
            }
        };
        mList.setAdapter(adapter);
        adapter.startListening();
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder{
        TextView lihatNama,lihatBidang;
        public DataViewHolder(View itemView) {
            super(itemView);
            lihatNama = itemView.findViewById(R.id.viewNama);
            lihatBidang = itemView.findViewById(R.id.textViewBidang);

        }
    }
}