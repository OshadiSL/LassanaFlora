package service.custom.impl;

import business.BusinessFactory;
import business.custom.CustomerBusiness;
import dto.CustomerDTO;
import dto.FlowerCategoryDTO;
import service.custom.CustomerService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Observer;

public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {
    CustomerBusiness customerBusiness= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.CUSTOMER);

    private static ArrayList<Observer>allItemObservers=new ArrayList<>();

    public CustomerServiceImpl() throws RemoteException {


    }

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        return customerBusiness.addCustomer(customerDTO);
    }

    @Override
    public CustomerDTO searchCustomer(Integer text) throws Exception {
        return customerBusiness.search2(text);

    }


}
