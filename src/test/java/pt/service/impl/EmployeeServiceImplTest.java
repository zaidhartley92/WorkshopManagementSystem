package pt.service.impl;

import pt.domain.Employee;
import pt.factory.EmployeeFactory;
import pt.service.EmployeeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class EmployeeServiceImplTest {

    private EmployeeService service;
    private Employee employee;

    private Employee getSavedEmployee(){
        Set<Employee> savedEmployees = this.service.getAll();
        return savedEmployees.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = EmployeeServiceImpl.getService();
        this.employee = EmployeeFactory.getEmployee("Test Employee");
    }

    @Test
    public void create() {

        Employee testCreate = this.service.create(this.employee);
        Assert.assertSame(testCreate, this.employee);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Employee savedEmployee = getSavedEmployee();
        this.service.delete(savedEmployee.getEmployeeId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another employee after deleting so that Read() has something to read.
        this.service.create(this.employee);

    }

    @Test
    public void read() {

        Employee savedEmployee = getSavedEmployee();
        String id = savedEmployee.getEmployeeId();
        Employee readEmployee = this.service.read(id);
        Assert.assertEquals(savedEmployee, readEmployee);
    }

    @Test
    public void update() {

        Employee saved = getSavedEmployee();
        String id = saved.getEmployeeId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Employee> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}
