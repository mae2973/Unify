package com.example.unify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdaptater_guest extends BaseAdapter {

    private Context context2;
    private ArrayList<GridItem_guest> participant2;
    private LayoutInflater inflater2;

    public GridAdaptater_guest(Context context2, ArrayList<GridItem_guest> participant2, LayoutInflater inflater2) {
        this.context2 = context2;
        this.participant2 = participant2;
        this.inflater2 = inflater2;
    }

    @Override
    public int getCount() {
        return participant2.size();
    }

    @Override
    public GridItem_guest getItem(int position) {
         return participant2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater2.inflate(R.layout.grid_item, viewGroup, false);
        }
        ImageView im3 = view.findViewById(R.id.grid_image);
        TextView p3 = view.findViewById(R.id.item_firstname);
        TextView n3 = view.findViewById(R.id.item_lastname);
        TextView i3 = view.findViewById(R.id.initiale);

        GridItem_guest item = getItem(position);

        im3.setImageResource(item.getIcone3());
        p3.setText(item.getUser3().getFirstName());
        n3.setText(item.getUser3().getLastName());
        i3.setText(item.getUser3().getFirstLetter());

        return view;

    }
}
