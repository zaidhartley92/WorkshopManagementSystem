package pt.controller.admin;

import pt.domain.Customer;
import pt.factory.CustomerFactory;
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
public class CustomerControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/customer";

    @Test
    public void create() {
        Customer customer = CustomerFactory.getCustomer("Customer One");

        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(baseURL + "/create", customer, Customer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Customer customer = restTemplate.getForObject(baseURL + "/Customer/" + id, Customer.class);

        restTemplate.put(baseURL + "/customers/" + id, customer);
        Customer updatedCustomer = restTemplate.getForObject(baseURL + "/Customer/" + id, Customer.class);
        assertNotNull(updatedCustomer);
    }

    @Test
    public void delete() {
        int id = 2;
        Customer customer = restTemplate.getForObject(baseURL + "/customers/" + id, Customer.class);
        assertNotNull(customer);
        restTemplate.delete(baseURL + "/customers/" + id);
        try {
            customer = restTemplate.getForObject(baseURL + "/customers/" + id, Customer.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Customer customer = restTemplate.getForObject(baseURL + "/read", Customer.class);
        assertNotNull(customer);
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