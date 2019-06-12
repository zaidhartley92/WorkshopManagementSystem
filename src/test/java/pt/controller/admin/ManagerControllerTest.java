package pt.controller.admin;

import pt.domain.Manager;
import pt.factory.ManagerFactory;
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
public class ManagerControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/manager";

    @Test
    public void create() {
        Manager manager = ManagerFactory.getManager("Manager One");

        ResponseEntity<Manager> postResponse = restTemplate.postForEntity(baseURL + "/create", manager, Manager.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Manager manager = restTemplate.getForObject(baseURL + "/Manager/" + id, Manager.class);

        restTemplate.put(baseURL + "/managers/" + id, manager);
        Manager updatedManager = restTemplate.getForObject(baseURL + "/Manager/" + id, Manager.class);
        assertNotNull(updatedManager);
    }

    @Test
    public void delete() {
        int id = 2;
        Manager manager = restTemplate.getForObject(baseURL + "/managers/" + id, Manager.class);
        assertNotNull(manager);
        restTemplate.delete(baseURL + "/managers/" + id);
        try {
            manager = restTemplate.getForObject(baseURL + "/managers/" + id, Manager.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Manager manager = restTemplate.getForObject(baseURL + "/read", Manager.class);
        assertNotNull(manager);
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