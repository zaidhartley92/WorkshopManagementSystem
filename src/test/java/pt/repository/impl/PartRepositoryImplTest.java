package pt.repository.impl;

import org.junit.Test;

import pt.domain.Part;
import pt.factory.PartFactory;
import pt.repository.PartRepository;
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

public class PartRepositoryImplTest {

    @Autowired
    private PartRepository repository;
    private Part part;

    private Part getSavedPart(){
        Set<Part> savedParts = this.repository.getAll();
        return savedParts.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = PartRepositoryImpl.getRepository();
        this.part = PartFactory.getPart("Test Part");
    }

    @Test
    public void create() {

        Part testCreate = this.repository.create(this.part);
        Assert.assertSame(testCreate, this.part);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        Part savedPart = getSavedPart();
        this.repository.delete(savedPart.getPartId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another part after deleting so that Read() has something to read.
        this.repository.create(this.part);

    }

    @Test
    public void read() {

        Part savedPart = getSavedPart();
        String id = savedPart.getPartId();
        Part readPart = this.repository.read(id);
        Assert.assertEquals(savedPart, readPart);
    }

    @Test
    public void update() {

        Part saved = getSavedPart();
        String id = saved.getPartId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Part> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}