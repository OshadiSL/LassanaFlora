package service.impl;

import service.ServiceFactory;
import service.SuperService;
import service.custom.impl.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {
    public ServiceFactoryImpl() throws RemoteException {
    }
    private static ServiceFactoryImpl serviceFactory;

    public static ServiceFactoryImpl getInstance() throws RemoteException {
        if(serviceFactory==null){
            serviceFactory=new ServiceFactoryImpl();
        }
        return serviceFactory;
    }



    @Override
    public <T> T getSuperService(ServiceTypes types) throws Exception {
        switch (types){
            case CUSTOMER:
                return(T) new CustomerServiceImpl();

            case FLOWERCATEGORY:
                return (T) new FlowerCategoryServiceImpl();
            case ORDERS:
                return (T) new OrderServiceImpl();
            case FLORIST:
                return (T) new FloristServiceImpl();
            case RESEPTION:
                return (T)new ReceptionServiceImpl();
            case PAYMENT:
                return (T)new PayementServiceImpl();
            case FLOWERDETAILS:
                return (T)new FlowerDetailsServiceImpl();
            case FLOWERCATEGORYTYPE:
                return (T) new FlowerCategoryTypeserviceImpl();
            case ADMIN:
                return (T)new AdminServiceImpl();

            default:
                return null;
        }
    }
}
