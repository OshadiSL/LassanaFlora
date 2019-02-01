package business.custom;

import business.SuperBussiness;
import dto.FlowerCategoryTupeDTO;

import java.util.ArrayList;

public interface FlowerCategoryTypeBusiness  extends SuperBussiness {
    boolean addCategoryType(FlowerCategoryTupeDTO flowerCategoryDTO) throws Exception;

    FlowerCategoryTupeDTO search(int parseInt) throws Exception;

    FlowerCategoryTupeDTO search2(String text) throws Exception;

    boolean delete(FlowerCategoryTupeDTO flowerCategoryDTO) throws Exception;

    ArrayList<FlowerCategoryTupeDTO> findAll() throws Exception;
}
