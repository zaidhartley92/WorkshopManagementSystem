package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Bay;

public class BayFactoryTest {

    //Create
    @Test
    public void getBay() {

        String name = "ADP 3";
        Bay bay = BayFactory.getBay(name);
        System.out.println(bay);
        Assert.assertNotNull(bay.getBayId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Bay bay = BayFactory.getBay(name);
        System.out.println(bay);
        Assert.assertEquals("ADP 3", bay.getName());
    }

    //Update
    @Test
    public void updateBay() {

        String name ="ADP 3";
        Bay bay = BayFactory.getBay(name);
        bay.setName("Fun");
        System.out.println(bay);
        Assert.assertEquals("Fun", bay.getName());
    }

    //Delete
    @Test
    public void deleteBay() {

        String name = "ADP 3";
        Bay bay = BayFactory.getBay(name);
        bay = null;
        System.out.println(bay);
        Assert.assertNull(bay);
    }
}