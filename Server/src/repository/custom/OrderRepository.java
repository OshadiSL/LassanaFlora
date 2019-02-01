package repository.custom;

import entity.FlowerDetails;
import entity.Orders;
import repository.CrudRepository;

import java.util.List;

public interface OrderRepository  extends CrudRepository<Orders,String> {
//    List<Orders> getAllOrder() throws Exception;

    List<Orders> getOrders() throws Exception;


 }
