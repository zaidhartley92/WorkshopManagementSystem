package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.JuniorMechanic;

public class JuniorMechanicFactoryTest {

    //Create
    @Test
    public void getJuniorMechanic() {

        String name = "ADP 3";
        JuniorMechanic juniorMechanic = JuniorMechanicFactory.getJuniorMechanic(name);
        System.out.println(juniorMechanic);
        Assert.assertNotNull(juniorMechanic.getJuniorMechanicId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        JuniorMechanic juniorMechanic = JuniorMechanicFactory.getJuniorMechanic(name);
        System.out.println(juniorMechanic);
        Assert.assertEquals("ADP 3", juniorMechanic.getName());
    }

    //Update
    @Test
    public void updateJuniorMechanic() {

        String name ="ADP 3";
        JuniorMechanic juniorMechanic = JuniorMechanicFactory.getJuniorMechanic(name);
        juniorMechanic.setName("Fun");
        System.out.println(juniorMechanic);
        Assert.assertEquals("Fun", juniorMechanic.getName());
    }

    //Delete
    @Test
    public void deleteJuniorMechanic() {

        String name = "ADP 3";
        JuniorMechanic juniorMechanic = JuniorMechanicFactory.getJuniorMechanic(name);
        juniorMechanic = null;
        System.out.println(juniorMechanic);
        Assert.assertNull(juniorMechanic);
    }
}