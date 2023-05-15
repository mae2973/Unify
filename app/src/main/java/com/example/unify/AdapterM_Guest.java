package com.example.unify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterM_Guest extends RecyclerView.Adapter<ViewHolderM_Guest> {
    private ArrayList<RvMusiqueItem> songs2 ;

    public AdapterM_Guest(ArrayList<RvMusiqueItem> songs) {
        this.songs2 = songs2;

    }


    @NonNull
    @Override
    public ViewHolderM_Guest onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.z_item_rv_musique,parent,false) ;
        return new ViewHolderM_Guest(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderM_Guest holder, int position) {
        int resource2 = songs2.get(position).getIcone();
        String a2 = songs2.get(position).getSong().getAuteur();
        String t2 = songs2.get(position).getSong().getTitre();
        String i2 = songs2.get(position).getUser().getFirstLetter();

        holder.setData(resource2,a2,t2,i2) ;

    }

    @Override
    public int getItemCount() {
        return songs2.size();
    }
}
