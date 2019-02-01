package server;

import org.hibernate.service.internal.SessionFactoryServiceRegistryFactoryImpl;
import service.impl.ServiceFactoryImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerStart {
    public static void main(String[] args) {
        try {
            Registry registry= LocateRegistry.createRegistry(7070);
            registry.rebind("flower", ServiceFactoryImpl.getInstance());
            System.out.println("Server Started");


        } catch (RemoteException ex) {
            Logger.getLogger(ServerStart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServerStart.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

}
