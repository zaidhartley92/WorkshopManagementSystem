package pt.repository.impl;

import org.junit.Test;

import pt.domain.Bay;
import pt.factory.BayFactory;
import pt.repository.BayRepository;
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

public class BayRepositoryImplTest {

    @Autowired
    private BayRepository repository;
    private Bay bay;

    private Bay getSavedBay(){
        Set<Bay> savedBays = this.repository.getAll();
        return savedBays.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = BayRepositoryImpl.getRepository();
        this.bay = BayFactory.getBay("Test Bay");
    }

    @Test
    public void create() {

        Bay testCreate = this.repository.create(this.bay);
        Assert.assertSame(testCreate, this.bay);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        Bay savedBay = getSavedBay();
        this.repository.delete(savedBay.getBayId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another bay after deleting so that Read() has something to read.
        this.repository.create(this.bay);

    }

    @Test
    public void read() {

        Bay savedBay = getSavedBay();
        String id = savedBay.getBayId();
        Bay readBay = this.repository.read(id);
        Assert.assertEquals(savedBay, readBay);
    }

    @Test
    public void update() {

        Bay saved = getSavedBay();
        String id = saved.getBayId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Bay> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}