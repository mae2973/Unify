package com.example.unify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdaptater extends BaseAdapter {

    private Context context;
    private ArrayList<GridItem> participant;
    private LayoutInflater inflater ;

    public GridAdaptater(Context context, ArrayList<GridItem> participant, LayoutInflater inflater) {
        this.context = context;
        this.participant = participant;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return participant.size();
    }

    @Override
    public GridItem getItem(int position) {
        return participant.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }
        ImageView im = view.findViewById(R.id.grid_image);
        TextView p = view.findViewById(R.id.item_firstname);
        TextView n = view.findViewById(R.id.item_lastname);

        // Récupération de l'objet GridItem correspondant à cette position
        GridItem item = getItem(position);

        // Configuration des éléments de la vue à partir de l'objet GridItem
        im.setImageResource(item.getIcone());
        n.setText(item.getNom_part());
        p.setText(item.getPrenom_part());


        return view;
    }
}

    /*
    private final String[] prenom;
    private final String[] nom;
    private final int image[];
    Context context;

    private LayoutInflater inflater;

    public GridAdaptater(String[] prenom, String[] nom, int[] image, Context context) {
        this.prenom = prenom;
        this.nom = nom;
        this.image = image;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return prenom.length;
    }


    @Override
    public GridItem getItem(int position) {
        return new GridItem(prenom[position], nom[position], image[position]);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.grid_item, null);
        ImageView icon = view.findViewById(R.id.grid_image);
        TextView p = view.findViewById(R.id.item_firstname);
        TextView n = view.findViewById(R.id.item_lastname);

        icon.setImageResource(image[i]);
        p.setText(prenom[i]);
        n.setText(nom[i]);

        return view;
    }
}
*/