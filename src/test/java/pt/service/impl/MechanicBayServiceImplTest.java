package pt.service.impl;

import pt.domain.MechanicBay;
import pt.factory.MechanicBayFactory;
import pt.service.MechanicBayService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class MechanicBayServiceImplTest {
    private MechanicBayService service;
    private MechanicBay mechanicBay;

    private MechanicBay getSavedMechanicBay(){
        Set<MechanicBay> savedMechanicBays = this.service.getAll();
        return savedMechanicBays.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = MechanicBayServiceImpl.getService();
        this.mechanicBay = MechanicBayFactory.getMechanicBay("Test MechanicBay");
    }

    @Test
    public void create() {

        MechanicBay testCreate = this.service.create(this.mechanicBay);
        Assert.assertSame(testCreate, this.mechanicBay);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        MechanicBay savedMechanicBay = getSavedMechanicBay();
        this.service.delete(savedMechanicBay.getMechanicBayId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another mechanicBay after deleting so that Read() has something to read.
        this.service.create(this.mechanicBay);

    }

    @Test
    public void read() {

        MechanicBay savedMechanicBay = getSavedMechanicBay();
        String id = savedMechanicBay.getMechanicBayId();
        MechanicBay readMechanicBay = this.service.read(id);
        Assert.assertEquals(savedMechanicBay, readMechanicBay);
    }

    @Test
    public void update() {

        MechanicBay saved = getSavedMechanicBay();
        String id = saved.getMechanicBayId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<MechanicBay> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}