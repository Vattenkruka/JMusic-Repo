package com.example.jmusicDemo.data_access;

import com.example.jmusicDemo.models.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArtistRepository {

    public static ArrayList<Artist> getRandomArtists(int amountOfArtists) {

        var artistList = new ArrayList<Artist>();
        Connection conn = null;
        String sql = "SELECT ArtistId, Name FROM Artist ORDER BY RANDOM() LIMIT?";

        try {
            conn = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, amountOfArtists);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                artistList.add(new Artist(resultSet.getInt("ArtistId"), resultSet.getString("Name")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionHelper.close(conn);
        }
        return artistList;
    }
}
