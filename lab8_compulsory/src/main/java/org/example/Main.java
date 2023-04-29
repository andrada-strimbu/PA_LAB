package org.example;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            // get a connection from the pool
            connection = Database.getConnection();

            // use the connection
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM albums");
            ResultSet resultSet = preparedStatement.executeQuery();

            // process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String artist = resultSet.getString("artist");
                int releaseYear = resultSet.getInt("release_year");
                String genres = resultSet.getString("genre");
                System.out.printf("id: %d, title: %s, artist: %s, release year: %d, genre: %s\n",
                        id, title, artist, releaseYear, genres);
            }

            // close the result set, statement, and connection
            Database.closeResultSet(resultSet);
            Database.closePreparedStatement(preparedStatement);
            Database.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}