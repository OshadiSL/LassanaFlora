package business.custom;

import business.SuperBussiness;
import dto.FloristDTO;

import java.util.ArrayList;

public interface FloristBusiness extends SuperBussiness {
    boolean save(FloristDTO floristDTO) throws Exception;

    ArrayList<FloristDTO> findAll() throws Exception;
}
