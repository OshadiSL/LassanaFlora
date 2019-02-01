package repository;

import entity.FlowerCategory;

import java.util.List;

public interface CrudRepository<T,ID>extends SuperRepository {
    public boolean add(T enty)throws Exception;
    public boolean delete(T enty)throws Exception;
    public boolean update(T enty)throws Exception;
    public T search(int id)throws Exception;
    public T search2(String text)throws Exception;
    public List<T> findAll()throws Exception;

  public List<FlowerCategory> getAll() throws Exception;
}
