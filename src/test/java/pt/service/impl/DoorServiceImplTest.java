package pt.service.impl;

import pt.domain.Door;
import pt.factory.DoorFactory;
import pt.service.DoorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class DoorServiceImplTest {
    private DoorService service;
    private Door door;

    private Door getSavedDoor(){
        Set<Door> savedDoors = this.service.getAll();
        return savedDoors.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = DoorServiceImpl.getService();
        this.door = DoorFactory.getDoor("Test Door");
    }

    @Test
    public void create() {

        Door testCreate = this.service.create(this.door);
        Assert.assertSame(testCreate, this.door);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Door savedDoor = getSavedDoor();
        this.service.delete(savedDoor.getDoorId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another door after deleting so that Read() has something to read.
        this.service.create(this.door);

    }

    @Test
    public void read() {

        Door savedDoor = getSavedDoor();
        String id = savedDoor.getDoorId();
        Door readDoor = this.service.read(id);
        Assert.assertEquals(savedDoor, readDoor);
    }

    @Test
    public void update() {

        Door saved = getSavedDoor();
        String id = saved.getDoorId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Door> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}