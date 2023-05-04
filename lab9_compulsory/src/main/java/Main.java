import entity.Albums;
import repository.AlbumsRepository;


import javax.persistence.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Albums album = new Albums();
        album.setId(1);
        album.setArtist("Rihanna");
        album.setReleaseYear(2016);
        album.setTitle("Anti");
        album.setGenres("pop");

        AlbumsRepository albumsRepository = new AlbumsRepository();
        albumsRepository.createAlbum(album);
        System.out.println("Added album: " + album.toString());

        album = albumsRepository.findById(1);
        System.out.println("Found album by id:"+ album.toString());

        album = albumsRepository.findByTitle("Anti");
        System.out.println("Found album by title:"+ album.toString());

        albumsRepository.close();

        /* EntityManagerFactory entityManagerFactory = EntityManagerFactoryManager.getInstance().getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
          *//*  AlbumsEntity album = new AlbumsEntity();
            album.setId(2);
            album.setArtist("Matei");
            album.setReleaseYear(2002);
            album.setTitle("Mi-am inselat iubita");
            album.setGenres("classic");
            entityManager.persist(album);

            TypedQuery<AlbumsEntity> albumsEntityTypedQuery = entityManager.createNamedQuery("Albums.findByTitle",AlbumsEntity.class);
            albumsEntityTypedQuery.setParameter(1,"Java");
            for (AlbumsEntity album:albumsEntityTypedQuery.getResultList()) {
                System.out.println(album);
            }

            transaction.commit();
        }finally {
            if(transaction.isActive()){
                transaction.rollback();;
            }
            EntityManagerFactoryManager.getInstance().closeEntityManagerFactory();
        }*/

    }
}