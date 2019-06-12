package pt.service.impl;

import pt.service.BayService;
import org.junit.Test;

import pt.domain.Bay;
import pt.factory.BayFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class BayServiceImplTest {

    private BayService service;
    private Bay bay;

    private Bay getSavedBay(){
        Set<Bay> savedBays = this.service.getAll();
        return savedBays.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = BayServiceImpl.getService();
        this.bay = BayFactory.getBay("Test Bay");
    }

    @Test
    public void create() {

        Bay testCreate = this.service.create(this.bay);
        Assert.assertSame(testCreate, this.bay);

    }

    @Test
    public void update() {
        Bay saved = getSavedBay();
        String id = saved.getBayId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());
    }

    @Test
    public void delete() {
        int startingSize = this.service.getAll().size();
        Bay savedBay = getSavedBay();
        this.service.delete(savedBay.getBayId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another bay after deleting so that Read() has something to read.
        this.service.create(this.bay);
    }

    @Test
    public void read() {
        Bay savedBay = getSavedBay();
        String id = savedBay.getBayId();
        Bay readBay = this.service.read(id);
        Assert.assertEquals(savedBay, readBay);
    }

    @Test
    public void getAll() {
        Set<Bay> all = this.service.getAll();
        Assert.assertNotNull(all);
    }

}