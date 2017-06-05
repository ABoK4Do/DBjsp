package classes;

import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ABoK4Do on 07.12.16.
 */
public class DataBaseWorker {

    //Логирование
    private static final Logger log = Logger.getLogger(DataBaseWorker.class);


    //Вывести базу в виде List<FoodsEntity>
    public static List<FoodsEntity> showDB() {
        List<FoodsEntity> listTable = null;
        try {
            listTable = Factory.getInstance().getFoodDAO().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("--->DB showed");

        return listTable;
    }


    //Добавить одну сущность в таблицу, получает FoodsEntity
    public static void addOne(FoodsEntity food) {
        int catId = 0;

        try {
            List<CategoryEntity> cats = Factory.getInstance().getCategoryDAO().findByName(food.getCategory().getName());
            if (cats.size() > 0) {
                catId = cats.get(0).getId();
            }
            food.setCategoryId(catId);
            Factory.getInstance().getFoodDAO().insert(food);
            food.setCategory(Factory.getInstance().getCategoryDAO().findById(catId));
        } catch (SQLException e) {
            log.error("--->Error while adding");
            e.printStackTrace();
        }
        log.info("--->Added one element id=" + food.getId());
    }


    //Добавить несколько сущностей в таблицу, получает List<FoodsEntity>, вывод тотже List<FoodsEntity> (обновленный)
    public static void addSome(List<FoodsEntity> foods) {
        for (FoodsEntity food : foods) {
            DataBaseWorker.addOne(food);
        }
        log.info("--->Added some elements");
    }

    //Обновить сущность
    public static void updateOne(FoodsEntity food) {
        int catId = 0;
        try {
            List<CategoryEntity> cats = Factory.getInstance().getCategoryDAO().findByName(food.getCategory().getName());

            if (cats.size() > 0) {
                catId = cats.get(0).getId();
            }
            food.setCategoryId(catId);
            Factory.getInstance().getFoodDAO().update(food);
            food.setCategory(Factory.getInstance().getCategoryDAO().findById(catId));


        } catch (SQLException e) {
            log.error("--->Error while updating");
            e.printStackTrace();
        }
        log.info("--->Updated one id=" + food.getId());
    }


    //Обновить сущности
    public static void updateSome(List<FoodsEntity> foods) {
        for (FoodsEntity food : foods) {
            DataBaseWorker.updateOne(food);
        }
        log.info("--->Updated some elements");
    }

    //Удалить сущность по id блюда
    public static void delOne(FoodsEntity food) {
        try {
            Factory.getInstance().getFoodDAO().delete(food);
        } catch (SQLException e) {
            log.error("--->Error while deleting");
            e.printStackTrace();
        }
        log.info("--->Deleted element");
    }


    //Удалить сущности по id
    public static void delSome(List<FoodsEntity> foods) {
        for (FoodsEntity food : foods) {
            DataBaseWorker.delOne(food);
        }
        log.info("--->Deleted some elements");
    }


    //Найти по имени блюда
    public static List<FoodsEntity> searchByName(String name) {

        List<FoodsEntity> listTable = null;

        try {
            listTable = Factory.getInstance().getFoodDAO().findByName(name);
        } catch (SQLException e) {
            log.error("--->Error while finding by name");
            e.printStackTrace();
        }
        log.info("--->Found");
        return listTable;

    }

    //Найти по имени категории
    public static List<FoodsEntity> searchByCat(String name) {

        List<FoodsEntity> listTable = null;

        try {
            listTable = Factory.getInstance().getCategoryDAO().findByName(name).get(0).getFoods();
        } catch (SQLException e) {
            log.error("--->Error while finding by name");
            e.printStackTrace();
        }
        log.info("--->Found");
        return listTable;

    }


}

