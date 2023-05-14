package com.example.unify;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderM extends RecyclerView.ViewHolder {

    ImageView image ;
    TextView auteur,titre , init ;

    public ViewHolderM(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.rv_image) ;
        auteur = itemView.findViewById(R.id.auteur) ;
        titre = itemView.findViewById(R.id.titre) ;
        init = itemView.findViewById(R.id.ini) ;
    }

    public void setData(int resource, String a, String t, String i) {
        image.setImageResource(resource) ;
        auteur.setText(a);
        titre.setText(t);
        init.setText(i);


    }
}
