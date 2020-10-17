package com.example.jmusicDemo.models;

public class Artist {

    private String name;
    private int artistId;
    
    public Artist(int artistId, String name) {
        this.artistId = artistId;
        this.name = name;
    }


    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
