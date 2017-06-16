package classes;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created by ABoK4Do on 15.06.17.
 */
public class CategoryService extends GenericDAO<CategoryEntity> {

    private HibernateUtil hibernateUtil = getHibernateUtil();


    public CategoryEntity findByName(String name) {

        hibernateUtil.openCurrentSession();
        Criteria criteria = hibernateUtil.getCurrentSession().createCriteria(CategoryEntity.class);
        criteria.add(Restrictions.eq("name", name));
        CategoryEntity entity = (CategoryEntity) criteria.uniqueResult();
        hibernateUtil.closeCurrentSession();
        return entity;
    }
}
