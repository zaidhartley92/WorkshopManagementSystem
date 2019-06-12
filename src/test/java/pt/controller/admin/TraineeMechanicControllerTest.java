package pt.controller.admin;

import pt.domain.TraineeMechanic;
import pt.factory.TraineeMechanicFactory;
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
public class TraineeMechanicControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/traineeMechanic";

    @Test
    public void create() {
        TraineeMechanic traineeMechanic = TraineeMechanicFactory.getTraineeMechanic("TraineeMechanic One");

        ResponseEntity<TraineeMechanic> postResponse = restTemplate.postForEntity(baseURL + "/create", traineeMechanic, TraineeMechanic.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        TraineeMechanic traineeMechanic = restTemplate.getForObject(baseURL + "/TraineeMechanic/" + id, TraineeMechanic.class);

        restTemplate.put(baseURL + "/traineeMechanics/" + id, traineeMechanic);
        TraineeMechanic updatedTraineeMechanic = restTemplate.getForObject(baseURL + "/TraineeMechanic/" + id, TraineeMechanic.class);
        assertNotNull(updatedTraineeMechanic);
    }

    @Test
    public void delete() {
        int id = 2;
        TraineeMechanic traineeMechanic = restTemplate.getForObject(baseURL + "/traineeMechanics/" + id, TraineeMechanic.class);
        assertNotNull(traineeMechanic);
        restTemplate.delete(baseURL + "/traineeMechanics/" + id);
        try {
            traineeMechanic = restTemplate.getForObject(baseURL + "/traineeMechanics/" + id, TraineeMechanic.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        TraineeMechanic traineeMechanic = restTemplate.getForObject(baseURL + "/read", TraineeMechanic.class);
        assertNotNull(traineeMechanic);
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