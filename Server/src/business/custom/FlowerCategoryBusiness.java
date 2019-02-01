package business.custom;

import business.SuperBussiness;
import dto.FlowerCategoryDTO;
import dto.FlowerCategoryTupeDTO;

import java.util.ArrayList;
import java.util.List;

public interface FlowerCategoryBusiness extends SuperBussiness {
    boolean add(FlowerCategoryDTO flowerCategoryDTO) throws Exception;

    FlowerCategoryDTO search(int id) throws Exception;

    ArrayList<FlowerCategoryDTO> findAll() throws Exception;

    boolean delete(FlowerCategoryDTO flowerCategoryDTO) throws  Exception;

    boolean update(FlowerCategoryDTO flowerCategoryDTO) throws Exception;

    ArrayList<String> getCtegory() throws Exception;

    List<FlowerCategoryDTO> getSearch(String search) throws Exception;

    boolean addCategoryType(FlowerCategoryTupeDTO flowerCategoryDTO) throws Exception;
}
