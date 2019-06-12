package pt.repository.impl;

import pt.domain.Customer;
import pt.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("CustomerRepo")
public class CustomerRepositoryImpl implements CustomerRepository {

    private static CustomerRepositoryImpl repository = null;
    private Set<Customer> customers;

    private CustomerRepositoryImpl(){
        this.customers = new HashSet<>();
    }

    public static CustomerRepositoryImpl getRepository(){
        if (repository == null) repository = new CustomerRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Customer> getAll() {
        return this.customers;
    }

    @Override
    public Customer create(Customer customer) {
        this.customers.add(customer);
        return customer;
    }

    @Override
    public Customer update(Customer customer) {

        Customer[] cloneOfCustomers = customers.toArray(new Customer[customers.size()]);
        for (int i = 0; i<cloneOfCustomers.length;i++) {
            if (cloneOfCustomers[i].equals(customer)) {
                customers.remove(cloneOfCustomers[i]);
            }
        }
        return create(customer);
    }

    @Override
    public void delete(String customerId) {
        Customer[] cloneOfCustomers = customers.toArray(new Customer[customers.size()]);
        for (int i = 0; i<cloneOfCustomers.length;i++) {
            if (cloneOfCustomers[i].getCustomerId() == customerId) {
                if (customers.contains(cloneOfCustomers[i])){
                    customers.remove(cloneOfCustomers[i]);
                }
            }
        }
    }

    @Override
    public Customer read(String customerId) {

        Customer customerToReturn = null;

        Customer[] cloneOfCustomers = customers.toArray(new Customer[customers.size()]);

        for (int i = 0; i<cloneOfCustomers.length;i++) {
            if (cloneOfCustomers[i].getCustomerId() == customerId) {
                customerToReturn = cloneOfCustomers[i];
            }
        }

        return customerToReturn;
    }
}
