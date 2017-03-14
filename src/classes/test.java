package classes;

import java.util.ArrayList;

import static classes.DataBaseWorker.*;


/**
 * Created by ABoK4Do on 14.03.17.
 */
public class test {
    public static void main(String[] args) {
        System.out.println("Test1:");
        ArrayList<ResultPOJO> list = searchByName("Piz");
        for (ResultPOJO s : list){
            System.out.println(s.getId());
            System.out.println(s.getName());
            System.out.println(s.getCat_name());
            System.out.println(s.getPrice());
        }
    }
}
