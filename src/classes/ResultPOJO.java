package classes;

/**
 * Created by ABoK4Do on 21.02.17.
 */
public class ResultPOJO {
    //Часть таблицы меню
    private int id;
    private String name;
    private int cat_id1;
    private float price;
    //Часть таблицы про категории
    private int cat_id2;
    private String cat_name;

    public ResultPOJO(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCat_id1(int cat_id1) {
        this.cat_id1 = cat_id1;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCat_id2(int cat_id2) {
        this.cat_id2 = cat_id2;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCat_id1() {
        return cat_id1;
    }

    public float getPrice() {
        return price;
    }

    public int getCat_id2() {
        return cat_id2;
    }

    public String getCat_name() {
        return cat_name;
    }
}
