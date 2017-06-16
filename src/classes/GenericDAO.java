package classes;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by ABoK4Do on 01.05.17.
 */
public abstract class GenericDAO<T> implements DAO<T> {

    //Логирование
   // private final Logger log = Logger.getLogger(getPersistentClass());
    private HibernateUtil hibernateUtil;
    private Class<T> persistentClass;

    GenericDAO() {
        if (hibernateUtil == null) {
            hibernateUtil = new HibernateUtil();
        }
        persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public HibernateUtil getHibernateUtil() {
        return hibernateUtil;
    }


    public void insert(T entity) {
        hibernateUtil.openCurrentSessionwithTransaction();
        hibernateUtil.getCurrentSession().save(entity);
        hibernateUtil.closeCurrentSessionwithTransaction();

    }

    public void insert(List<T> entities) {
        hibernateUtil.openCurrentSessionwithTransaction();
        for (T entity : entities) {
            hibernateUtil.getCurrentSession().save(entity);
        }
        hibernateUtil.closeCurrentSessionwithTransaction();
    }


    public void update(T entity) {
        hibernateUtil.openCurrentSessionwithTransaction();
        hibernateUtil.getCurrentSession().update(entity);
        hibernateUtil.closeCurrentSessionwithTransaction();
    }

    public void update(List<T> entities) {
        hibernateUtil.openCurrentSessionwithTransaction();
        for (T entity : entities) {
            hibernateUtil.getCurrentSession().update(entity);
        }
        hibernateUtil.closeCurrentSessionwithTransaction();
    }


    public void delete(T entity) {
        hibernateUtil.openCurrentSessionwithTransaction();
        hibernateUtil.getCurrentSession().delete(entity);
        hibernateUtil.closeCurrentSessionwithTransaction();

    }

    public void delete(List<T> entities) {
        hibernateUtil.openCurrentSessionwithTransaction();
        for (T entity : entities) {
            hibernateUtil.getCurrentSession().delete(entity);
        }
        hibernateUtil.closeCurrentSessionwithTransaction();
    }


    public T findById(int id) {
        hibernateUtil.openCurrentSession();
        T entity = (T) hibernateUtil.getCurrentSession().get(getPersistentClass(), id);
        hibernateUtil.closeCurrentSession();
        return entity;
    }

    public List<T> findAll() {
        hibernateUtil.openCurrentSession();
        List<T> entities = hibernateUtil.getCurrentSession().createCriteria(getPersistentClass()).list();
        hibernateUtil.closeCurrentSession();
        //log.info("Got all "+getPersistentClass().getName());
        return entities;

    }


}

