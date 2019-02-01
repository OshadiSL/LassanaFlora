package repository.custom.impl;

import entity.Customer;
import repository.CrudRepositoryImpl;
import repository.custom.CustomerRepository;

public class CustomerRepositoryImpl extends CrudRepositoryImpl<Customer,String>implements CustomerRepository {
}
