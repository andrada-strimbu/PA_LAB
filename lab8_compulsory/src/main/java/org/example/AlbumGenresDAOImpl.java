package org.example;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumGenresDAOImpl implements AlbumGenresDAO{
    @Override
    public AlbumGenres get(int id) throws SQLException {
        Connection connection = Database.getConnection();
        AlbumGenres albumGenres = null;
        String sql = "SELECT id, album_id,genre_id FROM album_genres WHERE id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            Integer oid = resultSet.getInt("id");
            Integer album_ID = resultSet.getInt("album_id");
            Integer genre_ID=resultSet.getInt("genre_id");

           albumGenres=new AlbumGenres(oid,album_ID,genre_ID);
        }
        Database.closeResultSet(resultSet);
        Database.closePreparedStatement(preparedStatement);
        Database.closeConnection(connection);

        return  albumGenres;
    }

    @Override
    public List<AlbumGenres> getAll() throws SQLException {
      Connection connection= Database.getConnection();
        List<AlbumGenres> albumGenresList = new ArrayList<>();
      String sql="UPDATE album_genres SET album_id = ?, genre_id = ? WHERE id = ?";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            int id =resultSet.getInt("id");
            int albumId =resultSet.getInt("album_id");
            int genreId =resultSet.getInt("genre_id");
            AlbumGenres albumGenre = new AlbumGenres(id, albumId, genreId);
            albumGenresList.add(albumGenre);
        }
     return  albumGenresList;
    }

    @Override
    public int save(AlbumGenres albumGenres) throws SQLException {
        return 0;
    }

    @Override
    public int insert(AlbumGenres albumGenres) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO album_genres (album_id, genre_id) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, albumGenres.getAlbum_id());
        ps.setInt(2, albumGenres.getGenre_id());
        int result =ps.executeUpdate();
        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);
        return result;
    }

    @Override
    public int update(AlbumGenres albumGenres) throws SQLException {
       Connection connection= Database.getConnection();
        String sql = "UPDATE album_genres SET album_id = ?, genre_id = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, albumGenres.getAlbum_id());
        ps.setInt(2, albumGenres.getGenre_id());
        ps.setInt(3,albumGenres.getId());
        int result =ps.executeUpdate();
        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);
        return result;
    }

    @Override
    public int delete(AlbumGenres albumGenres) throws SQLException {
        Connection connection= Database.getConnection();
        String sql = "DELETE FROM album_genres WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, albumGenres.getId());
        int result=ps.executeUpdate();
        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);
        return result;
    }
}
