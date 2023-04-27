package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        /*Album album1 = new Album(4, 2002, "ANDRADA", "John", "rock");
        System.out.println(album1);
        Connection conn = Database.getConnection();
        if(conn!= null){
            System.out.println("Database connection successful");
        }
        List<Album> albumsList;
        AlbumDAO albumsDAO = new AlbumDAOImpl();
        int result = albumsDAO.insert(album1);

        System.out.println(result);

        albumsList = albumsDAO.getAll();
        for (Album album: albumsList) {
            System.out.println(album);
        }
        AlbumDAO employeeDAO = new AlbumDAOImpl();

       Album update_album = new Album(1, 336861, "Sam", "Club", "DRAMA");

        employeeDAO.update(update_album);

        System.out.println(update_album);*/

     AlbumDAO deleteDAO = new AlbumDAOImpl();

       Album delete = deleteDAO.get(4);

        System.out.println(delete);

        int result = deleteDAO.delete(delete);

        System.out.println(result);



    }
}