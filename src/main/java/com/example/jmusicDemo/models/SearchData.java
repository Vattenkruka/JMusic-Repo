package com.example.jmusicDemo.models;

public class SearchData {
    private String trackName;
    private String albumName;
    private String artistName;
    private String genreName;

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public SearchData(String trackName, String albumName, String artistName, String genreName) {
        this.trackName = trackName;
        this.albumName = albumName;
        this.artistName = artistName;
        this.genreName = genreName;
    }
}
