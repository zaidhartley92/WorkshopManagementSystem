package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Engine;

public class EngineFactoryTest {

    //Create
    @Test
    public void getEngine() {

        String name = "ADP 3";
        Engine engine = EngineFactory.getEngine(name);
        System.out.println(engine);
        Assert.assertNotNull(engine.getEngineId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Engine engine = EngineFactory.getEngine(name);
        System.out.println(engine);
        Assert.assertEquals("ADP 3", engine.getName());
    }

    //Update
    @Test
    public void updateEngine() {

        String name ="ADP 3";
        Engine engine = EngineFactory.getEngine(name);
        engine.setName("Fun");
        System.out.println(engine);
        Assert.assertEquals("Fun", engine.getName());
    }

    //Delete
    @Test
    public void deleteEngine() {

        String name = "ADP 3";
        Engine engine = EngineFactory.getEngine(name);
        engine = null;
        System.out.println(engine);
        Assert.assertNull(engine);
    }
}