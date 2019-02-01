package repository.custom.impl;

import entity.FlowerDetails;
import entity.Orders;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import repository.CrudRepositoryImpl;
import repository.RepoFactory;
import repository.custom.OrderRepository;
import resources.HibUtil;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl  extends CrudRepositoryImpl<Orders,String> implements OrderRepository {
    @Override
    public List<Orders> getOrders() throws Exception {
        List<Orders> all;
//        ArrayList<Orders> orders = new ArrayList<>();
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            all = session.createQuery("from Orders where status='pending'").list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            return null;
        }
        return all;
    }


}


