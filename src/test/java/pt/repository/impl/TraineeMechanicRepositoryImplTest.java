package pt.repository.impl;

import org.junit.Test;

import pt.domain.TraineeMechanic;
import pt.factory.TraineeMechanicFactory;
import pt.repository.TraineeMechanicRepository;
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

public class TraineeMechanicRepositoryImplTest {

    @Autowired
    private TraineeMechanicRepository repository;
    private TraineeMechanic traineeMechanic;

    private TraineeMechanic getSavedTraineeMechanic(){
        Set<TraineeMechanic> savedTraineeMechanics = this.repository.getAll();
        return savedTraineeMechanics.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = TraineeMechanicRepositoryImpl.getRepository();
        this.traineeMechanic = TraineeMechanicFactory.getTraineeMechanic("Test TraineeMechanic");
    }

    @Test
    public void create() {

        TraineeMechanic testCreate = this.repository.create(this.traineeMechanic);
        Assert.assertSame(testCreate, this.traineeMechanic);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        TraineeMechanic savedTraineeMechanic = getSavedTraineeMechanic();
        this.repository.delete(savedTraineeMechanic.getTraineeMechanicId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another traineeMechanic after deleting so that Read() has something to read.
        this.repository.create(this.traineeMechanic);

    }

    @Test
    public void read() {

        TraineeMechanic savedTraineeMechanic = getSavedTraineeMechanic();
        String id = savedTraineeMechanic.getTraineeMechanicId();
        TraineeMechanic readTraineeMechanic = this.repository.read(id);
        Assert.assertEquals(savedTraineeMechanic, readTraineeMechanic);
    }

    @Test
    public void update() {

        TraineeMechanic saved = getSavedTraineeMechanic();
        String id = saved.getTraineeMechanicId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<TraineeMechanic> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}