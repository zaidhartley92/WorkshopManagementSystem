package pt.service.impl;

import pt.domain.JuniorMechanic;
import pt.factory.JuniorMechanicFactory;
import pt.service.JuniorMechanicService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class JuniorMechanicServiceImplTest {

    private JuniorMechanicService service;
    private JuniorMechanic juniorMechanic;

    private JuniorMechanic getSavedJuniorMechanic(){
        Set<JuniorMechanic> savedJuniorMechanics = this.service.getAll();
        return savedJuniorMechanics.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = JuniorMechanicServiceImpl.getService();
        this.juniorMechanic = JuniorMechanicFactory.getJuniorMechanic("Test JuniorMechanic");
    }

    @Test
    public void create() {

        JuniorMechanic testCreate = this.service.create(this.juniorMechanic);
        Assert.assertSame(testCreate, this.juniorMechanic);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        JuniorMechanic savedJuniorMechanic = getSavedJuniorMechanic();
        this.service.delete(savedJuniorMechanic.getJuniorMechanicId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another juniorMechanic after deleting so that Read() has something to read.
        this.service.create(this.juniorMechanic);

    }

    @Test
    public void read() {

        JuniorMechanic savedJuniorMechanic = getSavedJuniorMechanic();
        String id = savedJuniorMechanic.getJuniorMechanicId();
        JuniorMechanic readJuniorMechanic = this.service.read(id);
        Assert.assertEquals(savedJuniorMechanic, readJuniorMechanic);
    }

    @Test
    public void update() {

        JuniorMechanic saved = getSavedJuniorMechanic();
        String id = saved.getJuniorMechanicId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<JuniorMechanic> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}