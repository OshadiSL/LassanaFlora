package business;

import business.custom.impl.*;
import service.custom.impl.FlowerCategoryTypeserviceImpl;

public class BusinessFactory {
    private static  BusinessFactory businessFactory;

    public static BusinessFactory getInstance(){
        if(businessFactory==null){
            businessFactory=new BusinessFactory();

        }
        return businessFactory;
    }

    public enum BusinessTypes{
                   CUSTOMER,FLOWER,FLOWERCATEGORY,ORDERS,RECEPTION,FLORIST,PAYMENT,FLOWERDETAILS,FLOWERCATEGORYTYPE,ADMIN
    }
    public <T> T getBusinessFor(BusinessTypes types){
        switch (types){
            case CUSTOMER:
                return (T) new CustomerBusinessImpl();


            case FLOWERCATEGORY:
                return (T) new  FlowerCategoryBusinessImpl();
            case ORDERS:
                return (T) new OrdersBusinessImpl();
            case RECEPTION:
                return (T) new ReceptionBusinessImpl();
            case FLORIST:
                return (T) new FloristBusinessImpl();
            case PAYMENT:
                return (T) new PaymentBusinessImpl();
            case FLOWERDETAILS:
                return (T) new FlowerDetailsBusinessImpl();

            case FLOWERCATEGORYTYPE:
                return (T) new FlowerCategoryTypeBusinessImpl();
            case ADMIN:
                return (T) new AdminBusinessImpl();
             default:
                 return null;


        }
    }
}
