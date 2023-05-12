package com.example.unify;

import android.os.Bundle;
import android.widget.Adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InterfacePrincipale extends AppCompatActivity {



    RecyclerView recyclerView ;
    LinearLayoutManager layoutManager ;
    List<MusiqueItem>m ;
    Adapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_principale);

      initData();
      initRecyclerView();


    }

    private void initData() {
        m = new ArrayList<>();
        m.add(new MusiqueItem("Lucrece","Fodouop","When I was your man", R.drawable.fond));
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerview_m) ;
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        RAdapterMus adapter = new RAdapterMus(m) ;
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    }


