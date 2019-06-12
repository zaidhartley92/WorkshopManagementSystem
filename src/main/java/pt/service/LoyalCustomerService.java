package pt.service;
import pt.domain.LoyalCustomer;

import java.util.Set;

public interface LoyalCustomerService extends IService<LoyalCustomer, String>{
    Set<LoyalCustomer> getAll();
}
