package com.example.unify;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderS extends RecyclerView.ViewHolder {

        ImageView image2 ;
        TextView auteur2,titre2 , init2 ;

        public ViewHolderS(@NonNull View itemView) {
                super(itemView);
                image2 = itemView.findViewById(R.id.rv_image_s) ;
                auteur2 = itemView.findViewById(R.id.auteur_s) ;
                titre2 = itemView.findViewById(R.id.titre_s) ;
                init2 = itemView.findViewById(R.id.ini_s) ;
        }

        public void setData(int r1, String a1, String t1, String i1) {
                image2.setImageResource(r1) ;
                auteur2.setText(a1);
                titre2.setText(t1);
                init2.setText(i1);
        }
}
