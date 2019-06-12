package pt.controller.admin;

import pt.domain.Window;
import pt.factory.WindowFactory;
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
public class WindowControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/window";

    @Test
    public void create() {
        Window window = WindowFactory.getWindow("Window One");

        ResponseEntity<Window> postResponse = restTemplate.postForEntity(baseURL + "/create", window, Window.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Window window = restTemplate.getForObject(baseURL + "/Window/" + id, Window.class);

        restTemplate.put(baseURL + "/windows/" + id, window);
        Window updatedWindow = restTemplate.getForObject(baseURL + "/Window/" + id, Window.class);
        assertNotNull(updatedWindow);
    }

    @Test
    public void delete() {
        int id = 2;
        Window window = restTemplate.getForObject(baseURL + "/windows/" + id, Window.class);
        assertNotNull(window);
        restTemplate.delete(baseURL + "/windows/" + id);
        try {
            window = restTemplate.getForObject(baseURL + "/windows/" + id, Window.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Window window = restTemplate.getForObject(baseURL + "/read", Window.class);
        assertNotNull(window);
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