package pt.controller.admin;

import pt.domain.Reception;
import pt.factory.ReceptionFactory;
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
public class ReceptionControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/secretary";

    @Test
    public void create() {
        Reception reception = ReceptionFactory.getSecretary("Reception One");

        ResponseEntity<Reception> postResponse = restTemplate.postForEntity(baseURL + "/create", reception, Reception.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Reception reception = restTemplate.getForObject(baseURL + "/Reception/" + id, Reception.class);

        restTemplate.put(baseURL + "/secretarys/" + id, reception);
        Reception updatedReception = restTemplate.getForObject(baseURL + "/Reception/" + id, Reception.class);
        assertNotNull(updatedReception);
    }

    @Test
    public void delete() {
        int id = 2;
        Reception reception = restTemplate.getForObject(baseURL + "/secretarys/" + id, Reception.class);
        assertNotNull(reception);
        restTemplate.delete(baseURL + "/secretarys/" + id);
        try {
            reception = restTemplate.getForObject(baseURL + "/secretarys/" + id, Reception.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Reception reception = restTemplate.getForObject(baseURL + "/read", Reception.class);
        assertNotNull(reception);
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