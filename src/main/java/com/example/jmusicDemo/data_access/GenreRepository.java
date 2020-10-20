package com.example.jmusicDemo.data_access;

import com.example.jmusicDemo.models.Genre;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GenreRepository {
    public static ArrayList<Genre> getRandomGenres(int amountOfGenres) {
        var genreList = new ArrayList<Genre>();
        Connection conn = null;
        String sql = "SELECT GenreId, Name FROM Genre ORDER BY RANDOM() LIMIT?";

        try {
            conn = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, amountOfGenres);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                genreList.add(new Genre(resultSet.getInt("GenreId"), resultSet.getString("Name")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionHelper.close(conn);
        }
        return genreList;
    }
}
