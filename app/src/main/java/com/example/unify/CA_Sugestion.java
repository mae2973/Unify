package com.example.unify;

public class CA_Sugestion {
    private final String icon;
    private final String titre;
    private final String auteur;

    public CA_Sugestion(String icon, String titre, String auteur) {
        this.icon = icon;
        this.titre = titre;
        this.auteur = auteur;
    }

    public String getIcon() {
        return icon;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }
}
