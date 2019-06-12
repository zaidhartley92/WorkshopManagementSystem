package pt.repository.impl;

import pt.domain.LoyalCustomer;
import pt.repository.LoyalCustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("LoyalCustomerRepo")
public class LoyalCustomerRepositoryImpl implements LoyalCustomerRepository {

    private static LoyalCustomerRepositoryImpl repository = null;
    private Set<LoyalCustomer> loyalCustomers;

    private LoyalCustomerRepositoryImpl(){
        this.loyalCustomers = new HashSet<>();
    }

    public static LoyalCustomerRepositoryImpl getRepository(){
        if (repository == null) repository = new LoyalCustomerRepositoryImpl();
        return repository;
    }

    @Override
    public Set<LoyalCustomer> getAll() {
        return this.loyalCustomers;
    }

    @Override
    public LoyalCustomer create(LoyalCustomer loyalCustomer) {
        this.loyalCustomers.add(loyalCustomer);
        return loyalCustomer;
    }

    @Override
    public LoyalCustomer update(LoyalCustomer loyalCustomer) {

        LoyalCustomer[] cloneOfLoyalCustomers = loyalCustomers.toArray(new LoyalCustomer[loyalCustomers.size()]);
        for (int i = 0; i<cloneOfLoyalCustomers.length;i++) {
            if (cloneOfLoyalCustomers[i].equals(loyalCustomer)) {
                loyalCustomers.remove(cloneOfLoyalCustomers[i]);
            }
        }
        return create(loyalCustomer);
    }

    @Override
    public void delete(String loyalCustomerId) {
        LoyalCustomer[] cloneOfLoyalCustomers = loyalCustomers.toArray(new LoyalCustomer[loyalCustomers.size()]);
        for (int i = 0; i<cloneOfLoyalCustomers.length;i++) {
            if (cloneOfLoyalCustomers[i].getLoyalCustomerId() == loyalCustomerId) {
                if (loyalCustomers.contains(cloneOfLoyalCustomers[i])){
                    loyalCustomers.remove(cloneOfLoyalCustomers[i]);
                }
            }
        }
    }

    @Override
    public LoyalCustomer read(String loyalCustomerId) {

        LoyalCustomer loyalCustomerToReturn = null;

        LoyalCustomer[] cloneOfLoyalCustomers = loyalCustomers.toArray(new LoyalCustomer[loyalCustomers.size()]);

        for (int i = 0; i<cloneOfLoyalCustomers.length;i++) {
            if (cloneOfLoyalCustomers[i].getLoyalCustomerId() == loyalCustomerId) {
                loyalCustomerToReturn = cloneOfLoyalCustomers[i];
            }
        }

        return loyalCustomerToReturn;
    }
}
