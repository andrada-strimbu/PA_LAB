package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAOImpl implements PlaylistDAO {
    @Override
    public Playlist get(int id) throws SQLException {
        Connection connection = Database.getConnection();
        Playlist playlists = null;
        String sql = "SELECT id, name,creationTime,albums FROM playlists WHERE id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            Integer oid = resultSet.getInt("id");
            String playlists_name = resultSet.getString("name");
            Integer playlists_creationTime=resultSet.getInt("creationTime");
            String playlists_album= resultSet.getString("albums");

            playlists=new Playlist(oid,playlists_name,playlists_creationTime,playlists_album);
        }
        Database.closeResultSet(resultSet);
        Database.closePreparedStatement(preparedStatement);
        Database.closeConnection(connection);
        return playlists;
    }

    @Override
    public List<Playlist> getAll() throws SQLException {
        Connection connection= Database.getConnection();
        List<Playlist> playlistsList = new ArrayList<>();
        String sql="UPDATE playlists SET name= ?, cretionTime = ?, albums=? WHERE id = ?";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            Integer oid = resultSet.getInt("id");
            String playlists_name = resultSet.getString("name");
            Integer playlists_creationTime=resultSet.getInt("creationTime");
            String playlists_album= resultSet.getString("albums");
            Playlist playlist = new Playlist(oid,playlists_name,playlists_creationTime,playlists_album);
            playlistsList.add(playlist);
        }
        return  playlistsList;
    }

    @Override
    public int save(Playlist playlist) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Playlist playlist) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO album_genres (name,cretionTime,albums) VALUES (?, ?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, playlist.getName());
        ps.setInt(2, playlist.getCreationTime());
        ps.setString(3,playlist.getAlbums());
        int result =ps.executeUpdate();
        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);
        return result;
    }

    @Override
    public int update(Playlist playlist) throws SQLException {
        Connection connection= Database.getConnection();
        String sql = "UPDATE playlists SET name= ?, cretionTime = ?, albums=? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, playlist.getName());
        ps.setInt(2, playlist.getCreationTime());
        ps.setString(3,playlist.getAlbums());
        ps.setInt(4,playlist.getId());
        int result =ps.executeUpdate();
        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);
        return result;
    }

    @Override
    public int delete(Playlist playlist) throws SQLException {
        Connection connection= Database.getConnection();
        String sql = "DELETE FROM playlists WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, playlist.getId());
        int result=ps.executeUpdate();
        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);
        return result;
    }
}
