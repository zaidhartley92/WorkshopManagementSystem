package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.InspectionBay;

public class InspectionBayFactoryTest {

    //Create
    @Test
    public void getInspectionBay() {

        String name = "ADP 3";
        InspectionBay inspectionBay = InspectionBayFactory.getInspectionBay(name);
        System.out.println(inspectionBay);
        Assert.assertNotNull(inspectionBay.getInspectionBayId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        InspectionBay inspectionBay = InspectionBayFactory.getInspectionBay(name);
        System.out.println(inspectionBay);
        Assert.assertEquals("ADP 3", inspectionBay.getName());
    }

    //Update
    @Test
    public void updateInspectionBay() {

        String name ="ADP 3";
        InspectionBay inspectionBay = InspectionBayFactory.getInspectionBay(name);
        inspectionBay.setName("Fun");
        System.out.println(inspectionBay);
        Assert.assertEquals("Fun", inspectionBay.getName());
    }

    //Delete
    @Test
    public void deleteInspectionBay() {

        String name = "ADP 3";
        InspectionBay inspectionBay = InspectionBayFactory.getInspectionBay(name);
        inspectionBay = null;
        System.out.println(inspectionBay);
        Assert.assertNull(inspectionBay);
    }
}