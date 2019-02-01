package service.custom;

import dto.FlowerCategoryDTO;
import dto.FlowerCategoryTupeDTO;
import service.SuperService;

import java.util.ArrayList;
import java.util.List;

public interface FlowerCategoryService extends SuperService {
    boolean add(FlowerCategoryDTO flowerCategoryDTO) throws Exception;

    FlowerCategoryDTO search(int id) throws  Exception;

    List<FlowerCategoryDTO> getAll() throws Exception;

    boolean delete(FlowerCategoryDTO flowerCategoryDTO) throws  Exception;

    boolean update(FlowerCategoryDTO flowerCategoryDTO) throws Exception;

    ArrayList<String> getCategory() throws Exception;

    List<FlowerCategoryDTO> getSearch(String search) throws Exception;


    boolean addCategoryType(FlowerCategoryTupeDTO flowerCategoryDTO) throws Exception;
}
