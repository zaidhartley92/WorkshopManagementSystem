package pt.repository.impl;

import org.junit.Test;

import pt.domain.Window;
import pt.factory.WindowFactory;
import pt.repository.WindowRepository;
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

public class WindowRepositoryImplTest {

    @Autowired
    private WindowRepository repository;
    private Window window;

    private Window getSavedWindow(){
        Set<Window> savedWindows = this.repository.getAll();
        return savedWindows.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = WindowRepositoryImpl.getRepository();
        this.window = WindowFactory.getWindow("Test Window");
    }

    @Test
    public void create() {

        Window testCreate = this.repository.create(this.window);
        Assert.assertSame(testCreate, this.window);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        Window savedWindow = getSavedWindow();
        this.repository.delete(savedWindow.getWindowId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another window after deleting so that Read() has something to read.
        this.repository.create(this.window);

    }

    @Test
    public void read() {

        Window savedWindow = getSavedWindow();
        String id = savedWindow.getWindowId();
        Window readWindow = this.repository.read(id);
        Assert.assertEquals(savedWindow, readWindow);
    }

    @Test
    public void update() {

        Window saved = getSavedWindow();
        String id = saved.getWindowId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Window> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}