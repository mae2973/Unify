package com.example.unify;
import android.content.ClipData;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adaptation pour la classe MenuSuggestionPart
public class Sugestion extends RecyclerView.Adapter<MyViewHolder> {

    Context context ;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}








   /* private final String icon;
    private final String titre;
    private final String auteur;

    public Sugestion(String icon, String titre, String auteur) {
        this.icon = icon;
        this.titre = titre;
        this.auteur = auteur;
    }

    public String getIcon() {
        return icon;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }
} */
