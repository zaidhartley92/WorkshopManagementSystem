package pt.controller.admin;

import pt.domain.Engine;
import pt.factory.EngineFactory;
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
public class EngineControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/engine";

    @Test
    public void create() {
        Engine engine = EngineFactory.getEngine("Engine One");

        ResponseEntity<Engine> postResponse = restTemplate.postForEntity(baseURL + "/create", engine, Engine.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Engine engine = restTemplate.getForObject(baseURL + "/Engine/" + id, Engine.class);

        restTemplate.put(baseURL + "/engines/" + id, engine);
        Engine updatedEngine = restTemplate.getForObject(baseURL + "/Engine/" + id, Engine.class);
        assertNotNull(updatedEngine);
    }

    @Test
    public void delete() {
        int id = 2;
        Engine engine = restTemplate.getForObject(baseURL + "/engines/" + id, Engine.class);
        assertNotNull(engine);
        restTemplate.delete(baseURL + "/engines/" + id);
        try {
            engine = restTemplate.getForObject(baseURL + "/engines/" + id, Engine.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Engine engine = restTemplate.getForObject(baseURL + "/read", Engine.class);
        assertNotNull(engine);
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