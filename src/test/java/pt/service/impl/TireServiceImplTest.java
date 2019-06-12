package pt.service.impl;

import pt.domain.Tire;
import pt.factory.TireFactory;
import pt.service.TireService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class TireServiceImplTest {
    private TireService service;
    private Tire tire;

    private Tire getSavedTire(){
        Set<Tire> savedTires = this.service.getAll();
        return savedTires.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = TireServiceImpl.getService();
        this.tire = TireFactory.getTire("Test Tire");
    }

    @Test
    public void create() {

        Tire testCreate = this.service.create(this.tire);
        Assert.assertSame(testCreate, this.tire);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Tire savedTire = getSavedTire();
        this.service.delete(savedTire.getTireId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another tire after deleting so that Read() has something to read.
        this.service.create(this.tire);

    }

    @Test
    public void read() {

        Tire savedTire = getSavedTire();
        String id = savedTire.getTireId();
        Tire readTire = this.service.read(id);
        Assert.assertEquals(savedTire, readTire);
    }

    @Test
    public void update() {

        Tire saved = getSavedTire();
        String id = saved.getTireId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Tire> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}