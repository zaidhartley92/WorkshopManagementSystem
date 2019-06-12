package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Car;

public class CarFactoryTest {

    //Create
    @Test
    public void getCar() {

        String name = "ADP 3";
        Car car = CarFactory.getCar(name);
        System.out.println(car);
        Assert.assertNotNull(car.getCarId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Car car = CarFactory.getCar(name);
        System.out.println(car);
        Assert.assertEquals("ADP 3", car.getName());
    }

    //Update
    @Test
    public void updateCar() {

        String name ="ADP 3";
        Car car = CarFactory.getCar(name);
        car.setName("Fun");
        System.out.println(car);
        Assert.assertEquals("Fun", car.getName());
    }

    //Delete
    @Test
    public void deleteCar() {

        String name = "ADP 3";
        Car car = CarFactory.getCar(name);
        car = null;
        System.out.println(car);
        Assert.assertNull(car);
    }
}