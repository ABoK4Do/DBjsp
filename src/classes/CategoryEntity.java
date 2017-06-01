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
  //  @Expose
    private int id;

    @Column(name = "NAME", nullable = false, length = 20)
   // @Expose
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  //  @Expose(serialize = false, deserialize = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
