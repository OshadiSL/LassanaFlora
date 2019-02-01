package business.custom;

import business.SuperBussiness;
import dto.CommanDTO;
import dto.FlowerCategoryDTO;
import dto.FlowerDetailsDTO;
import dto.OrderDTO;

import java.util.List;

public interface Ordersbusiness extends SuperBussiness {
//    List<FlowerCategoryDTO> findAll() throws Exception;

    List<FlowerCategoryDTO> getAll() throws Exception;

    boolean save(CommanDTO commanDTO) throws  Exception;

//    List<OrderDTO> getLoardOrder() throws Exception;

    List<OrderDTO> getLoardOrders() throws Exception;

    boolean update(OrderDTO orderDTO) throws Exception;


}
