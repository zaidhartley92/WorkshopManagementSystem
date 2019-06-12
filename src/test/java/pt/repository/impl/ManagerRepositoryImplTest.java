package pt.repository.impl;

import org.junit.Test;

import pt.domain.Manager;
import pt.factory.ManagerFactory;
import pt.repository.ManagerRepository;
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

public class ManagerRepositoryImplTest {

    @Autowired
    private ManagerRepository repository;
    private Manager manager;

    private Manager getSavedManager(){
        Set<Manager> savedManagers = this.repository.getAll();
        return savedManagers.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = ManagerRepositoryImpl.getRepository();
        this.manager = ManagerFactory.getManager("Test Manager");
    }

    @Test
    public void create() {

        Manager testCreate = this.repository.create(this.manager);
        Assert.assertSame(testCreate, this.manager);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        Manager savedManager = getSavedManager();
        this.repository.delete(savedManager.getManagerId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another manager after deleting so that Read() has something to read.
        this.repository.create(this.manager);

    }

    @Test
    public void read() {

        Manager savedManager = getSavedManager();
        String id = savedManager.getManagerId();
        Manager readManager = this.repository.read(id);
        Assert.assertEquals(savedManager, readManager);
    }

    @Test
    public void update() {

        Manager saved = getSavedManager();
        String id = saved.getManagerId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Manager> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}