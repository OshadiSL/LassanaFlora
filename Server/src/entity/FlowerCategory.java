package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity

public class FlowerCategory implements Serializable {
    @Id
    private int FCID;
    private String categoryType;
    private double price;
    private String status;
    @OneToMany(mappedBy = "flowerCategory",cascade = CascadeType.ALL)
    private List<FlowerDetails>flowerDetails=new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private CategoryType categoryType1;


    public FlowerCategory() {
    }

    public FlowerCategory(int FCID, String categoryType, double price, String status) {
        this.FCID = FCID;
        this.categoryType = categoryType;
        this.price = price;
        this.status = status;
    }

    public FlowerCategory(int FCID, String categoryType, double price, String status, List<FlowerDetails> flowerDetails) {
        this.FCID = FCID;
        this.categoryType = categoryType;
        this.price = price;
        this.status = status;
        this.flowerDetails = flowerDetails;
    }

    public FlowerCategory(int FCID) {
        this.FCID = FCID;
        this.categoryType = categoryType;
        this.price = price;
        this.status = status;
    }

    public FlowerCategory(int FCID, String categoryType, double price, String status, List<FlowerDetails> flowerDetails, CategoryType categoryType1) {
        this.FCID = FCID;
        this.categoryType = categoryType;
        this.price = price;
        this.status = status;
        this.flowerDetails = flowerDetails;
        this.categoryType1 = categoryType1;
    }

    public int getFCID() {
        return FCID;
    }

    public void setFCID(int FCID) {
        this.FCID = FCID;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<FlowerDetails> getFlowerDetails() {
        return flowerDetails;
    }

    public void setFlowerDetails(List<FlowerDetails> flowerDetails) {
        this.flowerDetails = flowerDetails;
    }

    public CategoryType getCategoryType1() {
        return categoryType1;
    }

    public void setCategoryType1(CategoryType categoryType1) {
        this.categoryType1 = categoryType1;
    }

    @Override
    public String toString() {
        return "FlowerCategory{" +
                "FCID=" + FCID +
                ", categoryType='" + categoryType + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", flowerDetails=" + flowerDetails +
                ", categoryType1=" + categoryType1 +
                '}';
    }
}
