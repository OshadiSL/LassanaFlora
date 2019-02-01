package service.custom;

import dto.FlowerCategoryTupeDTO;
import service.SuperService;

import java.util.List;

public interface FlowerCategoryTypeService extends SuperService {
    boolean addCategoryType(FlowerCategoryTupeDTO flowerCategoryDTO) throws Exception;

    FlowerCategoryTupeDTO search(int parseInt) throws Exception;

    FlowerCategoryTupeDTO search2(String text) throws Exception;

    boolean delete(FlowerCategoryTupeDTO flowerCategoryDTO) throws Exception;

    List<FlowerCategoryTupeDTO> getAll() throws Exception;
//

//    List<FlowerCategoryTupeDTO> getAll() throws Exception;
}
