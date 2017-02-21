package classes;

import java.sql.*;
import java.util.ArrayList;


/**
 * Created by ABoK4Do on 07.12.16.
 */
public class DataBaseWorker {
    private static String dbURL = "jdbc:derby:Restaurant;create=false";
    private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String queryShowDB = "Select t1.Name as name, t2.NAME as Cat_name, t1.PRICE price " +
                                              "From APP.FOODS t1 LEFT JOIN APP.CATEGORY t2 " +
                                              "ON t1.CATEGORY_ID = t2.ID";
    private static final String queryShowAll = "Select t1.*, t2.*" +
                                                "From APP.FOODS t1 LEFT JOIN APP.CATEGORY t2 " +
                                                 "ON t1.CATEGORY_ID = t2.ID";

    private static Connection conn = null;
    private static Statement stmt = null;


    private static void createConnection()
    {

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(dbURL);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addOne(Object...args){
        if(conn == null) { createConnection();}
        String name = args[0].toString();
        try {
            stmt = conn.createStatement();
            //Нахожу максимальный айди и потом к нему +1
            ResultSet results = stmt.executeQuery("SELECT MAX(ID) From APP.FOODS");
            results.next();
            int newID = results.getInt(1)+1;
            //Добавляю новую строку
            if(args.length==3){
                results = stmt.executeQuery("SELECT ID From APP.CATEGORY WHERE NAME='"+args[1].toString()+"'");
                int cat_id;
                if(results.next()){
                cat_id = results.getInt(1);}
                else cat_id = 0;

                stmt.executeUpdate("INSERT INTO APP.FOODS(ID, NAME, CATEGORY_ID, PRICE) VALUES("+newID+",'"+name+"',"+cat_id+","+Integer.parseInt(args[2].toString())+")");}
            if(args.length==2){
                stmt.executeUpdate("INSERT INTO APP.FOODS(ID, NAME, PRICE) VALUES("+newID+",'"+name+"',"+Integer.parseInt(args[1].toString())+")");
                }
            stmt.close();



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<ResultPOJO> showDB(){

        ArrayList<ResultPOJO> listTable = new ArrayList();
        listTable.clear();
        ResultSet results=null;
        try {
            if(conn == null) { createConnection();}
            stmt = conn.createStatement();
            results = stmt.executeQuery(queryShowAll);



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


        return listTable;
    }
    public static void delOne(String name){
        //Проверяю подключение к базе данных
        if(conn == null) { createConnection();}
        try {
            //Удалю строку
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM APP.FOODS WHERE NAME='"+name+"'");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

