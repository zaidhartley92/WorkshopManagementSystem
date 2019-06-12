package pt.service.impl;

import pt.domain.Cleaner;
import pt.factory.CleanerFactory;
import pt.service.CleanerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class CleanerServiceImplTest {
    private CleanerService service;
    private Cleaner cleaner;

    private Cleaner getSavedCleaner(){
        Set<Cleaner> savedCleaners = this.service.getAll();
        return savedCleaners.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = CleanerServiceImpl.getService();
        this.cleaner = CleanerFactory.getCleaner("Test Cleaner");
    }

    @Test
    public void create() {

        Cleaner testCreate = this.service.create(this.cleaner);
        Assert.assertSame(testCreate, this.cleaner);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Cleaner savedCleaner = getSavedCleaner();
        this.service.delete(savedCleaner.getCleanerId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another cleaner after deleting so that Read() has something to read.
        this.service.create(this.cleaner);

    }

    @Test
    public void read() {

        Cleaner savedCleaner = getSavedCleaner();
        String id = savedCleaner.getCleanerId();
        Cleaner readCleaner = this.service.read(id);
        Assert.assertEquals(savedCleaner, readCleaner);
    }

    @Test
    public void update() {

        Cleaner saved = getSavedCleaner();
        String id = saved.getCleanerId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Cleaner> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}