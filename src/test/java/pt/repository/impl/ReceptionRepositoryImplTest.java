package pt.repository.impl;

import org.junit.Test;

import pt.domain.Reception;
import pt.factory.ReceptionFactory;
import pt.repository.ReceptionRepository;
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

public class ReceptionRepositoryImplTest {

    @Autowired
    private ReceptionRepository repository;
    private Reception reception;

    private Reception getSavedSecretary(){
        Set<Reception> savedReceptions = this.repository.getAll();
        return savedReceptions.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = ReceptionRepositoryImpl.getRepository();
        this.reception = ReceptionFactory.getSecretary("Test Reception");
    }

    @Test
    public void create() {

        Reception testCreate = this.repository.create(this.reception);
        Assert.assertSame(testCreate, this.reception);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        Reception savedReception = getSavedSecretary();
        this.repository.delete(savedReception.getSecretaryId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another reception after deleting so that Read() has something to read.
        this.repository.create(this.reception);

    }

    @Test
    public void read() {

        Reception savedReception = getSavedSecretary();
        String id = savedReception.getSecretaryId();
        Reception readReception = this.repository.read(id);
        Assert.assertEquals(savedReception, readReception);
    }

    @Test
    public void update() {

        Reception saved = getSavedSecretary();
        String id = saved.getSecretaryId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Reception> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}