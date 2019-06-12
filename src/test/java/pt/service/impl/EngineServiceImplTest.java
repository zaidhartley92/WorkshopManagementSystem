package pt.service.impl;

import pt.domain.Engine;
import pt.factory.EngineFactory;
import pt.service.EngineService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class EngineServiceImplTest {
    private EngineService service;
    private Engine engine;

    private Engine getSavedEngine(){
        Set<Engine> savedEngines = this.service.getAll();
        return savedEngines.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = EngineServiceImpl.getService();
        this.engine = EngineFactory.getEngine("Test Engine");
    }

    @Test
    public void create() {

        Engine testCreate = this.service.create(this.engine);
        Assert.assertSame(testCreate, this.engine);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Engine savedEngine = getSavedEngine();
        this.service.delete(savedEngine.getEngineId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another engine after deleting so that Read() has something to read.
        this.service.create(this.engine);

    }

    @Test
    public void read() {

        Engine savedEngine = getSavedEngine();
        String id = savedEngine.getEngineId();
        Engine readEngine = this.service.read(id);
        Assert.assertEquals(savedEngine, readEngine);
    }

    @Test
    public void update() {

        Engine saved = getSavedEngine();
        String id = saved.getEngineId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Engine> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}
