package service.custom.impl;

import business.BusinessFactory;
import business.custom.FloristBusiness;
import dto.FloristDTO;
import observer.Observer;
import reservationImpl.ReservationImpl;
import service.custom.FloristService;
import service.custom.OrderService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class FloristServiceImpl extends UnicastRemoteObject implements FloristService {

    private static ArrayList<Observer>observers=new ArrayList<>();

    private static ReservationImpl<FloristService>floristServiceReservation=new ReservationImpl<>();

    FloristBusiness floristBusiness= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.FLORIST);

    private static ArrayList<Observer>arrayList=new ArrayList<>();


    public FloristServiceImpl() throws RemoteException {
    }

    @Override
    public boolean save(FloristDTO floristDTO) throws Exception {
        return floristBusiness.save(floristDTO);
    }

    @Override
    public List<FloristDTO> getloardOrders() throws Exception {
        ArrayList<FloristDTO>floristDTOS=floristBusiness.findAll();
        return floristDTOS;
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
        return floristServiceReservation.reserve(id,this,true);
    }

    @Override
    public boolean released(Object id) throws Exception {
        return floristServiceReservation.release(id,this);
    }
}
