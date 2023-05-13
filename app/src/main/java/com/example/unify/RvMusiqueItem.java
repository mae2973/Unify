package com.example.unify;

public class RvMusiqueItem {

    private User user ;
    private int icone ;
    private Song song ;

    public RvMusiqueItem(User user, int icone, Song song) {
        this.user = user;
        this.icone = icone;
        this.song = song;
    }

    public User getUser() {
        return user;
    }

    public int getIcone() {
        return icone;
    }

    public Song getSong() {
        return song;
    }
}
