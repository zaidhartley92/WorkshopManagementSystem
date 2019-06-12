package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Window;

public class WindowFactoryTest {

    //Create
    @Test
    public void getWindow() {

        String name = "ADP 3";
        Window window = WindowFactory.getWindow(name);
        System.out.println(window);
        Assert.assertNotNull(window.getWindowId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Window window = WindowFactory.getWindow(name);
        System.out.println(window);
        Assert.assertEquals("ADP 3", window.getName());
    }

    //Update
    @Test
    public void updateWindow() {

        String name ="ADP 3";
        Window window = WindowFactory.getWindow(name);
        window.setName("Fun");
        System.out.println(window);
        Assert.assertEquals("Fun", window.getName());
    }

    //Delete
    @Test
    public void deleteWindow() {

        String name = "ADP 3";
        Window window = WindowFactory.getWindow(name);
        window = null;
        System.out.println(window);
        Assert.assertNull(window);
    }
}
