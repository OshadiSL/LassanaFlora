package service.custom;

import dto.ReceptionDTO;
import service.SuperService;

import java.util.List;

public interface ReceptionService extends SuperService {
    boolean save(ReceptionDTO receptionDTO) throws Exception;

        List<ReceptionDTO> getAll()throws Exception;
}
