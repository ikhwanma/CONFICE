package com.android.raionpunten;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyAdapter extends FirebaseRecyclerAdapter<Model, MyAdapter.MyViewHolder> {
    DatabaseReference Rootref = FirebaseDatabase.getInstance().getReference();

    public MyAdapter(@NonNull FirebaseRecyclerOptions<Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final MyViewHolder holder, int position, @NonNull final Model model) {
        holder.nama.setText(model.getNama());
        holder.bidang.setText(model.getPosisi());
        holder.deskripsi.setText(model.getDeskripsi());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.style_row,parent,false);
        return new MyViewHolder(view);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nama,bidang,deskripsi;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.viewNamaa);
            bidang = itemView.findViewById(R.id.textViewBidang);
            deskripsi = itemView.findViewById(R.id.viewDeskripsi);
        }
    }
}
