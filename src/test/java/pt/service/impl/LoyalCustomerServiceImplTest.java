package pt.service.impl;

import pt.domain.LoyalCustomer;
import pt.factory.LoyalCustomerFactory;
import pt.service.LoyalCustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class LoyalCustomerServiceImplTest {

    private LoyalCustomerService service;
    private LoyalCustomer loyalCustomer;

    private LoyalCustomer getSavedLoyalCustomer(){
        Set<LoyalCustomer> savedLoyalCustomers = this.service.getAll();
        return savedLoyalCustomers.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = LoyalCustomerServiceImpl.getService();
        this.loyalCustomer = LoyalCustomerFactory.getLoyalCustomer("Test LoyalCustomer");
    }

    @Test
    public void create() {

        LoyalCustomer testCreate = this.service.create(this.loyalCustomer);
        Assert.assertSame(testCreate, this.loyalCustomer);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        LoyalCustomer savedLoyalCustomer = getSavedLoyalCustomer();
        this.service.delete(savedLoyalCustomer.getLoyalCustomerId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another loyalCustomer after deleting so that Read() has something to read.
        this.service.create(this.loyalCustomer);

    }

    @Test
    public void read() {

        LoyalCustomer savedLoyalCustomer = getSavedLoyalCustomer();
        String id = savedLoyalCustomer.getLoyalCustomerId();
        LoyalCustomer readLoyalCustomer = this.service.read(id);
        Assert.assertEquals(savedLoyalCustomer, readLoyalCustomer);
    }

    @Test
    public void update() {

        LoyalCustomer saved = getSavedLoyalCustomer();
        String id = saved.getLoyalCustomerId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<LoyalCustomer> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}