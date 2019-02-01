package repository.custom.impl;

import entity.FlowerCategory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import repository.CrudRepositoryImpl;
import repository.custom.FlowerCategoryRepository;
import resources.HibUtil;

import java.util.ArrayList;
import java.util.List;

public class FlowerCategoryRepositoryImpl extends CrudRepositoryImpl<FlowerCategory,String> implements FlowerCategoryRepository {
    @Override
    public List<FlowerCategory> getSearch(String search) throws Exception {
        List<FlowerCategory>all;
        try(Session session= HibUtil.getSessionFactory().openSession()){
            session.getTransaction().begin();
            all=session.createQuery(" FROM FlowerCategory where status='search' ").list();
            session.getTransaction().commit();


        }catch (HibernateException e){
            return null;
        }
        return all;
    }
}
