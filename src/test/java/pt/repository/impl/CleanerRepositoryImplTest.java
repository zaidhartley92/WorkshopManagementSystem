package pt.repository.impl;

import org.junit.Test;

import pt.domain.Cleaner;
import pt.factory.CleanerFactory;
import pt.repository.CleanerRepository;
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

public class CleanerRepositoryImplTest {

    @Autowired
    private CleanerRepository repository;
    private Cleaner cleaner;

    private Cleaner getSavedCleaner(){
        Set<Cleaner> savedCleaners = this.repository.getAll();
        return savedCleaners.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = CleanerRepositoryImpl.getRepository();
        this.cleaner = CleanerFactory.getCleaner("Test Cleaner");
    }

    @Test
    public void create() {

        Cleaner testCreate = this.repository.create(this.cleaner);
        Assert.assertSame(testCreate, this.cleaner);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        Cleaner savedCleaner = getSavedCleaner();
        this.repository.delete(savedCleaner.getCleanerId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another cleaner after deleting so that Read() has something to read.
        this.repository.create(this.cleaner);

    }

    @Test
    public void read() {

        Cleaner savedCleaner = getSavedCleaner();
        String id = savedCleaner.getCleanerId();
        Cleaner readCleaner = this.repository.read(id);
        Assert.assertEquals(savedCleaner, readCleaner);
    }

    @Test
    public void update() {

        Cleaner saved = getSavedCleaner();
        String id = saved.getCleanerId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Cleaner> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}