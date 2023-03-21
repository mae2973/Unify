package com.example.unify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InterfacePrincipale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_principale);
        setContentView(R.layout.menu_suggestions_part) ;
    }
}