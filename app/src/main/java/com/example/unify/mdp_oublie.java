package com.example.unify;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class mdp_oublie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mdp_oublie);
    }

    Button button_validation = (Button)findViewById(R.id.open_activity_button);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, MyOtherActivity.class));
        }
    });
}