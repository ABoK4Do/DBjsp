package classes;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ABoK4Do on 14.05.17.
 */
public interface DAO<T> {

    void insert(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    void delete(T entity) throws SQLException;

    T findById(int id) throws SQLException;

    List<T> findAll() throws SQLException;

}
