package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Mechanic;

public class MechanicFactoryTest {

    //Create
    @Test
    public void getMechanic() {

        String name = "ADP 3";
        Mechanic mechanic = MechanicFactory.getMechanic(name);
        System.out.println(mechanic);
        Assert.assertNotNull(mechanic.getMechanicId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Mechanic mechanic = MechanicFactory.getMechanic(name);
        System.out.println(mechanic);
        Assert.assertEquals("ADP 3", mechanic.getName());
    }

    //Update
    @Test
    public void updateMechanic() {

        String name ="ADP 3";
        Mechanic mechanic = MechanicFactory.getMechanic(name);
        mechanic.setName("Fun");
        System.out.println(mechanic);
        Assert.assertEquals("Fun", mechanic.getName());
    }

    //Delete
    @Test
    public void deleteMechanic() {

        String name = "ADP 3";
        Mechanic mechanic = MechanicFactory.getMechanic(name);
        mechanic = null;
        System.out.println(mechanic);
        Assert.assertNull(mechanic);
    }
}