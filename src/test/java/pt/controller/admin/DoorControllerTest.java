package pt.controller.admin;

import pt.domain.Door;
import pt.factory.DoorFactory;
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
public class DoorControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/door";

    @Test
    public void create() {
        Door door = DoorFactory.getDoor("Door One");

        ResponseEntity<Door> postResponse = restTemplate.postForEntity(baseURL + "/create", door, Door.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Door door = restTemplate.getForObject(baseURL + "/Door/" + id, Door.class);

        restTemplate.put(baseURL + "/doors/" + id, door);
        Door updatedDoor = restTemplate.getForObject(baseURL + "/Door/" + id, Door.class);
        assertNotNull(updatedDoor);
    }

    @Test
    public void delete() {
        int id = 2;
        Door door = restTemplate.getForObject(baseURL + "/doors/" + id, Door.class);
        assertNotNull(door);
        restTemplate.delete(baseURL + "/doors/" + id);
        try {
            door = restTemplate.getForObject(baseURL + "/doors/" + id, Door.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Door door = restTemplate.getForObject(baseURL + "/read", Door.class);
        assertNotNull(door);
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