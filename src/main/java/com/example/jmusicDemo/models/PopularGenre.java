package com.example.jmusicDemo.models;

import java.util.ArrayList;

public class PopularGenre {

    private String firstName;
    private String lastName;
    private String genreName;
    private int mostPopular;

    public PopularGenre(String firstName, String lastName, String genreName, int mostPopular) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.genreName = genreName;
        this.mostPopular = mostPopular;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public int getMostPopular() {
        return mostPopular;
    }

    public void setMostPopular(int mostPopular) {
        this.mostPopular = mostPopular;
    }

    public static ArrayList<PopularGenre> compareGenre(ArrayList<PopularGenre> mostPopularGenre) {
        ArrayList<PopularGenre> comparedGenre = new ArrayList<PopularGenre>();

        int max = 0;

        for (PopularGenre pg : mostPopularGenre) {
            if (pg.getMostPopular() >= max) {
                max = pg.getMostPopular();
            }
        }

        for (PopularGenre pg : mostPopularGenre) {
            if (pg.getMostPopular() == max) {
                comparedGenre.add(pg);
            }
        }

        return comparedGenre;
    }

}
