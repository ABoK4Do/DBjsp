package classes;

/**
 * Created by ABoK4Do on 21.02.17.
 */
public class ResultPOJO {
    //Часть таблицы меню
    private int id;
    private String name;
    private int cat_id;
    private float price;
    //Часть таблицы про категории
    private String cat_name;

    public ResultPOJO(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public int getCat_id() {
        return cat_id;
    }

    public float getPrice() {
        return price;
    }



    public String getCat_name() {
        return cat_name;
    }
}
