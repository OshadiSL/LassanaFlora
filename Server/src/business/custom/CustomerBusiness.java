package business.custom;

import business.SuperBussiness;
import dto.CustomerDTO;
import dto.FlowerCategoryDTO;

public interface CustomerBusiness extends SuperBussiness {
    boolean addCustomer(CustomerDTO customerDTO) throws Exception;

    CustomerDTO search2(Integer text) throws Exception;
}
