package pt.service.impl;

import pt.domain.Customer;
import pt.repository.CustomerRepository;
import pt.repository.impl.CustomerRepositoryImpl;
import pt.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    @Qualifier("CustomerRepo")
    private static CustomerServiceImpl service = null;
    private CustomerRepository repository;


    private CustomerServiceImpl(){
        this.repository = CustomerRepositoryImpl.getRepository();
    }

    public static CustomerService getService(){
        if (service == null) service = new CustomerServiceImpl();
        return service;
    }

    @Override
    public Customer create(Customer customer) {
        return this.repository.create(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return this.repository.update(customer);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Customer read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Customer> getAll() {
        return repository.getAll();
    }

}