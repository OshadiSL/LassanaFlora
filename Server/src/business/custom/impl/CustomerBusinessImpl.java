package business.custom.impl;

import business.custom.CustomerBusiness;
import dto.CustomerDTO;
import dto.FlowerCategoryDTO;
import entity.Customer;
import entity.FlowerCategory;
import org.hibernate.Session;
import repository.RepoFactory;
import repository.custom.CustomerRepository;
import resources.HibUtil;

import java.util.List;

public class CustomerBusinessImpl implements CustomerBusiness {
    CustomerRepository customerRepository = RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.CUSTOMER);

    public CustomerBusinessImpl() {
    }

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            customerRepository.setSession(session);
            session.getTransaction().begin();
            session.save(new Customer(customerDTO.getCustId(), customerDTO.getName(), customerDTO.getAddress(), customerDTO.getTell(), customerDTO.getNic()));
            session.getTransaction().commit();

        }
        return true;
    }

    @Override
    public CustomerDTO search2(Integer text) throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            customerRepository.setSession(session);
            session.getTransaction().begin();
            Customer search = customerRepository.search(text);
            session.getTransaction().commit();
            return new CustomerDTO(search.getCustId(),search.getName(),search.getAddress(),search.getTell(),search.getNic());

        }
    }

}
