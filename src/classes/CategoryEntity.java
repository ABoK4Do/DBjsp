package classes;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ABoK4Do on 11.05.17.
 */
@Entity
@Proxy(lazy = false)
@Table(name = "CATEGORY", schema = "APP")
public class CategoryEntity {
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "NAME", nullable = false, length = 20)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    @JsonBackReference
    private List<FoodsEntity> foods;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

   public List<FoodsEntity> getFoods() {
        return foods;
    }
    public void setFoods(List<FoodsEntity> foods) {
        this.foods = foods;
    }
}
