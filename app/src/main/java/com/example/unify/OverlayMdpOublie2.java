package com.example.unify;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.unify.databinding.ActivityOverlayMdpOublie2Binding;
import com.google.android.material.snackbar.Snackbar;

public class OverlayMdpOublie2 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityOverlayMdpOublie2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOverlayMdpOublie2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}