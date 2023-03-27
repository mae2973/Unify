package com.example.unify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class GridAdapter extends BaseAdapter { // Attributs

    Context context ;
    String[] nom_participants ;
    String[] ini_participants ;
    int[] image ;

    LayoutInflater inflater ;


    // Constructeur
    public GridAdapter(Context context, String[] nom_participants, String[] ini_participants, int[] image) {
        this.context = context;
        this.nom_participants = nom_participants;
        this.ini_participants = ini_participants;
        this.image = image;


    }

    @Override
    public int getCount() {
        return nom_participants.length;
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
        TextView textView1 = convertView.findViewById(R.id.item_name) ;
        TextView textView2 = convertView.findViewById(R.id.initiales) ;


        imageView.setImageResource(image[position]) ;
        textView1.setText(nom_participants[position]) ;
        textView2.setText(ini_participants[position]) ;


        return convertView ;
    }
}
