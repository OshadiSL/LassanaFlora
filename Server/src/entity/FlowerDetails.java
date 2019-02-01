package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class FlowerDetails implements Serializable {

    private int orderQty;
    private double unitPrice;
//    private double orderPrice;
    @Id
    @ManyToOne(cascade = {CascadeType.ALL})
    private Orders orders;
    @Id
    @ManyToOne(cascade = {CascadeType.ALL})
    private FlowerCategory flowerCategory;
    private String flowerName;


    public FlowerDetails() {
    }

    public FlowerDetails(int orderQty, double unitPrice, Orders orders, FlowerCategory flowerCategory, String flowerName) {
        this.orderQty = orderQty;
        this.unitPrice = unitPrice;
//        this.orderPrice = orderPrice;
        this.orders = orders;
        this.flowerCategory = flowerCategory;
        this.flowerName = flowerName;
    }


    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }



    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public FlowerCategory getFlowerCategory() {
        return flowerCategory;
    }

    public void setFlowerCategory(FlowerCategory flowerCategory) {
        this.flowerCategory = flowerCategory;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    @Override
    public String toString() {
        return "FlowerDetails{" +
                "orderQty=" + orderQty +
                ", unitPrice=" + unitPrice +
                ", orders=" + orders +
                ", flowerCategory=" + flowerCategory +
                ", flowerName='" + flowerName + '\'' +
                '}';
    }
}
