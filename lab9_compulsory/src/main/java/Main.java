
import entity.Albums;
import entity.AlbumsGenres;
import entity.Artists;
import entity.Genres;
import repository.GenresRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // create an EntityManagerFactory
        GenresRepository genreRepository = new GenresRepository();

        // Find a genre by ID
        Genres rock = genreRepository.findById(1);

        // Save a new genre
        Genres jazz = new Genres("Jazz");
        genreRepository.save(jazz);

        // Update a genre
        rock.setName("Rock and Roll");
        genreRepository.update(rock);

        // Delete a genre
        genreRepository.delete(jazz);

    }
}