package pt.service.impl;

import pt.domain.Manager;
import pt.factory.ManagerFactory;
import pt.service.ManagerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class ManagerServiceImplTest {

    private ManagerService service;
    private Manager manager;

    private Manager getSavedManager(){
        Set<Manager> savedManagers = this.service.getAll();
        return savedManagers.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = ManagerServiceImpl.getService();
        this.manager = ManagerFactory.getManager("Test Manager");
    }

    @Test
    public void create() {

        Manager testCreate = this.service.create(this.manager);
        Assert.assertSame(testCreate, this.manager);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Manager savedManager = getSavedManager();
        this.service.delete(savedManager.getManagerId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another manager after deleting so that Read() has something to read.
        this.service.create(this.manager);

    }

    @Test
    public void read() {

        Manager savedManager = getSavedManager();
        String id = savedManager.getManagerId();
        Manager readManager = this.service.read(id);
        Assert.assertEquals(savedManager, readManager);
    }

    @Test
    public void update() {

        Manager saved = getSavedManager();
        String id = saved.getManagerId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Manager> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}