package com.example.unify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterS_Host extends RecyclerView.Adapter<ViewHolderS_Host> {

    private ArrayList<SuggestionItemHost> suggestions_host ;

    public AdapterS_Host(ArrayList<SuggestionItemHost> suggestions_host) {
        this.suggestions_host = suggestions_host;
    }

    @NonNull
    @Override
    public ViewHolderS_Host onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.proposition_music_host,parent,false) ;
        return new ViewHolderS_Host(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderS_Host holder, int position) {
        int r4 = suggestions_host.get(position).getIcon();
        String a4 = suggestions_host.get(position).getSong().getAuteur();
        String t4 = suggestions_host.get(position).getSong().getTitre();
        String i4 = suggestions_host.get(position).getUser().getFirstLetter();

        holder.setData(r4,a4,t4,i4) ;
    }

    @Override
    public int getItemCount() {
        return suggestions_host.size();
    }
}
