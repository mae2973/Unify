package com.example.unify;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView icone;
        private TextView prenom_part;
        private TextView nom_part;
        private TextView titre;

        public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                icone = itemView.findViewById(R.id.icone) ;
                prenom_part = itemView.findViewById(R.id.prenom_part);
                nom_part = itemView.findViewById(R.id.nom_part);
                titre = itemView.findViewById(R.id.titre);
        }

        public void setData(int resource, String p, String n, String t) {
                icone.setImageResource(resource);
                prenom_part.setText(p);
                nom_part.setText(n);
                titre.setText(t);
        }
}

