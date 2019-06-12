package pt.service.impl;

import pt.domain.Window;
import pt.factory.WindowFactory;
import pt.service.WindowService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class WindowServiceImplTest {
    private WindowService service;
    private Window window;

    private Window getSavedWindow(){
        Set<Window> savedWindows = this.service.getAll();
        return savedWindows.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = WindowServiceImpl.getService();
        this.window = WindowFactory.getWindow("Test Window");
    }

    @Test
    public void create() {

        Window testCreate = this.service.create(this.window);
        Assert.assertSame(testCreate, this.window);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Window savedWindow = getSavedWindow();
        this.service.delete(savedWindow.getWindowId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another window after deleting so that Read() has something to read.
        this.service.create(this.window);

    }

    @Test
    public void read() {

        Window savedWindow = getSavedWindow();
        String id = savedWindow.getWindowId();
        Window readWindow = this.service.read(id);
        Assert.assertEquals(savedWindow, readWindow);
    }

    @Test
    public void update() {

        Window saved = getSavedWindow();
        String id = saved.getWindowId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Window> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}