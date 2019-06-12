package pt.controller.admin;

import pt.domain.Bike;
import pt.factory.BikeFactory;
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
public class BikeControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/bike";

    @Test
    public void create() {
        Bike bike = BikeFactory.getBike("Bike One");

        ResponseEntity<Bike> postResponse = restTemplate.postForEntity(baseURL + "/create", bike, Bike.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Bike bike = restTemplate.getForObject(baseURL + "/Bike/" + id, Bike.class);

        restTemplate.put(baseURL + "/bikes/" + id, bike);
        Bike updatedBike = restTemplate.getForObject(baseURL + "/Bike/" + id, Bike.class);
        assertNotNull(updatedBike);
    }

    @Test
    public void delete() {
        int id = 2;
        Bike bike = restTemplate.getForObject(baseURL + "/bikes/" + id, Bike.class);
        assertNotNull(bike);
        restTemplate.delete(baseURL + "/bikes/" + id);
        try {
            bike = restTemplate.getForObject(baseURL + "/bikes/" + id, Bike.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Bike bike = restTemplate.getForObject(baseURL + "/read", Bike.class);
        assertNotNull(bike);
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