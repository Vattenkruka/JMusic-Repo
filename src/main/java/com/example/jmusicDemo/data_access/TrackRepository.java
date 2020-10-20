package com.example.jmusicDemo.data_access;

import com.example.jmusicDemo.models.Track;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrackRepository {
    public static ArrayList<Track> getRandomTracks(int amountOfTracks){
        var trackList = new ArrayList<Track>();
        Connection conn = null;
        String sql = "SELECT TrackId, Name FROM Artist ORDER BY RANDOM() LIMIT?";

        try {
            conn = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, amountOfTracks);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                trackList.add(new Track(resultSet.getInt("TrackId"), resultSet.getString("Name")));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        finally {
            ConnectionHelper.close(conn);
        }
        return trackList;
    }

}
