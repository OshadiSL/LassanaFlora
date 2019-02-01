package repository;

import business.custom.impl.FlowerCategoryTypeBusinessImpl;
import business.custom.impl.ReceptionBusinessImpl;
import repository.custom.impl.*;

public class RepoFactory {
    public static RepoFactory repoFactory;

    public static RepoFactory getInstance(){
        if (repoFactory==null){
            repoFactory=new RepoFactory();
        }
        return repoFactory;
    }
    public enum RepoTypes{
        CUSTOMER,FLOWER,FLOWERCATEGORY,ORDERS,RESEPTION,FLORIST,PAYMENT,FLOWERDETAILS,FLOWERCATEGORYTYPE,ADMIN;
    }

    public <T> T getRepositoryFor(RepoTypes types){
        switch (types){
            case CUSTOMER:
                return (T) new CustomerRepositoryImpl();

            case FLOWERCATEGORY:
                return (T) new FlowerCategoryRepositoryImpl();
            case ORDERS:
                return (T) new OrderRepositoryImpl();
            case RESEPTION:
                return (T) new ReceptionRepositoryImpl();
            case FLORIST:
                return (T)new FloristRepositoryImpl();
            case FLOWERDETAILS:
                return (T) new FlowerDetailsRepositoryImpl();
            case PAYMENT:
                return (T)new PaymentRepositoryImpl();
            case FLOWERCATEGORYTYPE:
                return (T) new FlowerCategoryTypeRepositoryImpl();
            case ADMIN:
                return (T) new AdminRepositoryImpl();

                default:
                    return null;
        }
    }
}
