package com.example.unify;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class mon_compte extends AppCompatActivity {

    Button buttonRetour;
    private TextView textViewIdentifiant;
    private TextView textViewNom;
    private TextView textViewPrenom;
    private TextView textViewMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_mon_compte__a_refaire);

        textViewIdentifiant = findViewById(R.id.identifiant);
        textViewNom = findViewById(R.id.nom);
        textViewPrenom = findViewById(R.id.prenom);
        textViewMail = findViewById(R.id.mail);


        Intent intent = getIntent();
       String identifiant = intent.getStringExtra("IDENTIFIANT_EXTRA");


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("user")
                .whereEqualTo("identifiant", identifiant)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            QuerySnapshot querySnapshot = task.getResult();
                            if (!querySnapshot.isEmpty()) {
                                DocumentSnapshot document = querySnapshot.getDocuments().get(0);
                                String nom = document.getString("nom");
                                String prenom = document.getString("prenom");
                                String mail = document.getString("mail");

                                textViewIdentifiant.setText(identifiant);
                                textViewNom.setText(nom);
                                textViewPrenom.setText(prenom);
                                textViewMail.setText(mail);
                            } else {
                                Log.d("mon_compte", "Aucun document trouvé pour l'identifiant : " + identifiant);
                            }
                        } else {
                            Log.d("mon_compte", "Erreur lors de la récupération du document : " + task.getException());
                        }
                    }
                });

        buttonRetour = findViewById(R.id.buttonRetour);
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonRetour();
            }
        });

    }

    private void setButtonRetour(){
        this.finish();
    }
}
