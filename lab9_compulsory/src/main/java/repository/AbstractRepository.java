package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractRepository<T extends Serializable> {

    private final SessionFactory sessionFactory;
    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(T entity) {
        Transaction transaction = getSession().beginTransaction();
        getSession().save(entity);
        transaction.commit();
    }

    public void update(T entity) {
        Transaction transaction = getSession().beginTransaction();
        getSession().update(entity);
        transaction.commit();
    }

    public void delete(T entity) {
        Transaction transaction = getSession().beginTransaction();
        getSession().delete(entity);
        transaction.commit();
    }

    public T findById(Integer id) {
        return getSession().get(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return getSession().createQuery("from " + entityClass.getName()).list();
    }
}
