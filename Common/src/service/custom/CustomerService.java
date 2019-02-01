package service.custom;

import dto.CustomerDTO;
import dto.FlowerCategoryDTO;
import service.SuperService;

public interface CustomerService extends SuperService {
    boolean addCustomer(CustomerDTO customerDTO)throws Exception;
   CustomerDTO searchCustomer(Integer text) throws Exception;
}
