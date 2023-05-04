import entity.Albums;
import entity.AlbumsGenres;
import entity.Artists;
import entity.Genres;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab9_compulsory2");
        EntityManager em = emf.createEntityManager();
        AlbumsGenres ag=new AlbumsGenres();
        AlbumsGenres ag1=new AlbumsGenres();
        // create and persist some entities
        Artists artist1 = new Artists();
        artist1.setName("Pink Floyd");

        Artists artist2 = new Artists();
        artist2.setName("Led Zeppelin");

        Genres genre1 = new Genres();
        genre1.setName("Rock");

        Genres genre2 = new Genres();
        genre2.setName("Prog Rock");

        Albums album1 = new Albums();
        album1.setArtist(artist1);
        album1.setTitle("The Dark Side of the Moon");
        album1.setReleaseYear(1973);
        album1.addGenre(genre2);

        Albums album2 = new Albums();
        album2.setArtist(artist1);
        album2.setTitle("Wish You Were Here");
        album2.setReleaseYear(1975);
        album2.addGenre(genre2);

        Albums album3 = new Albums();
        album3.setArtist(artist2);
        album3.setTitle("Led Zeppelin IV");
        album3.setReleaseYear(1971);
        album3.addGenre(genre1);

        em.getTransaction().begin();
        em.persist(artist1);
        em.persist(artist2);
        em.persist(genre1);
        em.persist(genre2);
        em.persist(album1);
        em.persist(album2);
        em.persist(album3);
        em.persist(ag);
        em.persist(ag1);
        em.getTransaction().commit();

        // use named queries to retrieve data
        List<Albums> albums = em.createNamedQuery("Album.findAll", Albums.class).getResultList();
        System.out.println("All albums:");
        for (Albums a : albums) {
            System.out.println(a.getTitle() + " by " + a.getArtist().getName());
        }

        List<Albums> albumsByArtist = em.createNamedQuery("Album.findByArtist", Albums.class)
                .setParameter(1, artist1).getResultList();
        System.out.println("Albums by " + artist1.getName() + ":");
        for (Albums a : albumsByArtist) {
            System.out.println(a.getTitle());
        }

        Albums album = em.createNamedQuery("Albums.findByTitle", Albums.class)
                .setParameter("title", "Led Zeppelin IV").getSingleResult();
        System.out.println("Album found by title: " + album.getTitle());

        em.close();
        emf.close();
    }
}
