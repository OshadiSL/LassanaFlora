package service.custom;

import dto.CommanDTO;
import dto.FlowerCategoryDTO;
import dto.FlowerDetailsDTO;
import dto.OrderDTO;
import observer.Subject;
import reservation.Reservations;
import service.SuperService;

import java.util.List;

public interface OrderService extends SuperService, Reservations, Subject {
    List<FlowerCategoryDTO> getAll() throws Exception;

    boolean add(CommanDTO commanDTO) throws Exception;

//    List<OrderDTO> getloardOrder() throws Exception;

    List<OrderDTO> getloardOrders() throws Exception;

    boolean update(OrderDTO orderDTO) throws Exception;


}
