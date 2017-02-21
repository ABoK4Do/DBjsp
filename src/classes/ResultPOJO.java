package classes;

import java.util.ArrayList;

/**
 * Created by ABoK4Do on 21.02.17.
 */
public class ResultPOJO {
    private int id;
    private String name;
    private int cat_id;
    private float price;

    public ResultPOJO(){};

    //id
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    //name
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    //cat_id
    public void setCat_id(int cat_id){
        this.cat_id = cat_id;
    }
    public int getCat_id(){
        return this.cat_id;
    }

    //price
    public float setPrice(float price){
        this.price = price;
    } public float getPrice(){
        return this.price;
    }




}
