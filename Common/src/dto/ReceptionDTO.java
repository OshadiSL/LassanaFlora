package dto;

public class ReceptionDTO implements SuperDTO {
    private int receptionId;
    private String receptionName;
    private String nic;
    private String contactNum;
    private String address;
    private String  userName;
    private String passWord;


    public ReceptionDTO() {
    }

    public ReceptionDTO(int receptionId, String receptionName, String nic, String contactNum, String address, String userName, String passWord) {
        this.receptionId = receptionId;
        this.receptionName = receptionName;
        this.nic = nic;
        this.contactNum = contactNum;
        this.address = address;
        this.userName = userName;
        this.passWord = passWord;
    }

    public ReceptionDTO(int receptionId, String receptionName, String userName, String passWord) {
        this.receptionId = receptionId;
        this.receptionName = receptionName;
        this.userName = userName;
        this.passWord = passWord;
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

    @Override
    public String toString() {
        return "ReceptionDTO{" +
                "receptionId=" + receptionId +
                ", receptionName='" + receptionName + '\'' +
                ", nic='" + nic + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
