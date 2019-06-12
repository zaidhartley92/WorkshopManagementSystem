package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Truck;

public class TruckFactoryTest {

    //Create
    @Test
    public void getTruck() {

        String name = "ADP 3";
        Truck truck = TruckFactory.getTruck(name);
        System.out.println(truck);
        Assert.assertNotNull(truck.getTruckId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Truck truck = TruckFactory.getTruck(name);
        System.out.println(truck);
        Assert.assertEquals("ADP 3", truck.getName());
    }

    //Update
    @Test
    public void updateTruck() {

        String name ="ADP 3";
        Truck truck = TruckFactory.getTruck(name);
        truck.setName("Fun");
        System.out.println(truck);
        Assert.assertEquals("Fun", truck.getName());
    }

    //Delete
    @Test
    public void deleteTruck() {

        String name = "ADP 3";
        Truck truck = TruckFactory.getTruck(name);
        truck = null;
        System.out.println(truck);
        Assert.assertNull(truck);
    }
}