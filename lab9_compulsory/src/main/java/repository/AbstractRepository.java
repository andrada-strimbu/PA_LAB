package repository;
import java.util.List;

public interface AbstractRepository<T> {

    T findById(Integer id);

    List<T> findAll();

    void save(T t);

    void update(T t);

    void delete(T t);

}