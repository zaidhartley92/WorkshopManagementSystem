package pt.controller.admin;

import pt.domain.Tire;
import pt.factory.TireFactory;
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
public class TireControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/tire";

    @Test
    public void create() {
        Tire tire = TireFactory.getTire("Tire One");

        ResponseEntity<Tire> postResponse = restTemplate.postForEntity(baseURL + "/create", tire, Tire.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Tire tire = restTemplate.getForObject(baseURL + "/Tire/" + id, Tire.class);

        restTemplate.put(baseURL + "/tires/" + id, tire);
        Tire updatedTire = restTemplate.getForObject(baseURL + "/Tire/" + id, Tire.class);
        assertNotNull(updatedTire);
    }

    @Test
    public void delete() {
        int id = 2;
        Tire tire = restTemplate.getForObject(baseURL + "/tires/" + id, Tire.class);
        assertNotNull(tire);
        restTemplate.delete(baseURL + "/tires/" + id);
        try {
            tire = restTemplate.getForObject(baseURL + "/tires/" + id, Tire.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Tire tire = restTemplate.getForObject(baseURL + "/read", Tire.class);
        assertNotNull(tire);
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