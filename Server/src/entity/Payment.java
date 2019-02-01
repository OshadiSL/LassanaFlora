package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity

public class Payment implements Serializable {
    @Id
    private int payID;
    private double total;
    private  String date;
    private String discount;
    private String status;
    @OneToMany(mappedBy = "payment",cascade = {CascadeType.ALL})
    private List<Orders>orders=new ArrayList<>();

    public Payment() {
    }

    public Payment(int payID, double total, String date, String discount, String status) {
        this.payID = payID;
        this.total = total;
        this.date = date;
        this.discount = discount;
        this.status = status;
    }

    public Payment(int payID, double total, String date, String discount, String status, List<Orders> orders) {
        this.payID = payID;
        this.total = total;
        this.date = date;
        this.discount = discount;
        this.status = status;
        this.orders = orders;
    }

    public int getPayID() {
        return payID;
    }

    public void setPayID(int payID) {
        this.payID = payID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payID=" + payID +
                ", total=" + total +
                ", date='" + date + '\'' +
                ", discount='" + discount + '\'' +
                ", status='" + status + '\'' +
                ", orders=" + orders +
                '}';
    }
}
