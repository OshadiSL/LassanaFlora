package dto;

public class FloristDTO implements SuperDTO {
    private String floristId;
    private String floristName;
    private String nic;
    private String contactNum;
    private String address;
    private String  userName;
    private String passWord;

    public FloristDTO() {
    }

    public FloristDTO(String floristId, String floristName, String nic, String contactNum, String address, String userName, String passWord) {
        this.floristId = floristId;
        this.floristName = floristName;
        this.nic = nic;
        this.contactNum = contactNum;
        this.address = address;
        this.userName = userName;
        this.passWord = passWord;
    }


    public FloristDTO(String floristId, String floristName, String userName, String passWord) {
        this.floristId = floristId;
        this.floristName = floristName;
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

    @Override
    public String toString() {
        return "FloristDTO{" +
                "floristId='" + floristId + '\'' +
                ", floristName='" + floristName + '\'' +
                ", nic='" + nic + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
