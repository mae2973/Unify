package com.example.unify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast ;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;

import java.util.ArrayList;



public class GridAdapter extends ArrayAdapter<GridItem> {
    public GridAdapter(@NonNull Context context, int resource, ArrayList<GridItem> liste_participants) {
        super(context, 0, liste_participants);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = convertView;
        if (gridView == null) {
            gridView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

         GridItem g = getItem(position) ;

        ImageView im = convertView.findViewById(R.id.grid_image) ;
        TextView t1 = convertView.findViewById(R.id.item_firstname) ;
        TextView t2 = convertView.findViewById(R.id.item_lastname) ;
        TextView t3 = convertView.findViewById(R.id.initiales) ;


        t1.setText(g.getPrenom()) ;
        t2.setText(g.getNom()) ;
        t3.setText(g.getInitiale()) ;

        // pour charger l'image dans la grille
        int resourceId = getContext().getResources().getIdentifier(g.getInitiale().toLowerCase(), "drawable", getContext().getPackageName());
        im.setImageResource(resourceId);

        gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View gridView) {
                Toast.makeText(getContext(), "Item clicked is : " + g.getNom(), Toast.LENGTH_SHORT).show();
            }
        });
        return gridView;

    }

















/*
    Context context ;
    String[] nom_participants ;
    String[] prenom_participants ;
    String[] ini_participants ;
    int[] image ;

    LayoutInflater inflater ;


    // Constructeur
    public GridAdapter(Context context, String[] nom_participants, String[] prenom_participants, String[] ini_participants, int[] image) {
        this.context = context;
        this.nom_participants = nom_participants;
        this.prenom_participants = prenom_participants ;
        this.ini_participants = ini_participants;
        this.image = image;


    }

    @Override
    public int getCountn() {
        return nom_participants.length;
    }

    @Override
    public int getCountp() {return prenom_participants.length ;}

    @Override
    public int getCount() {

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater==null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;


        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_item,null) ;
        }

        ImageView imageView = convertView.findViewById(R.id.grid_image) ;
        TextView textView1 = convertView.findViewById(R.id.item_firstname) ;
        TextView textView2 = convertView.findViewById(R.id.item_lastname) ;
        TextView textView3 = convertView.findViewById(R.id.initiales) ;


        imageView.setImageResource(image[position]) ;
        textView1.setText(nom_participants[position]) ;
        textView2.setText(prenom_participants[position]) ;
        textView3.setText(ini_participants[position]) ;


        return convertView ;
    } */

}
