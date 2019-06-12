package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Manager;

public class ManagerFactoryTest {

    //Create
    @Test
    public void getManager() {

        String name = "ADP 3";
        Manager manager = ManagerFactory.getManager(name);
        System.out.println(manager);
        Assert.assertNotNull(manager.getManagerId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Manager manager = ManagerFactory.getManager(name);
        System.out.println(manager);
        Assert.assertEquals("ADP 3", manager.getName());
    }

    //Update
    @Test
    public void updateManager() {

        String name ="ADP 3";
        Manager manager = ManagerFactory.getManager(name);
        manager.setName("Fun");
        System.out.println(manager);
        Assert.assertEquals("Fun", manager.getName());
    }

    //Delete
    @Test
    public void deleteManager() {

        String name = "ADP 3";
        Manager manager = ManagerFactory.getManager(name);
        manager = null;
        System.out.println(manager);
        Assert.assertNull(manager);
    }
}