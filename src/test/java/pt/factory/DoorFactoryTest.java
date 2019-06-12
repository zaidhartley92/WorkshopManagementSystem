package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Door;

public class DoorFactoryTest {

    //Create
    @Test
    public void getDoor() {

        String name = "ADP 3";
        Door door = DoorFactory.getDoor(name);
        System.out.println(door);
        Assert.assertNotNull(door.getDoorId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Door door = DoorFactory.getDoor(name);
        System.out.println(door);
        Assert.assertEquals("ADP 3", door.getName());
    }

    //Update
    @Test
    public void updateDoor() {

        String name ="ADP 3";
        Door door = DoorFactory.getDoor(name);
        door.setName("Fun");
        System.out.println(door);
        Assert.assertEquals("Fun", door.getName());
    }

    //Delete
    @Test
    public void deleteDoor() {

        String name = "ADP 3";
        Door door = DoorFactory.getDoor(name);
        door = null;
        System.out.println(door);
        Assert.assertNull(door);
    }
}