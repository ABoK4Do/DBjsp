package classes;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;


/**
 * Created by ABoK4Do on 07.12.16.
 */
public class DataBaseWorker {
    private static String dbURL = "jdbc:derby:Restaurant;create=false";
    private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String showAllStatement = "Select t1.id id, t1.name name, t1.CATEGORY_ID cat_id, t1.price price, t2.name cat_name " +
                                                "From APP.FOODS t1 LEFT JOIN APP.CATEGORY t2 " +
                                                 "ON t1.CATEGORY_ID = t2.ID";
    private static final String searchByNameStatement = "Select t1.id id, t1.name name, t1.CATEGORY_ID cat_id, t1.price price, t2.name cat_name " +
            "From APP.FOODS t1 LEFT JOIN APP.CATEGORY t2 " +
            "ON t1.CATEGORY_ID = t2.ID " +
            "Where t1.name LIKE ";
    private static final String searchByCatStatement = "Select t1.id id, t1.name name, t1.CATEGORY_ID cat_id, t1.price price, t2.name cat_name " +
            "From APP.FOODS t1 LEFT JOIN APP.CATEGORY t2 " +
            "ON t1.CATEGORY_ID = t2.ID " +
            "Where t2.name LIKE ";

    private static Connection conn = null;
    private static Statement stmt = null;

    //Логирование
    private static final Logger log = Logger.getLogger(DataBaseWorker.class);

    //Подключение к базе
    private static void createConnection()
    {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(dbURL);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void closeConnection() throws SQLException {
        if(conn != null) {
            conn.close();
        }
    }

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
    public static ArrayList<ResultPOJO> showDB(){

        ArrayList<ResultPOJO> listTable = new ArrayList();

        ResultSet results=null;
        try {
            if(conn == null) { createConnection();}
            stmt = conn.createStatement();
            //Делаю SQL запрос на вывод таблицы
            results = stmt.executeQuery(showAllStatement);

            listTable = fromRStoAL(results);


        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("DB showed");
        return listTable;
    }


    //Добавить одну сущность в таблицу. Метод принимает 2 переменные: имя блюда и цену, либо 3 переменные: имя, название категории и цену
    public static synchronized void addOne(Object...args){
        //Проверяю, есть ли подключение к БД
        if(conn == null) { createConnection();}
        String name = args[0].toString();
        try {
            stmt = conn.createStatement();
            //Нахожу максимальный айди и потом к нему +1
            ResultSet results = stmt.executeQuery("SELECT MAX(ID) From APP.FOODS");
            results.next();
            int newID = results.getInt(1)+1;
            //Добавляю новую строку если метод принял 3 переменных
            if(args.length==3){
                //Узнаю id категории по заданному имени категории
                results = stmt.executeQuery("SELECT ID From APP.CATEGORY WHERE NAME='"+args[1].toString()+"'");
                int cat_id;
                if(results.next()){
                cat_id = results.getInt(1);}
                else cat_id = 0;
                //Добавляю
                stmt.executeUpdate("INSERT INTO APP.FOODS(ID, NAME, CATEGORY_ID, PRICE) VALUES("+newID+",'"+name+"',"+cat_id+","+Integer.parseInt(args[2].toString())+")");
            }
            //Добавляю новую строку если метод принял 2 переменных
            if(args.length==2){
                stmt.executeUpdate("INSERT INTO APP.FOODS(ID, NAME, PRICE) VALUES("+newID+",'"+name+"',"+Integer.parseInt(args[1].toString())+")");
                }
            stmt.close();



        } catch (SQLException e) {
            log.error("Error while adding");
            e.printStackTrace();
        }
        log.info("add one elem");
    }


    //Удалить сущность по id блюда
    public static void delOne(int id){
        //Проверяю подключение к базе данных
        if(conn == null) { createConnection();}
        try {
            //Удаляю строку
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM APP.FOODS WHERE ID='"+id+"'");
            stmt.close();
        } catch (SQLException e) {
            log.error("Error while deleting");
            e.printStackTrace();
        }
        log.info("Deleted");

    }


    //Найти по имени блюда
    public static ArrayList<ResultPOJO> searchByName(String name){
        //Проверяю подключение к базе данных
        if(conn == null) { createConnection();}
        ArrayList<ResultPOJO> listTable = null;
        ResultSet results=null;
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
        log.info("found");
        return listTable;

    }
    //Найти по имени категории
    public static ArrayList<ResultPOJO> searchByCat(String name){
        //Проверяю подключение к базе данных
        if(conn == null) { createConnection();}
        ArrayList<ResultPOJO> listTable = null;
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
        log.info("found");
        return listTable;

    }
}

