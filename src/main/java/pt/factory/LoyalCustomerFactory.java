package pt.factory;

import pt.domain.LoyalCustomer;
import pt.util.Misc;

public class LoyalCustomerFactory {
    public static LoyalCustomer getLoyalCustomer(String Name) {
        return new LoyalCustomer.Builder().loyalCustomerId(Misc.generateId())
                .name(Name)
                .build();
    }

}