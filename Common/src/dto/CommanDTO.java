package dto;

import java.util.List;

public class CommanDTO  implements SuperDTO{
    private PaymentDTO paymentDTO;
    private OrderDTO orderDTO;
    List<FlowerDetailsDTO>flowerDetailsDTOS;

    public CommanDTO() {
    }

    public CommanDTO(PaymentDTO paymentDTO, OrderDTO orderDTO, List<FlowerDetailsDTO> flowerDetailsDTOS) {
        this.paymentDTO = paymentDTO;
        this.orderDTO = orderDTO;
        this.flowerDetailsDTOS = flowerDetailsDTOS;
    }

    public PaymentDTO getPaymentDTO() {
        return paymentDTO;
    }

    public void setPaymentDTO(PaymentDTO paymentDTO) {
        this.paymentDTO = paymentDTO;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public List<FlowerDetailsDTO> getFlowerDetailsDTOS() {
        return flowerDetailsDTOS;
    }

    public void setFlowerDetailsDTOS(List<FlowerDetailsDTO> flowerDetailsDTOS) {
        this.flowerDetailsDTOS = flowerDetailsDTOS;
    }

    @Override
    public String toString() {
        return "CommanDTO{" +
                "paymentDTO=" + paymentDTO +
                ", orderDTO=" + orderDTO +
                ", flowerDetailsDTOS=" + flowerDetailsDTOS +
                '}';
    }
}
