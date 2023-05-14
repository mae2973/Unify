package com.example.unify;

public class MusiqueItem_Guest {

    String prenom_participant2 ;
    String nom_participant2 ;
    String titre_musique2 ;
    int icone2 ;

    public MusiqueItem_Guest(String p2, String n2, String t2, int i2) {
        this.prenom_participant2 = p2;
        this.nom_participant2 = n2;
        this.titre_musique2 = t2;
        this.icone2 = i2;
    }

    public String getPrenom_participant2() {
        return prenom_participant2;
    }

    public String getNom_participant2() {
        return nom_participant2;
    }

    public String getTitre_musique2() {
        return titre_musique2;
    }

    public int getIcone2() {
        return icone2;
    }
}
