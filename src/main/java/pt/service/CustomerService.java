package pt.service;
import pt.domain.Customer;

import java.util.Set;

public interface CustomerService extends IService<Customer, String>{

    Set<Customer> getAll();

}
