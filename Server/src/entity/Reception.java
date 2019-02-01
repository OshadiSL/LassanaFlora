package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Reception implements Serializable {
    @Id
    private int receptionId;
    private String receptionName;
    private String nic;
    private String contactNum;
    private String address;
    private String  userName;
    private String passWord;
    @OneToMany(mappedBy = "reception",cascade ={CascadeType.ALL} )
    private List<Orders> orders=new ArrayList<>();

    public Reception() {
    }

    public Reception(int receptionId, String receptionName, String nic, String contactNum, String address, String userName, String passWord) {
        this.receptionId = receptionId;
        this.receptionName = receptionName;
        this.nic = nic;
        this.contactNum = contactNum;
        this.address = address;
        this.userName = userName;
        this.passWord = passWord;
    }

    public Reception(int receptionId, String receptionName, String nic, String contactNum, String address, String userName, String passWord, List<Orders> orders) {
        this.receptionId = receptionId;
        this.receptionName = receptionName;
        this.nic = nic;
        this.contactNum = contactNum;
        this.address = address;
        this.userName = userName;
        this.passWord = passWord;
        this.orders = orders;
    }

    public int getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(int receptionId) {
        this.receptionId = receptionId;
    }

    public String getReceptionName() {
        return receptionName;
    }

    public void setReceptionName(String receptionName) {
        this.receptionName = receptionName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Reception{" +
                "receptionId=" + receptionId +
                ", receptionName='" + receptionName + '\'' +
                ", nic='" + nic + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", orders=" + orders +
                '}';
    }
}
