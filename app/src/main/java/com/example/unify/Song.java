package com.example.unify;

public class Song {
    private final String auteur;
    private final String titre;

    public Song(String auteur, String titre) {
        this.auteur = auteur;
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }
}
