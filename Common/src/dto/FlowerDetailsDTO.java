package dto;

public class FlowerDetailsDTO implements SuperDTO {
    private int oid;
    private int itemCode;
    private int orderQty;
    private double unitPrice;

    private String flowerName;

    public FlowerDetailsDTO() {
    }

    public FlowerDetailsDTO(int orderQty, double unitPrice, int oid, int itemCode, String flowerName) {
        this.orderQty = orderQty;
        this.unitPrice = unitPrice;
        this.oid = oid;
        this.itemCode = itemCode;
        this.flowerName = flowerName;
    }

    public FlowerDetailsDTO(int oid, int itemCode, int orderQty, double unitPrice, String flowerName) {
        this.oid = oid;
        this.itemCode = itemCode;
        this.orderQty = orderQty;
        this.unitPrice = unitPrice;
        this.flowerName = flowerName;
    }



    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    @Override
    public String toString() {
        return "FlowerDetailsDTO{" +
                "orderQty=" + orderQty +
                ", unitPrice=" + unitPrice +
                ", oid=" + oid +
                ", itemCode=" + itemCode +
                ", flowerName='" + flowerName + '\'' +
                '}';
    }
}
