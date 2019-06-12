package pt.controller.admin;

import pt.domain.Mechanic;
import pt.factory.MechanicFactory;
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
public class MechanicControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/mechanic";

    @Test
    public void create() {
        Mechanic mechanic = MechanicFactory.getMechanic("Mechanic One");

        ResponseEntity<Mechanic> postResponse = restTemplate.postForEntity(baseURL + "/create", mechanic, Mechanic.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Mechanic mechanic = restTemplate.getForObject(baseURL + "/Mechanic/" + id, Mechanic.class);

        restTemplate.put(baseURL + "/mechanics/" + id, mechanic);
        Mechanic updatedMechanic = restTemplate.getForObject(baseURL + "/Mechanic/" + id, Mechanic.class);
        assertNotNull(updatedMechanic);
    }

    @Test
    public void delete() {
        int id = 2;
        Mechanic mechanic = restTemplate.getForObject(baseURL + "/mechanics/" + id, Mechanic.class);
        assertNotNull(mechanic);
        restTemplate.delete(baseURL + "/mechanics/" + id);
        try {
            mechanic = restTemplate.getForObject(baseURL + "/mechanics/" + id, Mechanic.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Mechanic mechanic = restTemplate.getForObject(baseURL + "/read", Mechanic.class);
        assertNotNull(mechanic);
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