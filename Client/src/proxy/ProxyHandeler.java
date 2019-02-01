package proxy;

import service.ServiceFactory;
import service.SuperService;
import service.custom.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProxyHandeler implements ServiceFactory {
   private static  ProxyHandeler proxyHandeler;
   private FlowerCategoryService flowerCategoryService;
   private OrderService orderService;
   private CustomerService customerService;
   private ReceptionService receptionService;
   private FloristService floristService;
   private PayementService payementService;
   private OrderDetailsService orderDetailsService;
   private FlowerCategoryTypeService flowerCategoryTypeService;

    public static ProxyHandeler getInstance() throws Exception {
        if(proxyHandeler==null){
            proxyHandeler=new ProxyHandeler();
        }
        return proxyHandeler;
    }
    public ProxyHandeler()throws Exception{
        try{
            ServiceFactory serviceFactory= (ServiceFactory) Naming.lookup("rmi://localhost:7070/flower");
             orderService=serviceFactory.getSuperService(ServiceTypes.ORDERS);
             customerService=serviceFactory.getSuperService(ServiceTypes.CUSTOMER);
             receptionService=serviceFactory.getSuperService(ServiceTypes.RESEPTION);
             floristService=serviceFactory.getSuperService(ServiceTypes.FLORIST);
            payementService=serviceFactory.getSuperService(ServiceTypes.PAYMENT);
            orderDetailsService=serviceFactory.getSuperService(ServiceTypes.FLOWERDETAILS);
            flowerCategoryService=serviceFactory.getSuperService(ServiceTypes.FLOWERCATEGORY);
            flowerCategoryTypeService=serviceFactory.getSuperService(ServiceTypes.FLOWERCATEGORYTYPE);

        }catch (NotBoundException ex){
            Logger.getLogger(ProxyHandeler.class.getName()).log(Level.SEVERE,null,ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProxyHandeler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ProxyHandeler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @Override
    public <T> T getSuperService(ServiceTypes types) throws Exception {
        switch (types) {

            case FLOWERCATEGORY:
                return (T)flowerCategoryService;
            case ORDERS:
                return (T)orderService;
            case CUSTOMER:
                return (T)customerService;
            case RESEPTION:
                return (T) receptionService;
            case FLORIST:
                return (T) floristService;
            case PAYMENT:
                return (T) payementService;
            case FLOWERDETAILS:
                return (T) orderDetailsService;
            case FLOWERCATEGORYTYPE:
                return (T) flowerCategoryTypeService;
            default:
                return null;

        }
    }
}
