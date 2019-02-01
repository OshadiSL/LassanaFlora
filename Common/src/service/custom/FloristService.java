package service.custom;

import dto.FloristDTO;
import observer.Subject;
import reservation.Reservations;
import service.SuperService;

import java.util.List;

public interface FloristService extends SuperService, Reservations, Subject {
    boolean save(FloristDTO floristDTO) throws Exception;

    List<FloristDTO> getloardOrders() throws Exception;
//    List<FlowerCategoryTupeDTO> getAll() throws Exception;

}
