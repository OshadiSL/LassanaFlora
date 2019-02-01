package service.custom;

import observer.Subject;
import reservation.Reservations;
import service.SuperService;

public interface GetOrderService extends SuperService, Reservations, Subject {

}
