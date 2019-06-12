package pt.service.impl;

import pt.domain.Customer;
import pt.factory.CustomerFactory;
import pt.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class CustomerServiceImplTest {

    private CustomerService service;
    private Customer customer;

    private Customer getSavedCustomer(){
        Set<Customer> savedCustomers = this.service.getAll();
        return savedCustomers.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = CustomerServiceImpl.getService();
        this.customer = CustomerFactory.getCustomer("Test Customer");
    }

    @Test
    public void create() {

        Customer testCreate = this.service.create(this.customer);
        Assert.assertSame(testCreate, this.customer);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Customer savedCustomer = getSavedCustomer();
        this.service.delete(savedCustomer.getCustomerId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another customer after deleting so that Read() has something to read.
        this.service.create(this.customer);

    }

    @Test
    public void read() {

        Customer savedCustomer = getSavedCustomer();
        String id = savedCustomer.getCustomerId();
        Customer readCustomer = this.service.read(id);
        Assert.assertEquals(savedCustomer, readCustomer);
    }

    @Test
    public void update() {

        Customer saved = getSavedCustomer();
        String id = saved.getCustomerId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Customer> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}