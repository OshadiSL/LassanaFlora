package repository;

import entity.FlowerCategory;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class CrudRepositoryImpl <T,ID extends Serializable>implements CrudRepository<T,ID> {
   protected Session session;
   private Class<T>type;

    public CrudRepositoryImpl() {
        type=(Class<T>)((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
    }

    @Override
    public boolean add(T enty) throws Exception {
       session.save(enty);
       return true;
    }

    @Override
    public boolean delete(T enty) throws Exception {
       session.delete(enty);
       return true;
    }

    @Override
    public boolean update(T enty) throws Exception {
       session.update(enty);
       return true;
    }

    @Override
    public T search(int id) throws Exception {
      return session.get(type,id);
    }

    @Override
    public T search2(String text) throws Exception {
        return session.get(type,text);
    }

    @Override
    public List<T> findAll() throws Exception {
        return session.createQuery("FROM "+type.getName()).list();
    }

    @Override
    public List<FlowerCategory> getAll() throws Exception {
        return session.createQuery("FROM "+type.getName()).list();
    }

//    @Override
//    public List<T> getAll() throws Exception {
//
//    }

    @Override
    public void setSession(Session session) throws Exception {
        this.session=session;
    }
}
