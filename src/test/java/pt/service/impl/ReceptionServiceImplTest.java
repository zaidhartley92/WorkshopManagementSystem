package pt.service.impl;

import pt.domain.Reception;
import pt.factory.ReceptionFactory;
import pt.service.ReceptionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class ReceptionServiceImplTest {

    private ReceptionService service;
    private Reception reception;

    private Reception getSavedSecretary(){
        Set<Reception> savedReceptions = this.service.getAll();
        return savedReceptions.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = ReceptionServiceImpl.getService();
        this.reception = ReceptionFactory.getSecretary("Test Reception");
    }

    @Test
    public void create() {

        Reception testCreate = this.service.create(this.reception);
        Assert.assertSame(testCreate, this.reception);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Reception savedReception = getSavedSecretary();
        this.service.delete(savedReception.getSecretaryId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another reception after deleting so that Read() has something to read.
        this.service.create(this.reception);

    }

    @Test
    public void read() {

        Reception savedReception = getSavedSecretary();
        String id = savedReception.getSecretaryId();
        Reception readReception = this.service.read(id);
        Assert.assertEquals(savedReception, readReception);
    }

    @Test
    public void update() {

        Reception saved = getSavedSecretary();
        String id = saved.getSecretaryId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Reception> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}