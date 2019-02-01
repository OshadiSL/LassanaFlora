package business.custom.impl;

import business.custom.Ordersbusiness;
import dto.CommanDTO;
import dto.FlowerCategoryDTO;
import dto.FlowerDetailsDTO;
import dto.OrderDTO;
import entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import repository.RepoFactory;
import repository.custom.FlowerDetailsRepository;
import repository.custom.OrderRepository;
import repository.custom.PayementRepository;
import resources.HibUtil;

import java.util.ArrayList;
import java.util.List;

public class OrdersBusinessImpl  implements Ordersbusiness {

    OrderRepository orderRepository= RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.ORDERS);
    PayementRepository payementRepository=RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.PAYMENT);
    FlowerDetailsRepository flowerDetailsRepository=RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.FLOWERDETAILS);
    public OrdersBusinessImpl() {
    }

    @Override
    public List<FlowerCategoryDTO> getAll() throws Exception {
              ArrayList<FlowerCategoryDTO>flowerCategoryDTOS=new ArrayList<>();
        try(Session session=HibUtil.getSessionFactory().openSession()){
            orderRepository.setSession(session);
            session.getTransaction().begin();
            List<FlowerCategory>list=orderRepository.getAll();
            for (FlowerCategory f1: list){
                flowerCategoryDTOS.add(new FlowerCategoryDTO(
                        f1.getFCID(),
                        f1.getCategoryType(),
                        f1.getPrice()));
            }
            session.getTransaction().commit();
        }
        return flowerCategoryDTOS;

    }

    @Override
    public boolean save(CommanDTO commanDTO) throws Exception {
      List<FlowerDetails>flowerDetails=new ArrayList<>();
      try(Session session=HibUtil.getSessionFactory().openSession()) {
          Customer customer = session.get(Customer.class, commanDTO.getOrderDTO().getCustId());
          Florist florist = session.get(Florist.class, commanDTO.getOrderDTO().getFloristId());
          Reception reception = session.get(Reception.class, commanDTO.getOrderDTO().getReceptionId());
//          Payment payment=session.get(Payment.class,commanDTO.getOrderDTO().getPaymentId());
          payementRepository.setSession(session);
          orderRepository.setSession(session);
          flowerDetailsRepository.setSession(session);
          session.beginTransaction();
          Orders orders = new Orders(commanDTO.getOrderDTO().getOid(), commanDTO.getOrderDTO().getDate(), commanDTO.getOrderDTO().getTime(), commanDTO.getOrderDTO().getStatus(), customer, reception, florist);
          Payment payment = new Payment(commanDTO.getPaymentDTO().getPayID(), commanDTO.getPaymentDTO().getTotal(), commanDTO.getPaymentDTO().getDate(), commanDTO.getPaymentDTO().getDiscount(), commanDTO.getPaymentDTO().getStatus());
          orderRepository.add(orders);
          orders.setPayment(payment);
          payementRepository.add(payment);

          for (FlowerDetailsDTO flowerDetailsDTO : commanDTO.getFlowerDetailsDTOS()) {
              Orders orders1 =session.get(Orders.class,flowerDetailsDTO.getOid());
              FlowerCategory flowerCategory = session.get(FlowerCategory.class,flowerDetailsDTO.getItemCode());
              int qty = flowerDetailsDTO.getOrderQty();
              double price = flowerDetailsDTO.getUnitPrice();
              String flowerName = flowerDetailsDTO.getFlowerName();

              FlowerDetails flowerDetails1 = new FlowerDetails(qty, price, orders1, flowerCategory, flowerName);
              flowerDetailsRepository.add(flowerDetails1);

          }
          session.getTransaction().commit();
          return true;
      }catch (HibernateException e){
          e.printStackTrace();
          return false;
      }



    }

    @Override
    public List<OrderDTO> getLoardOrders() throws Exception {
        List<OrderDTO>orderDTOS=new ArrayList<>();
        List<Orders>orders=orderRepository.getOrders();
        for(Orders orders1: orders){
           orderDTOS.add(new OrderDTO(orders1.getOid(),orders1.getDate(),orders1.getStatus(),orders1.getTime(),orders1.getCustomer().getCustId(),orders1.getFlorist().getFloristId(),orders1.getPayment().getPayID() ,orders1.getReception().getReceptionId()));

        }
        return orderDTOS;
    }

    @Override
    public boolean update(OrderDTO orderDTO) throws Exception {
        try(Session session=HibUtil.getSessionFactory().openSession()){
            Customer customer=session.get(Customer.class,orderDTO.getCustId());
            customer.setCustId(orderDTO.getCustId());
            Florist florist=session.get(Florist.class,orderDTO.getFloristId());
//            Florist florist1=new Florist();
//            florist1.setFloristId(orderDTO.getFloristId());
//            florist.setFloristId(orderDTO.getFloristId());
            Payment payment=session.get(Payment.class,orderDTO.getPayID());
//            payment.setPayID(orderDTO.getPayID());
            Reception reception=session.get(Reception.class,orderDTO.getReceptionId());
//            reception.setReceptionId(orderDTO.getReceptionId());
            orderRepository.setSession(session);
            session.getTransaction().begin();
            orderRepository.update(new Orders(orderDTO.getOid(),orderDTO.getDate(),orderDTO.getTime(),orderDTO.getStatus(),customer,payment,reception,florist));
            session.getTransaction().commit();
        }
        return true;
    }



}


