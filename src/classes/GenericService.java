package classes;

/**
 * Created by ABoK4Do on 15.06.17.
 */
public class GenericService<T> {
    /*private GenericDAO<T> genericDAO;


    public GenericService()  {

        genericDAO = new GenericDAO<T>();

    }

    public void insert(T entity) {

        genericDAO.getHibernateUtil().openCurrentSessionwithTransaction();
        try {
            genericDAO.insert(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        genericDAO.getHibernateUtil().closeCurrentSessionwithTransaction();

    }

    public void update(T entity) {
        genericDAO.getHibernateUtil().openCurrentSessionwithTransaction();
        try {
            genericDAO.update(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        genericDAO.getHibernateUtil().closeCurrentSessionwithTransaction();
    }

    public T findById(int id) {
        genericDAO.getHibernateUtil().openCurrentSession();
        T entity = null;
        try {
            entity = genericDAO.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        genericDAO.getHibernateUtil().closeCurrentSession();
        return entity;
    }

    public void delete(int id) {
        genericDAO.getHibernateUtil().openCurrentSessionwithTransaction();
        T entity = null;
        try {
            entity = genericDAO.findById(id);
            genericDAO.delete(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        genericDAO.getHibernateUtil().closeCurrentSessionwithTransaction();
    }

    public List<T> findAll() {

        genericDAO.getHibernateUtil().openCurrentSession();

        List<T> entities = null;
        try {
            entities = genericDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        genericDAO.getHibernateUtil().closeCurrentSession();

        return entities;

    }
*/
}
