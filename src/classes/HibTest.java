package classes;

/**
 * Created by ABoK4Do on 11.05.17.
 */

import java.sql.SQLException;
import java.util.List;

public class HibTest {

    public static void main(String[] args) throws SQLException{
       /* for(int i = 0; i<150; i++){
            FoodsEntity foodTest1 = new FoodsEntity("Tester1", 50);
            Factory.getInstance().getFoodDAO().insert(foodTest1);
        }*/

        //FoodsEntity foodTest2 = new FoodsEntity("NoTest", 500);
        //foodTest2.setId(2701);
        //foodTest2.setCategoryId(0);
        //Factory.getInstance().getFoodDAO().update(foodTest2);


        List<FoodsEntity> list1 = Factory.getInstance().getFoodDAO().findAll();

        System.out.println("========Все foods=========");
        System.out.println("NAME | ID | Price | catID");
        for (FoodsEntity i: list1) {
            System.out.println(i.getName()+" | "+i.getId()+" | "+ i.getPrice()+" | "+ i.getCategoryId()+" | "+i.getCategory().getName());
        }

        FoodsEntity food3 = Factory.getInstance().getFoodDAO().findByName("BBQ");
        System.out.println(food3.getId()+" and "+food3.getName()+" and "+food3.getCategory().getName());

        CategoryEntity cat1 = Factory.getInstance().getCategoryDAO().findByName("LOLLL");
        if(cat1!=null){
        System.out.println(cat1.getId());}
       // System.out.println(cat1.getFoods());
       // List<FoodsEntity> listCat1 = cat1.getFoods();
       // for (FoodsEntity i: listCat1){
       //    System.out.println(i.getName()+" | "+i.getId()+" | "+ i.getPrice()+" | "+ i.getCategoryId()+" | ");
       // }
     //FoodsEntity food1 = Factory.getInstance().getFoodDAO().find(2);

       // System.out.println(food1.getName());
    }
}