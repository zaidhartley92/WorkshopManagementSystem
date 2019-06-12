package pt.repository.impl;

import org.junit.Test;

import pt.domain.Engine;
import pt.factory.EngineFactory;
import pt.repository.EngineRepository;
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

public class EngineRepositoryImplTest {

    @Autowired
    private EngineRepository repository;
    private Engine engine;

    private Engine getSavedEngine(){
        Set<Engine> savedEngines = this.repository.getAll();
        return savedEngines.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = EngineRepositoryImpl.getRepository();
        this.engine = EngineFactory.getEngine("Test Engine");
    }

    @Test
    public void create() {

        Engine testCreate = this.repository.create(this.engine);
        Assert.assertSame(testCreate, this.engine);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        Engine savedEngine = getSavedEngine();
        this.repository.delete(savedEngine.getEngineId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another engine after deleting so that Read() has something to read.
        this.repository.create(this.engine);

    }

    @Test
    public void read() {

        Engine savedEngine = getSavedEngine();
        String id = savedEngine.getEngineId();
        Engine readEngine = this.repository.read(id);
        Assert.assertEquals(savedEngine, readEngine);
    }

    @Test
    public void update() {

        Engine saved = getSavedEngine();
        String id = saved.getEngineId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Engine> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}
