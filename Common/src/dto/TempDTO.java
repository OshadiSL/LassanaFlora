package dto;

public class TempDTO implements SuperDTO {
    private int FCID;
    private  String description;
    private double unitPrice;
    private int qty;

    public TempDTO() {
    }

    public TempDTO(int FCID, String description, double unitPrice, int qty) {
        this.FCID = FCID;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public TempDTO(int FCID, String description, double unitPrice) {
        this.FCID = FCID;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public TempDTO(int FCID) {
        this.FCID = FCID;
    }

    public int getFCID() {
        return FCID;
    }

    public void setFCID(int FCID) {
        this.FCID = FCID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "TempDTO{" +
                "FCID=" + FCID +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                '}';
    }
}
