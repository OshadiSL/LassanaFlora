package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Florist implements Serializable {
    @Id
    private String floristId;
    private String floristName;
    private String nic;
    private String contactNum;
    private String address;
    private String  userName;
    private String passWord;
    @OneToMany(mappedBy = "florist",cascade ={CascadeType.ALL} )
    private List<Orders> orders=new ArrayList<>();

    public Florist() {
    }

    public Florist(String floristId, String floristName, String nic, String contactNum, String address, String userName, String passWord, List<Orders> orders) {
        this.floristId = floristId;
        this.floristName = floristName;
        this.nic = nic;
        this.contactNum = contactNum;
        this.address = address;
        this.userName = userName;
        this.passWord = passWord;
        this.orders = orders;
    }

    public Florist(String floristId, String floristName, String nic, String contactNum, String address, String userName, String passWord) {
        this.floristId = floristId;
        this.floristName = floristName;
        this.nic = nic;
        this.contactNum = contactNum;
        this.address = address;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getFloristId() {
        return floristId;
    }

    public void setFloristId(String floristId) {
        this.floristId = floristId;
    }

    public String getFloristName() {
        return floristName;
    }

    public void setFloristName(String floristName) {
        this.floristName = floristName;
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
        return "Florist{" +
                "floristId='" + floristId + '\'' +
                ", floristName='" + floristName + '\'' +
                ", nic='" + nic + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", orders=" + orders +
                '}';
    }
}
