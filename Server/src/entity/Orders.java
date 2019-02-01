package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Orders implements Serializable {
    @Id
    private int oid;
    private String date;
    private String time;
    private String status;
//    private int cid;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @ManyToOne(cascade = CascadeType.ALL)
    private Payment payment;
    @ManyToOne(cascade = CascadeType.ALL)
    private Reception reception;
    @ManyToOne(cascade = CascadeType.ALL)
    private Florist florist;
    @OneToMany(mappedBy = "orders",cascade = {CascadeType.ALL})
    private List<FlowerDetails>flowerDetails=new ArrayList<>();

    public Orders() {
    }

    public Orders(int orderId) {
    }

    public Orders(int oid, String date, String time, String status, Customer customer, Payment payment, Reception reception, Florist florist, List<FlowerDetails> flowerDetails) {
        this.oid = oid;
        this.date = date;
        this.time = time;
        this.status = status;
        this.customer = customer;
        this.payment = payment;
        this.reception = reception;
        this.florist = florist;
        this.flowerDetails = flowerDetails;
    }

    public Orders(int oid, String date, String time, String status, Customer customer, Payment payment, Reception reception, Florist florist) {
        this.oid = oid;
        this.date = date;
        this.time = time;
        this.status = status;
        this.customer = customer;
        this.payment = payment;
        this.reception = reception;
        this.florist = florist;
    }

    public Orders(int oid, String date, String time, String status, Customer customer, Reception reception, Florist florist, List<FlowerDetails> flowerDetails) {
        this.oid = oid;
        this.date = date;
        this.time = time;
        this.status = status;
        this.customer = customer;
        this.reception = reception;
        this.florist = florist;
        this.flowerDetails = flowerDetails;
    }

    public Orders(int oid, String date, String time, String status, Customer customer, Reception reception, Florist florist) {
        this.oid = oid;
        this.date = date;
        this.time = time;
        this.status = status;
        this.customer = customer;
        this.reception = reception;
        this.florist = florist;
    }

//    public Orders(int oid, String date, String status, String time, Customer customer, Florist florist, Payment payment, Reception reception) {
//    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }

    public Florist getFlorist() {
        return florist;
    }

    public void setFlorist(Florist florist) {
        this.florist = florist;
    }

    public List<FlowerDetails> getFlowerDetails() {
        return flowerDetails;
    }

    public void setFlowerDetails(List<FlowerDetails> flowerDetails) {
        this.flowerDetails = flowerDetails;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                ", payment=" + payment +
                ", reception=" + reception +
                ", florist=" + florist +
                ", flowerDetails=" + flowerDetails +
                '}';
    }
}
