package dto;

public class OrderDTO implements SuperDTO {
    private int oid;
    private String date;
    private String status;
    private String time;
    private int custId;
    private String floristId;
    private int payID;
    private int receptionId;



    public OrderDTO() {
    }


    public OrderDTO(int oid, String date, String status, String time, int custId, String floristId, int payID, int receptionId) {
        this.oid = oid;
        this.date = date;
        this.status = status;
        this.time = time;
        this.custId = custId;
        this.floristId = floristId;
        this.payID = payID;
        this.receptionId = receptionId;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getFloristId() {
        return floristId;
    }

    public void setFloristId(String floristId) {
        this.floristId = floristId;
    }

    public int getPayID() {
        return payID;
    }

    public void setPayID(int payID) {
        this.payID = payID;
    }

    public int getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(int receptionId) {
        this.receptionId = receptionId;
    }


}
