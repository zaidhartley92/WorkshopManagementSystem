package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Bike;

public class BikeFactoryTest {

    //Create
    @Test
    public void getBike() {

        String name = "ADP 3";
        Bike bike = BikeFactory.getBike(name);
        System.out.println(bike);
        Assert.assertNotNull(bike.getBikeId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Bike bike = BikeFactory.getBike(name);
        System.out.println(bike);
        Assert.assertEquals("ADP 3", bike.getName());
    }

    //Update
    @Test
    public void updateBike() {

        String name ="ADP 3";
        Bike bike = BikeFactory.getBike(name);
        bike.setName("Fun");
        System.out.println(bike);
        Assert.assertEquals("Fun", bike.getName());
    }

    //Delete
    @Test
    public void deleteBike() {

        String name = "ADP 3";
        Bike bike = BikeFactory.getBike(name);
        bike = null;
        System.out.println(bike);
        Assert.assertNull(bike);
    }
}