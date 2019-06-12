package pt.repository;

import pt.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CustomerRepository extends IRepository<Customer, String>{

    Set<Customer> getAll();

}
