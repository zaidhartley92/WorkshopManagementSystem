package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Customer;

public class CustomerFactoryTest {

    //Create
    @Test
    public void getCustomer() {

        String name = "ADP 3";
        Customer customer = CustomerFactory.getCustomer(name);
        System.out.println(customer);
        Assert.assertNotNull(customer.getCustomerId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Customer customer = CustomerFactory.getCustomer(name);
        System.out.println(customer);
        Assert.assertEquals("ADP 3", customer.getName());
    }

    //Update
    @Test
    public void updateCustomer() {

        String name ="ADP 3";
        Customer customer = CustomerFactory.getCustomer(name);
        customer.setName("Fun");
        System.out.println(customer);
        Assert.assertEquals("Fun", customer.getName());
    }

    //Delete
    @Test
    public void deleteCustomer() {

        String name = "ADP 3";
        Customer customer = CustomerFactory.getCustomer(name);
        customer = null;
        System.out.println(customer);
        Assert.assertNull(customer);
    }
}