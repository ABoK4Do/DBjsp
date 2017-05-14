package classes;

/**
 * Created by ABoK4Do on 11.05.17.
 */

import java.sql.SQLException;
import java.util.List;

public class HibTest {

    public static void main(String[] args) throws SQLException{
        FoodsEntity foodTest1 = new FoodsEntity("Tester1",50);
        Factory.getInstance().getFoodDAO().insert(foodTest1);

        List<FoodsEntity> list1 = Factory.getInstance().getFoodDAO().findAll();

        System.out.println("========Все foods=========");
        for (FoodsEntity i: list1) {
            System.out.println(i.getName()+" | "+i.getId());
        }
     FoodsEntity food1 = Factory.getInstance().getFoodDAO().find(2);

        System.out.println(food1.getName());
    }
}