package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Customer  implements Serializable {
   @Id
    private int custId;
    private String name;
    private String address;
    private String tell;
    private String nic;
    @OneToMany(mappedBy = "customer",cascade ={CascadeType.ALL} )
    private List<Orders>orders=new ArrayList<>();
    public Customer() {
    }

    public Customer(int custId, String name, String address, String tell, String nic, List<Orders> orders) {
        this.custId = custId;
        this.name = name;
        this.address = address;
        this.tell = tell;
        this.nic = nic;
        this.orders = orders;
    }

    public Customer(int custId, String name, String address, String tell, String nic) {
        this.custId = custId;
        this.name = name;
        this.address = address;
        this.tell = tell;
        this.nic = nic;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "CustomerBusiness{" +
                "custId=" + custId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tell='" + tell + '\'' +
                ", nic='" + nic + '\'' +
                ", orders=" + orders +
                '}';
    }
}
