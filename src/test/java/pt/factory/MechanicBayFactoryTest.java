package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.MechanicBay;

public class MechanicBayFactoryTest {

    //Create
    @Test
    public void getMechanicBay() {

        String name = "ADP 3";
        MechanicBay mechanicBay = MechanicBayFactory.getMechanicBay(name);
        System.out.println(mechanicBay);
        Assert.assertNotNull(mechanicBay.getMechanicBayId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        MechanicBay mechanicBay = MechanicBayFactory.getMechanicBay(name);
        System.out.println(mechanicBay);
        Assert.assertEquals("ADP 3", mechanicBay.getName());
    }

    //Update
    @Test
    public void updateMechanicBay() {

        String name ="ADP 3";
        MechanicBay mechanicBay = MechanicBayFactory.getMechanicBay(name);
        mechanicBay.setName("Fun");
        System.out.println(mechanicBay);
        Assert.assertEquals("Fun", mechanicBay.getName());
    }

    //Delete
    @Test
    public void deleteMechanicBay() {

        String name = "ADP 3";
        MechanicBay mechanicBay = MechanicBayFactory.getMechanicBay(name);
        mechanicBay = null;
        System.out.println(mechanicBay);
        Assert.assertNull(mechanicBay);
    }
}