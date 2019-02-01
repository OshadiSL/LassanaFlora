package dto;

public class CustomerDTO implements SuperDTO{
    private int custId;
    private String name;
    private String address;
    private String tell;
    private String nic;

    public CustomerDTO() {
    }

    public CustomerDTO(int custId, String name, String address, String tell, String nic) {
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
}
