package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class mon_compte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_mon_compte__a_refaire);

        Intent intent = getIntent();

        if (intent.hasExtra("IDENTIFIANT_EXTRA")) {
            String identifiant = intent.getStringExtra("IDENTIFIANT_EXTRA");


            // Par exemple, affichez-le dans un TextView
            TextView textView = findViewById(R.id.textView);
            textView.setText(identifiant);
        }

    }
}