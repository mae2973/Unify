package com.example.unify;

public class GridItem {

    private String prenom_part ;
    private String nom_part ;
    private int icone ;


    public GridItem(String prenom_part, String nom_part, int icone) {
        this.prenom_part = prenom_part;
        this.nom_part = nom_part;
        this.icone = icone;
    }

    public String getPrenom_part() {
        return prenom_part;
    }

    public String getNom_part() {
        return nom_part;
    }

    public int getIcone() {
        return icone;
    }
}
