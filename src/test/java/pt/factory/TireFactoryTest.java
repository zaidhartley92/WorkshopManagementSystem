package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Tire;

public class TireFactoryTest {

    //Create
    @Test
    public void getTire() {

        String name = "ADP 3";
        Tire tire = TireFactory.getTire(name);
        System.out.println(tire);
        Assert.assertNotNull(tire.getTireId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Tire tire = TireFactory.getTire(name);
        System.out.println(tire);
        Assert.assertEquals("ADP 3", tire.getName());
    }

    //Update
    @Test
    public void updateTire() {

        String name ="ADP 3";
        Tire tire = TireFactory.getTire(name);
        tire.setName("Fun");
        System.out.println(tire);
        Assert.assertEquals("Fun", tire.getName());
    }

    //Delete
    @Test
    public void deleteTire() {

        String name = "ADP 3";
        Tire tire = TireFactory.getTire(name);
        tire = null;
        System.out.println(tire);
        Assert.assertNull(tire);
    }
}