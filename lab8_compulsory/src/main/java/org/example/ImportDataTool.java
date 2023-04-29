package org.example;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;


public class ImportDataTool {

    private static final String URL = "jdbc:postgresql://localhost:5432/lab8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Andrada/Downloads/archive/albumlist.csv"));
            String line;

            while ((line = reader.readLine()) != null) {

                try {
                    String[] values = line.split(",");
                    int id = Integer.parseInt(values[0]);
                    int releaseYear = Integer.parseInt(values[1]);
                    String title = values[2];
                    String artist = values[3];
                    String genre = values[4];
                    String genres= values[5];
                    String albumQuery = "INSERT INTO albums (id, release_year, title, artist, genre) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement ps_album = conn.prepareStatement(albumQuery);
                    ps_album.setInt(1, id);
                    ps_album.setInt(2, releaseYear);
                    ps_album.setString(3, title);
                    ps_album.setString(4, artist);
                    ps_album.setString(5, genre);
                    ps_album.executeUpdate();
                    System.out.println(genre);
                    String artistsQuery = "INSERT INTO artists (name) VALUES (?) ON CONFLICT (name) DO NOTHING";
                    PreparedStatement ps_artist = conn.prepareStatement(artistsQuery, Statement.RETURN_GENERATED_KEYS);
                    ps_artist.setString(1, artist);
                    int affectedRowsArtist = ps_artist.executeUpdate();
                    if (affectedRowsArtist > 0) {
                        ResultSet generatedKeysArtist = ps_artist.getGeneratedKeys();
                        if (generatedKeysArtist.next()) {
                          //  System.out.println("Successfully inserted row with ID: " + generatedKeysArtist.getInt(1));
                        }

                        generatedKeysArtist.close(); // close the ResultSet to reset it
                    }
                    String genreQuery="INSERT INTO genres (name) VALUES(?) ON CONFLICT(name) DO NOTHING";
                    PreparedStatement ps_genre=conn.prepareStatement(genreQuery,Statement.RETURN_GENERATED_KEYS);
                    ps_genre.setString(1,genre);
                    int affectedRowsGenre= ps_genre.executeUpdate();
                    if(affectedRowsGenre>0){
                        ResultSet generatedKeysGenre=ps_genre.getGeneratedKeys();
                        if(generatedKeysGenre.next()){
                           // System.out.println("suucessfully"+generatedKeysGenre.getInt(1));
                        }
                        generatedKeysGenre.close();
                    }

                } catch (NumberFormatException | SQLException e) {
                    System.out.println("Error in line: " + line);
                }

            }
            System.out.println("Data imported successfully ");
            String albums_genresQuery="INSERT INTO albums_genres (id, album_id, genre_id)\n" +
                    "SELECT row_number() OVER (ORDER BY al.id), al.id, g.id\n" +
                    "FROM albums al\n" +
                    "JOIN genres g ON al.genre = g.name";
            PreparedStatement ps_albums_genres=conn.prepareStatement(albums_genresQuery);
            ps_albums_genres.executeUpdate();
            reader.close();
            conn.close();
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


