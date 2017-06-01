package classes;

/**
 * Created by ABoK4Do on 11.05.17.
 */

import java.sql.SQLException;
import java.util.List;

public class HibTest {

    public static void main(String[] args) throws SQLException {
        String name = "TestServlet";
        String catName = "pizza";
        int price = 99;
        int catId = 0;
        FoodsEntity food = new FoodsEntity();
        food.setName(name);
        List<CategoryEntity> cats = Factory.getInstance().getCategoryDAO().findByName(catName);
        if (cats.size() > 0) {
            catId = cats.get(0).getId();
        }
        food.setPrice(price);
        food.setCategoryId(catId);
        Factory.getInstance().getFoodDAO().insert(food);
        food.setCategory(Factory.getInstance().getCategoryDAO().findById(catId));

        System.out.println(food.getId() + " " + food.getCategory().getName());

        List<FoodsEntity> list1 = Factory.getInstance().getFoodDAO().findAll();

        System.out.println("========Все foods=========");
        System.out.println("NAME | ID | Price | catID | catName");
        for (FoodsEntity i : list1) {
            System.out.println(i.getName() + " | " + i.getId() + " | " + i.getPrice() + " | " + i.getCategoryId() + " | " + i.getCategory().getName());
        }

    }
}