package resources;

import org.hibernate.Session;

public class test  {
    public static void main(String[] args) {

        try ( Session session=HibUtil.getSessionFactory().openSession()) {

        }

    }


}


