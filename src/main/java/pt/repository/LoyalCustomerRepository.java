package pt.repository;

import pt.domain.LoyalCustomer;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LoyalCustomerRepository extends IRepository<LoyalCustomer, String>{

    Set<LoyalCustomer> getAll();

}