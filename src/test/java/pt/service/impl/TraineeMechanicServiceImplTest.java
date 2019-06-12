package pt.service.impl;

import pt.domain.TraineeMechanic;
import pt.factory.TraineeMechanicFactory;
import pt.service.TraineeMechanicService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class TraineeMechanicServiceImplTest {

    private TraineeMechanicService service;
    private TraineeMechanic traineeMechanic;

    private TraineeMechanic getSavedTraineeMechanic(){
        Set<TraineeMechanic> savedTraineeMechanics = this.service.getAll();
        return savedTraineeMechanics.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = TraineeMechanicServiceImpl.getService();
        this.traineeMechanic = TraineeMechanicFactory.getTraineeMechanic("Test TraineeMechanic");
    }

    @Test
    public void create() {

        TraineeMechanic testCreate = this.service.create(this.traineeMechanic);
        Assert.assertSame(testCreate, this.traineeMechanic);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        TraineeMechanic savedTraineeMechanic = getSavedTraineeMechanic();
        this.service.delete(savedTraineeMechanic.getTraineeMechanicId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another traineeMechanic after deleting so that Read() has something to read.
        this.service.create(this.traineeMechanic);

    }

    @Test
    public void read() {

        TraineeMechanic savedTraineeMechanic = getSavedTraineeMechanic();
        String id = savedTraineeMechanic.getTraineeMechanicId();
        TraineeMechanic readTraineeMechanic = this.service.read(id);
        Assert.assertEquals(savedTraineeMechanic, readTraineeMechanic);
    }

    @Test
    public void update() {

        TraineeMechanic saved = getSavedTraineeMechanic();
        String id = saved.getTraineeMechanicId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<TraineeMechanic> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}