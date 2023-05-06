package repository;
import entity.Albums;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AlbumsRepository implements AbstractRepository<Albums> {
    private EntityManager entityManager;
    private EntityManagerFactory managerFactory;
    public AlbumsRepository(){
        this.managerFactory = Persistence.createEntityManagerFactory("lab9_compulsory2");
        this.entityManager = managerFactory.createEntityManager();
    }
    public Albums createAlbum(Albums album){
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        return album;
    }
    public Albums findById(Integer id){

        return entityManager.find(Albums.class, id);
    }

    @Override
    public List<Albums> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Albums> cq = cb.createQuery(Albums.class);
        Root<Albums> rootEntry = cq.from(Albums.class);
        CriteriaQuery<Albums> all = cq.select(rootEntry);
        return entityManager.createQuery(all).getResultList();
    }

    @Override
    public void save(Albums albums) {
        entityManager.getTransaction().begin();
        entityManager.persist(albums);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Albums albums) {
        entityManager.getTransaction().begin();
        entityManager.merge(albums);
        entityManager.getTransaction().commit();
    }

    public Albums findByTitle(String title){
        Query query = entityManager.createNamedQuery("Albums.findByTitle");
        query.setParameter("title", title);
        return (Albums) query.getSingleResult();
    }
    public void delete(Albums album){
        entityManager.getTransaction().begin();
        entityManager.remove(album);
        entityManager.getTransaction().commit();
    }
    public void close(){
        this.entityManager.close();
        this.managerFactory.close();
    }
}