package service;

import java.rmi.Remote;

public interface ServiceFactory extends Remote {
    public enum  ServiceTypes{
        CUSTOMER,FLOWER,FLOWERCATEGORY,ORDERS,RESEPTION,FLORIST,PAYMENT,FLOWERDETAILS,FLOWERCATEGORYTYPE,ADMIN

    }
    public <T>T getSuperService(ServiceTypes types)throws Exception;
}
