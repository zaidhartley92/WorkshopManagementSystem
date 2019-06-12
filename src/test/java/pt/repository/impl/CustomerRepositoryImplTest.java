package pt.repository.impl;

import org.junit.Test;

import pt.domain.Customer;
import pt.factory.CustomerFactory;
import pt.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@FixMethodOrder(MethodSorters.DEFAULT)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class CustomerRepositoryImplTest {

    @Autowired
    private CustomerRepository repository;
    private Customer customer;

    private Customer getSavedCustomer(){
        Set<Customer> savedCustomers = this.repository.getAll();
        return savedCustomers.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = CustomerRepositoryImpl.getRepository();
        this.customer = CustomerFactory.getCustomer("Test Customer");
    }

    @Test
    public void create() {

        Customer testCreate = this.repository.create(this.customer);
        Assert.assertSame(testCreate, this.customer);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        Customer savedCustomer = getSavedCustomer();
        this.repository.delete(savedCustomer.getCustomerId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another customer after deleting so that Read() has something to read.
        this.repository.create(this.customer);

    }

    @Test
    public void read() {

        Customer savedCustomer = getSavedCustomer();
        String id = savedCustomer.getCustomerId();
        Customer readCustomer = this.repository.read(id);
        Assert.assertEquals(savedCustomer, readCustomer);
    }

    @Test
    public void update() {

        Customer saved = getSavedCustomer();
        String id = saved.getCustomerId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Customer> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}