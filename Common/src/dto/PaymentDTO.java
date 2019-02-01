package dto;

public class PaymentDTO implements SuperDTO {
    private int payID;
    private double total;
    private  String date;
    private String discount;
    private String status;


    public PaymentDTO() {
    }

    public PaymentDTO(int payID, double total, String date, String discount, String status) {
        this.payID = payID;
        this.total = total;
        this.date = date;
        this.discount = discount;
        this.status = status;
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

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "payID=" + payID +
                ", total=" + total +
                ", date='" + date + '\'' +
                ", discount='" + discount + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
