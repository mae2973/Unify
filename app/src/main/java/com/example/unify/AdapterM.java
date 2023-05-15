package com.example.unify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterM extends RecyclerView.Adapter<ViewHolderM> {

    private ArrayList<RvMusiqueItem> songs ;

    public AdapterM(ArrayList<RvMusiqueItem> songs) {
        this.songs = songs;

    }


    @NonNull
    @Override
    public ViewHolderM onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.z_item_rv_musique,parent,false) ;
        return new ViewHolderM(view) ; }
       /* View view = inflater.inflate(R.layout.c_item_rv_musique, parent, false);
        ;*/


    @Override
    public void onBindViewHolder(@NonNull ViewHolderM holder, int position) {
         int resource = songs.get(position).getIcone();
         String a = songs.get(position).getSong().getAuteur();
         String t = songs.get(position).getSong().getTitre();
         String i = songs.get(position).getUser().getFirstLetter();

         holder.setData(resource,a,t,i) ;
        }


    @Override
    public int getItemCount() {
        return songs.size();
    }




}
