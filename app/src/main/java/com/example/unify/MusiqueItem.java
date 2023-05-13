package com.example.unify;

public class MusiqueItem {
    String prenom_participant ;
    String nom_participant ;
    String titre_musique ;
    int icone ;

    public MusiqueItem(String p, String n, String t, int i) {
        this.prenom_participant = p ;
        this.nom_participant = n;
        this.titre_musique = t ;
        this.icone = i;
    }

    public String getPrenom_participant() {
        return prenom_participant;
    }

    public String getNom_participant() {
        return nom_participant;
    }

    public String getTitre_musique() {
        return titre_musique;
    }

    public int getIcone() {
        return icone ;
    }
}
