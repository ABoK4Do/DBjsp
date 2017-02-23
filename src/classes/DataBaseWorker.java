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
    private static final String queryShowAll = "Select t1.*, t2.*" +
                                                "From APP.FOODS t1 LEFT JOIN APP.CATEGORY t2 " +
                                                 "ON t1.CATEGORY_ID = t2.ID";

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
            e.printStackTrace();
        }
        log.info("add one elem");
    }

    //Метод для вывода таблицы. На выходе лист, состоящий из строк таблицы
    public static ArrayList<ResultPOJO> showDB(){

        ArrayList<ResultPOJO> listTable = new ArrayList();

        ResultSet results=null;
        try {
            if(conn == null) { createConnection();}
            stmt = conn.createStatement();
            //Делаю SQL запрос на вывод таблицы
            results = stmt.executeQuery(queryShowAll);


             //Доваляю строку таблицы
            while(results.next()){
                ResultPOJO row = new ResultPOJO();
                row.setId(results.getInt(1));
                row.setName(results.getString(2));
                row.setCat_id1(results.getInt(3));
                row.setPrice(results.getFloat(4));
                row.setCat_id2(results.getInt(5));
                row.setCat_name(results.getString(6));
                listTable.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("DB showed");
        return listTable;
    }

    //Удалить сущность по имени блюда
    public static void delOne(String name){
        //Проверяю подключение к базе данных
        if(conn == null) { createConnection();}
        try {
            //Удаляю строку
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM APP.FOODS WHERE NAME='"+name+"'");
            stmt.close();
        } catch (SQLException e) {
            log.error("Error while deleting");
            e.printStackTrace();
        }
        log.info("Deleted");

    }
}

