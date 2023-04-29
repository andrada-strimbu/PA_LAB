package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAOImpl implements GenreDAO{
    @Override
    public Genre get(int id) throws SQLException {
        Connection connection = Database.getConnection();
        Genre genre= null;
        String sql = "SELECT id, name FROM genre WHERE id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            Integer oid = resultSet.getInt("id");
            String Name = resultSet.getString("name");

            genre = new Genre(oid, Name);
        }
        Database.closeResultSet(resultSet);
        Database.closePreparedStatement(preparedStatement);
        Database.closeConnection(connection);

        return  genre;
    }

    @Override
    public List<Genre> getAll() throws SQLException {
        Connection connection = Database.getConnection();

        String sql = "SELECT id,name FROM genre;";

        List<Genre> genreList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){

            Integer oid = resultSet.getInt("id");
            String Name = resultSet.getString("name");


            Genre genre = new Genre(oid, Name);
           genreList.add(genre);
        }
        return genreList;
    }

    @Override
    public int save(Genre genre) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Genre genre) throws SQLException {
        Connection con = Database.getConnection();

        String sql = "INSERT INTO genres (id,name) VALUES (?) ON CONFLICT (name) DO NOTHING";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, genre.getId());
        ps.setString(2, genre.getName());


        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(con);

        return result;
    }

    @Override
    public int update(Genre genre) throws SQLException {
        Connection connection = Database.getConnection();

        String sql = "UPDATE genres set name=? where id = ?";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, genre.getName());
        ps.setInt(1, genre.getId());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);

        return result;
    }

    @Override
    public int delete(Genre genre) throws SQLException {
        Connection connection = Database.getConnection();

        String sql = "DELETE FROM genres WHERE id = ?";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, genre.getId());

        int result = ps.executeUpdate();

        Database.closePreparedStatement(ps);
        Database.closeConnection(connection);

        return result;
    }
}
