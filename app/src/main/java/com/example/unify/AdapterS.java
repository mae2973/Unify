package com.example.unify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterS extends RecyclerView.Adapter<ViewHolderS> {

    private ArrayList<CA_Sugestion_TODO> suggestions ;

    public AdapterS(ArrayList<CA_Sugestion_TODO> suggestions) {

        this.suggestions = suggestions ; }

    @NonNull
    @Override
    public ViewHolderS onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.proposition_music,parent,false) ;
        return new ViewHolderS(view) ; }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderS holder, int position) {
        int r1 = suggestions.get(position).getIcon();
        String a1 = suggestions.get(position).getSong().getAuteur();
        String t1 = suggestions.get(position).getSong().getTitre();
        String i1 = suggestions.get(position).getUser().getFirstLetter();

        holder.setData(r1,a1,t1,i1) ;
    }

    @Override
    public int getItemCount() {
         return suggestions.size();
    }
}
