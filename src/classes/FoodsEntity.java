package classes;


import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

/**
 * Created by ABoK4Do on 11.05.17.
 */
@Entity
@Proxy(lazy = false)
@Table(name = "FOODS", schema = "APP")
public class FoodsEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Expose
    private int id;

    @Column(name = "NAME", nullable = true, length = 30)
    //@Expose
    private String name;

    @Column(name = "CATEGORY_ID", nullable = true)
    //@Expose
    private Integer categoryId;

    @Column(name = "PRICE", nullable = true)
    //@Expose
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "CATEGORY_ID", insertable = false, updatable = false, nullable = true)
    //@Expose
    @JsonManagedReference
    private CategoryEntity category;


    public FoodsEntity(){

    }

    public FoodsEntity(String name,  Integer price){

        this.name = name;
        this.categoryId = 0;
        this.price = price;
    }

    public FoodsEntity(String name, Integer categoryId, Integer price){

        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
    }

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


    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }


    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

   public CategoryEntity getCategory() {
        return category;
    }
    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodsEntity that = (FoodsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
