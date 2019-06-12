package pt.service.impl;

import pt.domain.Part;
import pt.factory.PartFactory;
import pt.service.PartService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class PartServiceImplTest {

    private PartService service;
    private Part part;

    private Part getSavedPart(){
        Set<Part> savedParts = this.service.getAll();
        return savedParts.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = PartServiceImpl.getService();
        this.part = PartFactory.getPart("Test Part");
    }

    @Test
    public void create() {

        Part testCreate = this.service.create(this.part);
        Assert.assertSame(testCreate, this.part);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Part savedPart = getSavedPart();
        this.service.delete(savedPart.getPartId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another part after deleting so that Read() has something to read.
        this.service.create(this.part);

    }

    @Test
    public void read() {

        Part savedPart = getSavedPart();
        String id = savedPart.getPartId();
        Part readPart = this.service.read(id);
        Assert.assertEquals(savedPart, readPart);
    }

    @Test
    public void update() {

        Part saved = getSavedPart();
        String id = saved.getPartId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Part> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}