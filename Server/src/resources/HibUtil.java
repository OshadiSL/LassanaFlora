package resources;

import entity.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class HibUtil {
    private static SessionFactory sessionFactory=buildSesssionFactory();

    private static SessionFactory buildSesssionFactory() {
        StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().loadProperties("setting/db.properties").build();
        Metadata metadata= new MetadataSources(standardServiceRegistry)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(FlowerDetails.class)
                .addAnnotatedClass(FlowerCategory.class)
                .addAnnotatedClass(Reception.class)
                .addAnnotatedClass(Florist.class)
                .addAnnotatedClass(CategoryType.class)
                .buildMetadata();

        return metadata.getSessionFactoryBuilder().build();

    }
    public  static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}

