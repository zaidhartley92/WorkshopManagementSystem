package pt.service.impl;

import pt.domain.ParkingBay;
import pt.factory.ParkingBayFactory;
import pt.service.ParkingBayService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class ParkingBayServiceImplTest {

    private ParkingBayService service;
    private ParkingBay parkingBay;

    private ParkingBay getSavedParkingBay(){
        Set<ParkingBay> savedParkingBays = this.service.getAll();
        return savedParkingBays.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = ParkingBayServiceImpl.getService();
        this.parkingBay = ParkingBayFactory.getParkingBay("Test ParkingBay");
    }

    @Test
    public void create() {

        ParkingBay testCreate = this.service.create(this.parkingBay);
        Assert.assertSame(testCreate, this.parkingBay);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        ParkingBay savedParkingBay = getSavedParkingBay();
        this.service.delete(savedParkingBay.getParkingBayId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another parkingBay after deleting so that Read() has something to read.
        this.service.create(this.parkingBay);

    }

    @Test
    public void read() {

        ParkingBay savedParkingBay = getSavedParkingBay();
        String id = savedParkingBay.getParkingBayId();
        ParkingBay readParkingBay = this.service.read(id);
        Assert.assertEquals(savedParkingBay, readParkingBay);
    }

    @Test
    public void update() {

        ParkingBay saved = getSavedParkingBay();
        String id = saved.getParkingBayId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<ParkingBay> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}