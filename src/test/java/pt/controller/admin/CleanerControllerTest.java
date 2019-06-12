package pt.controller.admin;

import pt.domain.Cleaner;
import pt.factory.CleanerFactory;
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
public class CleanerControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/cleaner";

    @Test
    public void create() {
        Cleaner cleaner = CleanerFactory.getCleaner("Cleaner One");

        ResponseEntity<Cleaner> postResponse = restTemplate.postForEntity(baseURL + "/create", cleaner, Cleaner.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Cleaner cleaner = restTemplate.getForObject(baseURL + "/Cleaner/" + id, Cleaner.class);

        restTemplate.put(baseURL + "/cleaners/" + id, cleaner);
        Cleaner updatedCleaner = restTemplate.getForObject(baseURL + "/Cleaner/" + id, Cleaner.class);
        assertNotNull(updatedCleaner);
    }

    @Test
    public void delete() {
        int id = 2;
        Cleaner cleaner = restTemplate.getForObject(baseURL + "/cleaners/" + id, Cleaner.class);
        assertNotNull(cleaner);
        restTemplate.delete(baseURL + "/cleaners/" + id);
        try {
            cleaner = restTemplate.getForObject(baseURL + "/cleaners/" + id, Cleaner.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Cleaner cleaner = restTemplate.getForObject(baseURL + "/read", Cleaner.class);
        assertNotNull(cleaner);
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