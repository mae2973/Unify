package com.example.unify;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView initiale,titre;

public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        initiale = itemView.findViewById(R.id.ini);
        titre = itemView.findViewById(R.id.titre_chanson);
        }
        }

