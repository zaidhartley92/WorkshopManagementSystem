package pt.service.impl;

import pt.domain.InspectionBay;
import pt.factory.InspectionBayFactory;
import pt.service.InspectionBayService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class InspectionBayServiceImplTest {
    private InspectionBayService service;
    private InspectionBay inspectionBay;

    private InspectionBay getSavedInspectionBay(){
        Set<InspectionBay> savedInspectionBays = this.service.getAll();
        return savedInspectionBays.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = InspectionBayServiceImpl.getService();
        this.inspectionBay = InspectionBayFactory.getInspectionBay("Test InspectionBay");
    }

    @Test
    public void create() {

        InspectionBay testCreate = this.service.create(this.inspectionBay);
        Assert.assertSame(testCreate, this.inspectionBay);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        InspectionBay savedInspectionBay = getSavedInspectionBay();
        this.service.delete(savedInspectionBay.getInspectionBayId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another inspectionBay after deleting so that Read() has something to read.
        this.service.create(this.inspectionBay);

    }

    @Test
    public void read() {

        InspectionBay savedInspectionBay = getSavedInspectionBay();
        String id = savedInspectionBay.getInspectionBayId();
        InspectionBay readInspectionBay = this.service.read(id);
        Assert.assertEquals(savedInspectionBay, readInspectionBay);
    }

    @Test
    public void update() {

        InspectionBay saved = getSavedInspectionBay();
        String id = saved.getInspectionBayId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<InspectionBay> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}