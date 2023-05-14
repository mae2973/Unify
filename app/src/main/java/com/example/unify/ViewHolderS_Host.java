package com.example.unify;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderS_Host extends RecyclerView.ViewHolder {

    ImageView image4 ;
    TextView auteur4,titre4 , init4 ;

    public ViewHolderS_Host(@NonNull View itemView) {
        super(itemView);
        image4 = itemView.findViewById(R.id.rv_image_s_h) ;
        auteur4 = itemView.findViewById(R.id.auteur_s_h) ;
        titre4 = itemView.findViewById(R.id.titre_s_h) ;
        init4 = itemView.findViewById(R.id.ini_s_h) ; }


    public void setData(int r4, String a4, String t4, String i4) {
        image4.setImageResource(r4) ;
        auteur4.setText(a4);
        titre4.setText(t4);
        init4.setText(i4);
    }
}
