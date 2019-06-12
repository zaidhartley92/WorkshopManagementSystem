package pt.repository.impl;

import org.junit.Test;

import pt.domain.MechanicBay;
import pt.factory.MechanicBayFactory;
import pt.repository.MechanicBayRepository;
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

public class MechanicBayRepositoryImplTest {

    @Autowired
    private MechanicBayRepository repository;
    private MechanicBay mechanicBay;

    private MechanicBay getSavedMechanicBay(){
        Set<MechanicBay> savedMechanicBays = this.repository.getAll();
        return savedMechanicBays.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = MechanicBayRepositoryImpl.getRepository();
        this.mechanicBay = MechanicBayFactory.getMechanicBay("Test MechanicBay");
    }

    @Test
    public void create() {

        MechanicBay testCreate = this.repository.create(this.mechanicBay);
        Assert.assertSame(testCreate, this.mechanicBay);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        MechanicBay savedMechanicBay = getSavedMechanicBay();
        this.repository.delete(savedMechanicBay.getMechanicBayId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another mechanicBay after deleting so that Read() has something to read.
        this.repository.create(this.mechanicBay);

    }

    @Test
    public void read() {

        MechanicBay savedMechanicBay = getSavedMechanicBay();
        String id = savedMechanicBay.getMechanicBayId();
        MechanicBay readMechanicBay = this.repository.read(id);
        Assert.assertEquals(savedMechanicBay, readMechanicBay);
    }

    @Test
    public void update() {

        MechanicBay saved = getSavedMechanicBay();
        String id = saved.getMechanicBayId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<MechanicBay> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}