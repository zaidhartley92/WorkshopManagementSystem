package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Reception;

public class ReceptionFactoryTest {

    //Create
    @Test
    public void getSecretary() {

        String name = "ADP 3";
        Reception reception = ReceptionFactory.getSecretary(name);
        System.out.println(reception);
        Assert.assertNotNull(reception.getSecretaryId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Reception reception = ReceptionFactory.getSecretary(name);
        System.out.println(reception);
        Assert.assertEquals("ADP 3", reception.getName());
    }

    //Update
    @Test
    public void updateSecretary() {

        String name ="ADP 3";
        Reception reception = ReceptionFactory.getSecretary(name);
        reception.setName("Fun");
        System.out.println(reception);
        Assert.assertEquals("Fun", reception.getName());
    }

    //Delete
    @Test
    public void deleteSecretary() {

        String name = "ADP 3";
        Reception reception = ReceptionFactory.getSecretary(name);
        reception = null;
        System.out.println(reception);
        Assert.assertNull(reception);
    }
}