package pt.controller.admin;

import pt.domain.LoyalCustomer;
import pt.factory.LoyalCustomerFactory;
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
public class LoyalCustomerControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/loyalCustomer";

    @Test
    public void create() {
        LoyalCustomer loyalCustomer = LoyalCustomerFactory.getLoyalCustomer("LoyalCustomer One");

        ResponseEntity<LoyalCustomer> postResponse = restTemplate.postForEntity(baseURL + "/create", loyalCustomer, LoyalCustomer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        LoyalCustomer loyalCustomer = restTemplate.getForObject(baseURL + "/LoyalCustomer/" + id, LoyalCustomer.class);

        restTemplate.put(baseURL + "/loyalCustomers/" + id, loyalCustomer);
        LoyalCustomer updatedLoyalCustomer = restTemplate.getForObject(baseURL + "/LoyalCustomer/" + id, LoyalCustomer.class);
        assertNotNull(updatedLoyalCustomer);
    }

    @Test
    public void delete() {
        int id = 2;
        LoyalCustomer loyalCustomer = restTemplate.getForObject(baseURL + "/loyalCustomers/" + id, LoyalCustomer.class);
        assertNotNull(loyalCustomer);
        restTemplate.delete(baseURL + "/loyalCustomers/" + id);
        try {
            loyalCustomer = restTemplate.getForObject(baseURL + "/loyalCustomers/" + id, LoyalCustomer.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        LoyalCustomer loyalCustomer = restTemplate.getForObject(baseURL + "/read", LoyalCustomer.class);
        assertNotNull(loyalCustomer);
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