package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAOImpl implements ArtistDAO{
    @Override
    public Artist get(int id) throws SQLException {
        Connection connection = Database.getConnection();
        Artist artists = null;
        String sql = "SELECT id, name FROM artists WHERE id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            Integer oid = resultSet.getInt("id");
            String Name = resultSet.getString("name");

           artists = new Artist(oid, Name);
        }
        Database.closeResultSet(resultSet);
        Database.closePreparedStatement(preparedStatement);
        Database.closeConnection(connection);

        return  artists;
    }

    @Override
    public List<Artist> getAll() throws SQLException {
        Connection connection = Database.getConnection();

        String sql = "SELECT id,name FROM artists;";

        List<Artist> artistsList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){

            Integer oid = resultSet.getInt("id");
            String Name = resultSet.getString("name");


            Artist artists = new Artist(oid,Name);
            artistsList.add(artists);
        }
        return artistsList;
    }

    @Override
    public int save(Artist artist) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Artist artists) throws SQLException {
        Connection con = Database.getConnection();

        String sql = "INSERT INTO artists (id,name) VALUES (?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, artists.getId());
        ps.setString(2, artists.getName());


        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(con);

        return result;
    }

    @Override
    public int update(Artist artists) throws SQLException {
        Connection connection = Database.getConnection();

        String sql = "UPDATE artists set name=? where id = ?";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, artists.getName());
        ps.setInt(1, artists.getId());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);

        return result;
    }

    @Override
    public int delete(Artist artists) throws SQLException {
        Connection connection = Database.getConnection();

        String sql = "DELETE FROM artists WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, artists.getId());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);

        return result;
    }
}
