package com.example.unify;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class ViewHolderM_Guest extends RecyclerView.ViewHolder {

    ImageView image2;
    TextView auteur2, titre2, init2;

    public ViewHolderM_Guest(@NonNull View itemView) {
        super(itemView);
        image2 = itemView.findViewById(R.id.rv_image);
        auteur2 = itemView.findViewById(R.id.auteur);
        titre2 = itemView.findViewById(R.id.titre);
        init2 = itemView.findViewById(R.id.ini);
    }

    public void setData(int resource, String a, String t, String i) {
        image2.setImageResource(resource);
        auteur2.setText(a);
        titre2.setText(t);
        init2.setText(i);
    }
}
