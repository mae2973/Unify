package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class overlay_changer_mdp extends AppCompatActivity {

    Button buttonValider;

    Button buttonAnnuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overlay_changer_mdp);

        buttonValider = findViewById(R.id.valid);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonValider();
            }
        });
    }

    private void setButtonValider() {
        this.finish();
    }
}