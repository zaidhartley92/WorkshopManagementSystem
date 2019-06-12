package pt.factory;

import pt.domain.Customer;
import pt.util.Misc;

public class CustomerFactory {
    public static Customer getCustomer(String Name) {
        return new Customer.Builder().customerId(Misc.generateId())
                .name(Name)
                .build();
    }

}
