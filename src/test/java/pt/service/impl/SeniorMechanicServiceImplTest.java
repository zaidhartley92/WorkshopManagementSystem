package pt.service.impl;

import pt.domain.SeniorMechanic;
import pt.factory.SeniorMechanicFactory;
import pt.service.SeniorMechanicService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class SeniorMechanicServiceImplTest {
    private SeniorMechanicService service;
    private SeniorMechanic seniorMechanic;

    private SeniorMechanic getSavedSeniorMechanic(){
        Set<SeniorMechanic> savedSeniorMechanics = this.service.getAll();
        return savedSeniorMechanics.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = SeniorMechanicServiceImpl.getService();
        this.seniorMechanic = SeniorMechanicFactory.getSeniorMechanic("Test SeniorMechanic");
    }

    @Test
    public void create() {

        SeniorMechanic testCreate = this.service.create(this.seniorMechanic);
        Assert.assertSame(testCreate, this.seniorMechanic);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        SeniorMechanic savedSeniorMechanic = getSavedSeniorMechanic();
        this.service.delete(savedSeniorMechanic.getSeniorMechanicId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another seniorMechanic after deleting so that Read() has something to read.
        this.service.create(this.seniorMechanic);

    }

    @Test
    public void read() {

        SeniorMechanic savedSeniorMechanic = getSavedSeniorMechanic();
        String id = savedSeniorMechanic.getSeniorMechanicId();
        SeniorMechanic readSeniorMechanic = this.service.read(id);
        Assert.assertEquals(savedSeniorMechanic, readSeniorMechanic);
    }

    @Test
    public void update() {

        SeniorMechanic saved = getSavedSeniorMechanic();
        String id = saved.getSeniorMechanicId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<SeniorMechanic> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}