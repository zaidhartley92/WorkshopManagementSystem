package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Cleaner;

public class CleanerFactoryTest {

    //Create
    @Test
    public void getCleaner() {

        String name = "ADP 3";
        Cleaner cleaner = CleanerFactory.getCleaner(name);
        System.out.println(cleaner);
        Assert.assertNotNull(cleaner.getCleanerId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Cleaner cleaner = CleanerFactory.getCleaner(name);
        System.out.println(cleaner);
        Assert.assertEquals("ADP 3", cleaner.getName());
    }

    //Update
    @Test
    public void updateCleaner() {

        String name ="ADP 3";
        Cleaner cleaner = CleanerFactory.getCleaner(name);
        cleaner.setName("Fun");
        System.out.println(cleaner);
        Assert.assertEquals("Fun", cleaner.getName());
    }

    //Delete
    @Test
    public void deleteCleaner() {

        String name = "ADP 3";
        Cleaner cleaner = CleanerFactory.getCleaner(name);
        cleaner = null;
        System.out.println(cleaner);
        Assert.assertNull(cleaner);
    }
}