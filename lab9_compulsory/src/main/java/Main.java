import entity.Albums;
import entity.AlbumsGenres;
import entity.Artists;
import entity.Genres;
import repository.AlbumsRepository;


import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // create an EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab9_compulsory2");

        // create an EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // create an instance of the Artists entity and set its properties
        Artists artist1 = new Artists();
        artist1.setName("The Beatles");

        Artists artist2 = new Artists();
        artist2.setName("Queen");

        // create an instance of the Genres entity and set its properties
        Genres genre1 = new Genres();
        genre1.setName("Rock");

        Genres genre2 = new Genres();
        genre2.setName("Pop");

        // create an instance of the Albums entity and set its properties
        Albums album1 = new Albums();
        album1.setReleaseYear(1967);
        album1.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        album1.setArtist(artist1);
        album1.addGenre(genre1);

        Albums album2 = new Albums();
        album2.setReleaseYear(1975);
        album2.setTitle("A Night at the Opera");
        album2.setArtist(artist2);
        album2.addGenre(genre1);
        album2.addGenre(genre2);

        // persist the entities to the database
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(artist1);
        entityManager.persist(artist2);
        entityManager.persist(genre1);
        entityManager.persist(genre2);
        entityManager.persist(album1);
        entityManager.persist(album2);
        transaction.commit();

        // retrieve the persisted entities from the database
        List<Albums> albums = entityManager.createQuery("SELECT a FROM Albums a", Albums.class).getResultList();
        List<Genres> genres = entityManager.createQuery("SELECT g FROM Genres g", Genres.class).getResultList();

        // print the retrieved entities
        System.out.println("Albums:");
        for (Albums album : albums) {
            System.out.println(album.getTitle() + " by " + album.getArtist().getName());
            System.out.println("Genres:");
            for (Genres genre : album.getGenresSet()) {
                System.out.println(genre.getName());
            }
            System.out.println();
        }

        System.out.println("Genres:");
        for (Genres genre : genres) {
            System.out.println(genre.getName());
        }

        // close the EntityManager
        entityManager.close();

        // close the EntityManagerFactory
        entityManagerFactory.close();
    }

}
