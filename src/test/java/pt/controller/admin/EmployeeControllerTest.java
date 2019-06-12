package pt.controller.admin;

import pt.domain.Employee;
import pt.factory.EmployeeFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/employee";

    @Test
    public void create() {
        Employee employee = EmployeeFactory.getEmployee("Employee One");

        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(baseURL + "/create", employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Employee employee = restTemplate.getForObject(baseURL + "/Employee/" + id, Employee.class);

        restTemplate.put(baseURL + "/employees/" + id, employee);
        Employee updatedEmployee = restTemplate.getForObject(baseURL + "/Employee/" + id, Employee.class);
        assertNotNull(updatedEmployee);
    }

    @Test
    public void delete() {
        int id = 2;
        Employee employee = restTemplate.getForObject(baseURL + "/employees/" + id, Employee.class);
        assertNotNull(employee);
        restTemplate.delete(baseURL + "/employees/" + id);
        try {
            employee = restTemplate.getForObject(baseURL + "/employees/" + id, Employee.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Employee employee = restTemplate.getForObject(baseURL + "/read", Employee.class);
        assertNotNull(employee);
    }

    @Test
    public void getAll() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());

    }
}