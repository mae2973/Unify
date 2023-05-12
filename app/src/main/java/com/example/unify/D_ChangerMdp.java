package com.example.unify;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class D_ChangerMdp extends AppCompatActivity {

    Button buttonValider;

    Button buttonAnnuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_changer_mdp);

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