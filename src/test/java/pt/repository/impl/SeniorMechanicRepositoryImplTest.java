package pt.repository.impl;

import org.junit.Test;

import pt.domain.SeniorMechanic;
import pt.factory.SeniorMechanicFactory;
import pt.repository.SeniorMechanicRepository;
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

public class SeniorMechanicRepositoryImplTest {

    @Autowired
    private SeniorMechanicRepository repository;
    private SeniorMechanic seniorMechanic;

    private SeniorMechanic getSavedSeniorMechanic(){
        Set<SeniorMechanic> savedSeniorMechanics = this.repository.getAll();
        return savedSeniorMechanics.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = SeniorMechanicRepositoryImpl.getRepository();
        this.seniorMechanic = SeniorMechanicFactory.getSeniorMechanic("Test SeniorMechanic");
    }

    @Test
    public void create() {

        SeniorMechanic testCreate = this.repository.create(this.seniorMechanic);
        Assert.assertSame(testCreate, this.seniorMechanic);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        SeniorMechanic savedSeniorMechanic = getSavedSeniorMechanic();
        this.repository.delete(savedSeniorMechanic.getSeniorMechanicId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another seniorMechanic after deleting so that Read() has something to read.
        this.repository.create(this.seniorMechanic);

    }

    @Test
    public void read() {

        SeniorMechanic savedSeniorMechanic = getSavedSeniorMechanic();
        String id = savedSeniorMechanic.getSeniorMechanicId();
        SeniorMechanic readSeniorMechanic = this.repository.read(id);
        Assert.assertEquals(savedSeniorMechanic, readSeniorMechanic);
    }

    @Test
    public void update() {

        SeniorMechanic saved = getSavedSeniorMechanic();
        String id = saved.getSeniorMechanicId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<SeniorMechanic> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}