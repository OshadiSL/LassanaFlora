package business.custom;

import dto.FlowerDetailsDTO;

import java.util.ArrayList;

public interface FlowerDetailsBusiness {
    FlowerDetailsDTO search(int id) throws Exception;

    ArrayList<FlowerDetailsDTO> findAll() throws Exception;



}
