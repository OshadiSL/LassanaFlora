package repository.custom;

import entity.FlowerCategory;
import repository.CrudRepository;

import java.util.List;

public interface FlowerCategoryRepository extends CrudRepository<FlowerCategory,String> {

    List<FlowerCategory> getSearch(String search) throws Exception;

}
