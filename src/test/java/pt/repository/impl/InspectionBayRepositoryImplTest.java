package pt.repository.impl;

import org.junit.Test;

import pt.domain.InspectionBay;
import pt.factory.InspectionBayFactory;
import pt.repository.InspectionBayRepository;
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

public class InspectionBayRepositoryImplTest {

    @Autowired
    private InspectionBayRepository repository;
    private InspectionBay inspectionBay;

    private InspectionBay getSavedInspectionBay(){
        Set<InspectionBay> savedInspectionBays = this.repository.getAll();
        return savedInspectionBays.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = InspectionBayRepositoryImpl.getRepository();
        this.inspectionBay = InspectionBayFactory.getInspectionBay("Test InspectionBay");
    }

    @Test
    public void create() {

        InspectionBay testCreate = this.repository.create(this.inspectionBay);
        Assert.assertSame(testCreate, this.inspectionBay);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        InspectionBay savedInspectionBay = getSavedInspectionBay();
        this.repository.delete(savedInspectionBay.getInspectionBayId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another inspectionBay after deleting so that Read() has something to read.
        this.repository.create(this.inspectionBay);

    }

    @Test
    public void read() {

        InspectionBay savedInspectionBay = getSavedInspectionBay();
        String id = savedInspectionBay.getInspectionBayId();
        InspectionBay readInspectionBay = this.repository.read(id);
        Assert.assertEquals(savedInspectionBay, readInspectionBay);
    }

    @Test
    public void update() {

        InspectionBay saved = getSavedInspectionBay();
        String id = saved.getInspectionBayId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<InspectionBay> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}