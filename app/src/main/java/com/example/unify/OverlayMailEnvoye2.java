package com.example.unify;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.unify.databinding.ActivityOverlayMailEnvoye2Binding;

public class OverlayMailEnvoye2 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityOverlayMailEnvoye2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOverlayMailEnvoye2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
    }
}