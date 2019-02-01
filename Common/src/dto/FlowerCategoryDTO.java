package dto;

public class FlowerCategoryDTO implements SuperDTO  {
    private int FCID;
    private  String description;
    private double unitPrice;
    private String status;


    public FlowerCategoryDTO() {
    }

    public FlowerCategoryDTO(int FCID, String description, double unitPrice) {
        this.FCID = FCID;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public FlowerCategoryDTO(int FCID, String description, double unitPrice, String status) {
        this.FCID = FCID;
        this.description = description;
        this.unitPrice = unitPrice;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FlowerCategoryDTO{" +
                "FCID=" + FCID +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", status='" + status + '\'' +
                '}';
    }
}
