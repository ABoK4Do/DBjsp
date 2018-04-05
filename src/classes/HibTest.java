package classes;

/**
 * Created by ABoK4Do on 11.05.17.
 */

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class HibTest {

    public static void main(String[] args) throws IOException {
        /*FoodsEntity foodDel = new FoodsEntity();
        foodDel.setId(4601);
        DataBaseWorker.delOne(foodDel);

        FoodsEntity food = new FoodsEntity();
        food.setName("ServerTest2");
        food.setCategory(new CategoryEntity());
        food.getCategory().setName("sss");
        food.setPrice(111);
        FoodsEntity food2 = new FoodsEntity();
        food2.setName("ServerTest3");
        food2.setCategory(new CategoryEntity());
        food2.getCategory().setName("sup");
        food2.setPrice(222);
        List<FoodsEntity> listTest = new ArrayList<FoodsEntity>();
        listTest.add(food);
        listTest.add(food2);
        DataBaseWorker.addSome(listTest);

        for(FoodsEntity k: listTest){
        System.out.println(k.getName() + " | " + k.getId() + " | " + k.getPrice() + " | " + k.getCategoryId() + " | " + k.getCategory().getName());}


        //Вся таблица
        List<FoodsEntity> list1 = Factory.getInstance().getFoodDAO().findAll();

        System.out.println("========Все foods=========");
        System.out.println("NAME | ID | Price | catID | catName");
        for (FoodsEntity i : list1) {
            System.out.println(i.getName() + " | " + i.getId() + " | " + i.getPrice() + " | " + i.getCategoryId() + " | " + i.getCategory().getName());
        }
    */
        ObjectMapper mapper = new ObjectMapper();
        FoodsEntity food1 = new FoodService().findAll().get(0);
        String json = mapper.writeValueAsString(food1);
        System.out.println("class: "+json.getClass()+"|value="+json);
        FoodsEntity backFood = mapper.readValue(json, FoodsEntity.class);
        System.out.println("DONE");
        System.out.println(backFood.getName()+"|");
    }

}