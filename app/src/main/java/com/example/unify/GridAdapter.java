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


    // Constructeur
    public GridAdapter(Context context, String[] nom_participants, String[] ini_participants, int[] image) {
        this.context = context;
        this.nom_participants = nom_participants;
        this.ini_participants = this.ini_participants;
        this.image = image;

        LayoutInflater inflater ;
    }

    @Override
    public int getCount() {
        return nom_participants.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = null;
        if (inflater==null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;


        View convertView = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_item,null) ;
        }

        ImageView imageView = convertView.findViewById(R.id.grid_image) ;
        TextView textView1 = convertView.findViewById(R.id.item_name) ;
        TextView textView2 = convertView.findViewById(R.id.initiales) ;

        int position = 0;
        imageView.setImageResource(image[position]) ;
        textView1.setText(nom_participants[position]) ;
        textView2.setText(ini_participants[position]) ;


        return convertView ;
    }
}
