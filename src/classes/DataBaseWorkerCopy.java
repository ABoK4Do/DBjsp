package classes;


import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ABoK4Do on 18.05.17.
 */
public class DataBaseWorkerCopy {

    //Логирование
    private static final Logger log = Logger.getLogger(DataBaseWorker.class);



    private static ArrayList<ResultPOJO> fromRStoAL (ResultSet results) throws SQLException {
        ArrayList<ResultPOJO> listTable = new ArrayList();
        //Доваляю строку таблицы
        while(results.next()){
            ResultPOJO row = new ResultPOJO();
            row.setId(results.getInt(1));
            row.setName(results.getString(2));
            row.setCat_id(results.getInt(3));
            row.setPrice(results.getFloat(4));
            row.setCat_name(results.getString(5));
            listTable.add(row);
        }
        return listTable;
    }


    //Метод для вывода таблицы. На выходе лист, состоящий из строк таблицы
    public static List<FoodsEntity> showDB() throws SQLException{
        List<FoodsEntity> listTable = Factory.getInstance().getFoodDAO().findAll();
        log.info("DB showed");
        return listTable;
    }


    //Добавить одну сущность в таблицу. Метод принимает 2 переменные: имя блюда и цену, либо 3 переменные: имя, название категории и цену
    public static  void addOne(Object...args){
        //Проверяю, есть ли подключение к БД
        String name = args[0].toString();
        int cat_id = 0;
        FoodsEntity food = new FoodsEntity();
        try {

            //Добавляю новую строку если метод принял 3 переменных
            if(args.length==3){
                //Узнаю id категории по заданному имени категории
                CategoryEntity cat = Factory.getInstance().getCategoryDAO().findByName(args[1].toString());

                if(cat!=null){
                    cat_id = cat.getId();}

            }

            food.setName(name);
            food.setPrice(Integer.parseInt(args[2].toString()));
            food.setCategoryId(cat_id);
            //Добавляю
            Factory.getInstance().getFoodDAO().insert(food);




        } catch (SQLException e) {
            log.error("Error while adding");
            e.printStackTrace();
        }
        log.info("add one elem");
    }

    //Обновить сущность таблицы 1
    public static void updateOne(String id, String name, String catName, String price){
        int cat_id = 0;
        FoodsEntity food = new FoodsEntity();
        try {


            CategoryEntity cat = Factory.getInstance().getCategoryDAO().findByName(catName);
            if(cat!=null){
                cat_id = cat.getId();}
            food.setId(Integer.parseInt(id));
            food.setName(name);
            food.setPrice(Integer.parseInt(price));
            food.setCategoryId(cat_id);
            Factory.getInstance().getFoodDAO().update(food);


        } catch (SQLException e) {
            log.error("Error while updating");
            e.printStackTrace();
        }
        log.info("Updated");

    }


    //Удалить сущность по id блюда
    public static void delSome(String ids){

      /*  try {

        } catch (SQLException e) {
            log.error("Error while deleting");
            e.printStackTrace();
        }
        log.info("Deleted elements "+ids);*/

    }


    //Найти по имени блюда
    public static ArrayList<ResultPOJO> searchByName(String name){
        //Проверяю подключение к базе данных
        ArrayList<ResultPOJO> listTable = null;
       /* ResultSet results=null;
        try {
            //Удаляю строку
            stmt = conn.createStatement();
            results = stmt.executeQuery(searchByNameStatement+"'"+name+"%"+"'");
            listTable = fromRStoAL(results);
            stmt.close();
        } catch (SQLException e) {
            log.error("Error while finding by name");
            e.printStackTrace();
        }
        log.info("found");*/
        return listTable;

    }
    //Найти по имени категории
    public static ArrayList<ResultPOJO> searchByCat(String name){

        ArrayList<ResultPOJO> listTable = null;
        /*
        ResultSet results=null;
        try {
            //Удаляю строку
            stmt = conn.createStatement();
            results = stmt.executeQuery(searchByCatStatement+"'"+name+"%"+"'");
            listTable = fromRStoAL(results);
            stmt.close();
        } catch (SQLException e) {
            log.error("Error while finding by category name");
            e.printStackTrace();
        }
        log.info("found");*/
        return listTable;

    }


    //Найти по id имени
    public static ArrayList<ResultPOJO> searchByIds(String str){

        ArrayList<ResultPOJO> listTable = null;
        /*
        ResultSet results=null;
        try {
            //Удаляю строку
            stmt = conn.createStatement();
            results = stmt.executeQuery(searchByIdsStatement+str);
            listTable = fromRStoAL(results);
            stmt.close();
        } catch (SQLException e) {
            log.error("Error while finding by ids");
            e.printStackTrace();
        }
        log.info("found some ids ="+str);*/
        return listTable;

    }



}
