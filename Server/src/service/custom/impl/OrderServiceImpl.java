package service.custom.impl;

import business.BusinessFactory;
import business.custom.Ordersbusiness;
import dto.CommanDTO;
import dto.FlowerCategoryDTO;
import dto.FlowerDetailsDTO;
import dto.OrderDTO;
import observer.Observer;
import reservationImpl.ReservationImpl;
import service.custom.OrderService;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl extends UnicastRemoteObject implements OrderService {
    private static ArrayList<Observer>observers=new ArrayList<>();
    Ordersbusiness orderBusiness = BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.ORDERS);
    private static ReservationImpl<OrderService>orderServiceReservation=new ReservationImpl<>();

    public OrderServiceImpl() throws Exception {
    }

    @Override
    public List<FlowerCategoryDTO> getAll() throws Exception {
        List<FlowerCategoryDTO> flowerCategoryDTOS=orderBusiness.getAll();
        return flowerCategoryDTOS;
    }

    @Override
    public boolean add(CommanDTO commanDTO) throws Exception {
        boolean save = orderBusiness.save(commanDTO);
        if (save){
            notifyAllObservers("add");
            return  true;
        }
        return  false;
    }

    @Override
    public List<OrderDTO> getloardOrders() throws Exception {
      List<OrderDTO>orderDTOS=orderBusiness.getLoardOrders();
      return orderDTOS;
    }

    @Override
    public boolean update(OrderDTO orderDTO) throws Exception {
        boolean update=orderBusiness.update(orderDTO);
        if (update){
            notifyAllObservers("update");
            return true;
        }
        return true;
    }

    @Override
    public void register(Observer observer) throws Exception {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) throws Exception {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers(String message) throws Exception {
       for (Observer observer:observers){
           new Thread(()->{
               try {
                   observer.update(message);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }).start();
       }

    }

    @Override
    public boolean reserved(Object id) throws Exception {
        return orderServiceReservation.reserve(id,this,true);
    }

    @Override
    public boolean released(Object id) throws Exception {
        return orderServiceReservation.release(id,this);
    }


//    @Override
//    public List<OrderDTO> getloardOrder() throws Exception {
//     List<OrderDTO>orderDTOS=orderBusiness.getLoardOrder();
//     return orderDTOS;
//    }
}
