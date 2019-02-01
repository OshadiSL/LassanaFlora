package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
public class CategoryType implements Serializable {
    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy = "categoryType1",cascade ={CascadeType.ALL} )
    private List<FlowerCategory> flowerCategories=new ArrayList<>();


    public CategoryType() {
    }


    public CategoryType(String id, String name, List<FlowerCategory> flowerCategories) {
        this.id = id;
        this.name = name;
        this.flowerCategories = flowerCategories;
    }

    public CategoryType(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FlowerCategory> getFlowerCategories() {
        return flowerCategories;
    }

    public void setFlowerCategories(List<FlowerCategory> flowerCategories) {
        this.flowerCategories = flowerCategories;
    }

    @Override
    public String toString() {
        return "CategoryType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", flowerCategories=" + flowerCategories +
                '}';
    }
}
