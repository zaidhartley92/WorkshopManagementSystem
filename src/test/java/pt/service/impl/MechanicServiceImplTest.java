package pt.service.impl;

import pt.domain.Mechanic;
import pt.factory.MechanicFactory;
import pt.service.MechanicService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class MechanicServiceImplTest {

    private MechanicService service;
    private Mechanic mechanic;

    private Mechanic getSavedMechanic(){
        Set<Mechanic> savedMechanics = this.service.getAll();
        return savedMechanics.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = MechanicServiceImpl.getService();
        this.mechanic = MechanicFactory.getMechanic("Test Mechanic");
    }

    @Test
    public void create() {

        Mechanic testCreate = this.service.create(this.mechanic);
        Assert.assertSame(testCreate, this.mechanic);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Mechanic savedMechanic = getSavedMechanic();
        this.service.delete(savedMechanic.getMechanicId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another mechanic after deleting so that Read() has something to read.
        this.service.create(this.mechanic);

    }

    @Test
    public void read() {

        Mechanic savedMechanic = getSavedMechanic();
        String id = savedMechanic.getMechanicId();
        Mechanic readMechanic = this.service.read(id);
        Assert.assertEquals(savedMechanic, readMechanic);
    }

    @Test
    public void update() {

        Mechanic saved = getSavedMechanic();
        String id = saved.getMechanicId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Mechanic> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}
