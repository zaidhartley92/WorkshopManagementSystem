package pt.service.impl;

import pt.domain.Bike;
import pt.factory.BikeFactory;
import pt.service.BikeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class BikeServiceImplTest {

    @Autowired
    private BikeService service;
    private Bike bike;

    private Bike getSavedBike(){
        Set<Bike> savedBikes = this.service.getAll();
        return savedBikes.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = BikeServiceImpl.getService();
        this.bike = BikeFactory.getBike("Test Bike");
    }

    @Test
    public void create() {

        Bike testCreate = this.service.create(this.bike);
        Assert.assertSame(testCreate, this.bike);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Bike savedBike = getSavedBike();
        this.service.delete(savedBike.getBikeId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another bike after deleting so that Read() has something to read.
        this.service.create(this.bike);

    }

    @Test
    public void read() {

        Bike savedBike = getSavedBike();
        String id = savedBike.getBikeId();
        Bike readBike = this.service.read(id);
        Assert.assertEquals(savedBike, readBike);
    }

    @Test
    public void update() {

        Bike saved = getSavedBike();
        String id = saved.getBikeId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Bike> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}