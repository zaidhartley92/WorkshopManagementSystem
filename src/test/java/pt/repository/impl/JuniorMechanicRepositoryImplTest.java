package pt.repository.impl;

import org.junit.Test;

import pt.domain.JuniorMechanic;
import pt.factory.JuniorMechanicFactory;
import pt.repository.JuniorMechanicRepository;
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

public class JuniorMechanicRepositoryImplTest {

    @Autowired
    private JuniorMechanicRepository repository;
    private JuniorMechanic juniorMechanic;

    private JuniorMechanic getSavedJuniorMechanic(){
        Set<JuniorMechanic> savedJuniorMechanics = this.repository.getAll();
        return savedJuniorMechanics.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = JuniorMechanicRepositoryImpl.getRepository();
        this.juniorMechanic = JuniorMechanicFactory.getJuniorMechanic("Test JuniorMechanic");
    }

    @Test
    public void create() {

        JuniorMechanic testCreate = this.repository.create(this.juniorMechanic);
        Assert.assertSame(testCreate, this.juniorMechanic);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        JuniorMechanic savedJuniorMechanic = getSavedJuniorMechanic();
        this.repository.delete(savedJuniorMechanic.getJuniorMechanicId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another juniorMechanic after deleting so that Read() has something to read.
        this.repository.create(this.juniorMechanic);

    }

    @Test
    public void read() {

        JuniorMechanic savedJuniorMechanic = getSavedJuniorMechanic();
        String id = savedJuniorMechanic.getJuniorMechanicId();
        JuniorMechanic readJuniorMechanic = this.repository.read(id);
        Assert.assertEquals(savedJuniorMechanic, readJuniorMechanic);
    }

    @Test
    public void update() {

        JuniorMechanic saved = getSavedJuniorMechanic();
        String id = saved.getJuniorMechanicId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<JuniorMechanic> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}