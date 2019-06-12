package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Vehicle;

public class VehicleFactoryTest {

    //Create
    @Test
    public void getVehicle() {

        String name = "ADP 3";
        Vehicle vehicle = VehicleFactory.getVehicle(name);
        System.out.println(vehicle);
        Assert.assertNotNull(vehicle.getVehicleId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Vehicle vehicle = VehicleFactory.getVehicle(name);
        System.out.println(vehicle);
        Assert.assertEquals("ADP 3", vehicle.getName());
    }

    //Update
    @Test
    public void updateVehicle() {

        String name ="ADP 3";
        Vehicle vehicle = VehicleFactory.getVehicle(name);
        vehicle.setName("Fun");
        System.out.println(vehicle);
        Assert.assertEquals("Fun", vehicle.getName());
    }

    //Delete
    @Test
    public void deleteVehicle() {

        String name = "ADP 3";
        Vehicle vehicle = VehicleFactory.getVehicle(name);
        vehicle = null;
        System.out.println(vehicle);
        Assert.assertNull(vehicle);
    }
}