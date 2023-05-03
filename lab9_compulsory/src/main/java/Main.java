import entity.Albums;
import repository.AlbumsRepository;

import javax.persistence.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Albums album = new Albums();
        album.setId(501);
        album.setArtist("Rihanna");
        album.setReleaseYear(2016);
        album.setTitle("Anti");
        album.setGenre("pop");

        AlbumsRepository albumsRepository = new AlbumsRepository();
        albumsRepository.createAlbum(album);
        System.out.println("Added album: " + album.toString());

        album = albumsRepository.findById(1);
        System.out.println("Found album by id:"+ album.toString());

        album = albumsRepository.findByTitle("Acele");
        System.out.println("Found album by title:"+ album.toString());

        albumsRepository.close();

    }
}