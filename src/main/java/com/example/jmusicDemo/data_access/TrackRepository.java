package com.example.jmusicDemo.data_access;

import com.example.jmusicDemo.models.SearchData;
import com.example.jmusicDemo.models.Track;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrackRepository {

    public static ArrayList<Track> getRandomTracks(int amountOfTracks) {
        var trackList = new ArrayList<Track>();
        Connection conn = null;
        String sql = "SELECT TrackId,Name FROM Track ORDER BY RANDOM() LIMIT?";

        try {
            conn = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, amountOfTracks);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                trackList.add(new Track(resultSet.getInt("TrackId"), resultSet.getString("Name")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionHelper.close(conn);
        }
        return trackList;
    }

    public static ArrayList<SearchData> getTracksWhichContainsWord(String queryStatement) {
        var resultList = new ArrayList<SearchData>();

        Connection conn = null;

        String sql = "SELECT Track.Name as Track, Artist.Name as Artist, Album.Title as Album, Genre.Name as Genre FROM Track JOIN Album on Track.AlbumId=Album.AlbumId JOIN Artist on Artist.ArtistId = Album.ArtistId JOIN Genre on Genre.GenreId = Track.GenreId WHERE UPPER(Track.Name) LIKE UPPER(?)";

        try {
            conn = ConnectionHelper.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, queryStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                resultList.add(new SearchData(resultSet.getString("track"), resultSet.getString("artist"), resultSet.getString("album"), resultSet.getString("genre")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionHelper.close(conn);
        }
        return resultList;
    }
}
