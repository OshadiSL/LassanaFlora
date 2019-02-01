package service.custom;

import dto.FlowerDetailsDTO;
import service.SuperService;

import java.util.List;

public interface OrderDetailsService extends SuperService {
    FlowerDetailsDTO search(int id) throws Exception;

    List<FlowerDetailsDTO> getAll()throws Exception;




//    Object getAll();
}
