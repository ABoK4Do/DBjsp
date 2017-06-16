package classes;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by ABoK4Do on 15.06.17.
 */
public class FoodService extends GenericDAO<FoodsEntity> {

    private HibernateUtil hibernateUtil = getHibernateUtil();


    public List<FoodsEntity> findByName(String name) {
        List<FoodsEntity> entities = null;
        hibernateUtil.openCurrentSession();
        Criteria criteria = hibernateUtil.getCurrentSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.like("name", name, MatchMode.START));
        entities = criteria.list();
        hibernateUtil.closeCurrentSession();
        return entities;
    }

    public List<FoodsEntity> findByCategoryName(String name){
        List<FoodsEntity> entities = null;
        CategoryEntity categoryEntity = new CategoryService().findByName(name);
        if(categoryEntity!=null){
            entities = categoryEntity.getFoods();
        }
        return entities;
    }
}
