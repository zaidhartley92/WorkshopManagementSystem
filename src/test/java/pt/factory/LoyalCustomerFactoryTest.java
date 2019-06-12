package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.LoyalCustomer;

public class LoyalCustomerFactoryTest {

    //Create
    @Test
    public void getLoyalCustomer() {

        String name = "ADP 3";
        LoyalCustomer loyalCustomer = LoyalCustomerFactory.getLoyalCustomer(name);
        System.out.println(loyalCustomer);
        Assert.assertNotNull(loyalCustomer.getLoyalCustomerId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        LoyalCustomer loyalCustomer = LoyalCustomerFactory.getLoyalCustomer(name);
        System.out.println(loyalCustomer);
        Assert.assertEquals("ADP 3", loyalCustomer.getName());
    }

    //Update
    @Test
    public void updateLoyalCustomer() {

        String name ="ADP 3";
        LoyalCustomer loyalCustomer = LoyalCustomerFactory.getLoyalCustomer(name);
        loyalCustomer.setName("Fun");
        System.out.println(loyalCustomer);
        Assert.assertEquals("Fun", loyalCustomer.getName());
    }

    //Delete
    @Test
    public void deleteLoyalCustomer() {

        String name = "ADP 3";
        LoyalCustomer loyalCustomer = LoyalCustomerFactory.getLoyalCustomer(name);
        loyalCustomer = null;
        System.out.println(loyalCustomer);
        Assert.assertNull(loyalCustomer);
    }
}