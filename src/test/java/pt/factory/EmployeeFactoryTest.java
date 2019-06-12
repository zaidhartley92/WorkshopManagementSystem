package pt.factory;

import org.junit.Assert;
import org.junit.Test;
import pt.domain.Employee;

public class EmployeeFactoryTest {

    //Create
    @Test
    public void getEmployee() {

        String name = "ADP 3";
        Employee employee = EmployeeFactory.getEmployee(name);
        System.out.println(employee);
        Assert.assertNotNull(employee.getEmployeeId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Employee employee = EmployeeFactory.getEmployee(name);
        System.out.println(employee);
        Assert.assertEquals("ADP 3", employee.getName());
    }

    //Update
    @Test
    public void updateEmployee() {

        String name ="ADP 3";
        Employee employee = EmployeeFactory.getEmployee(name);
        employee.setName("Fun");
        System.out.println(employee);
        Assert.assertEquals("Fun", employee.getName());
    }

    //Delete
    @Test
    public void deleteEmployee() {

        String name = "ADP 3";
        Employee employee = EmployeeFactory.getEmployee(name);
        employee = null;
        System.out.println(employee);
        Assert.assertNull(employee);
    }
}