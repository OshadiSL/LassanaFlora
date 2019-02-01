package business.custom;

import dto.ReceptionDTO;
import service.SuperService;

import java.util.ArrayList;

public interface ReceptionBusiness extends SuperService {
    boolean save(ReceptionDTO receptionDTO) throws Exception;

    ArrayList<ReceptionDTO> findAll() throws Exception;
}
