package pt.controller.admin;

import pt.domain.Part;
import pt.factory.PartFactory;
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
public class PartControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/part";

    @Test
    public void create() {
        Part part = PartFactory.getPart("Part One");

        ResponseEntity<Part> postResponse = restTemplate.postForEntity(baseURL + "/create", part, Part.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Part part = restTemplate.getForObject(baseURL + "/Part/" + id, Part.class);

        restTemplate.put(baseURL + "/parts/" + id, part);
        Part updatedPart = restTemplate.getForObject(baseURL + "/Part/" + id, Part.class);
        assertNotNull(updatedPart);
    }

    @Test
    public void delete() {
        int id = 2;
        Part part = restTemplate.getForObject(baseURL + "/parts/" + id, Part.class);
        assertNotNull(part);
        restTemplate.delete(baseURL + "/parts/" + id);
        try {
            part = restTemplate.getForObject(baseURL + "/parts/" + id, Part.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Part part = restTemplate.getForObject(baseURL + "/read", Part.class);
        assertNotNull(part);
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