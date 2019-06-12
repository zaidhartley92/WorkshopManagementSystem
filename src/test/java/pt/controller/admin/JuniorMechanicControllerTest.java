package pt.controller.admin;

import pt.domain.JuniorMechanic;
import pt.factory.JuniorMechanicFactory;
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
public class JuniorMechanicControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/juniorMechanic";

    @Test
    public void create() {
        JuniorMechanic juniorMechanic = JuniorMechanicFactory.getJuniorMechanic("JuniorMechanic One");

        ResponseEntity<JuniorMechanic> postResponse = restTemplate.postForEntity(baseURL + "/create", juniorMechanic, JuniorMechanic.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        JuniorMechanic juniorMechanic = restTemplate.getForObject(baseURL + "/JuniorMechanic/" + id, JuniorMechanic.class);

        restTemplate.put(baseURL + "/juniorMechanics/" + id, juniorMechanic);
        JuniorMechanic updatedJuniorMechanic = restTemplate.getForObject(baseURL + "/JuniorMechanic/" + id, JuniorMechanic.class);
        assertNotNull(updatedJuniorMechanic);
    }

    @Test
    public void delete() {
        int id = 2;
        JuniorMechanic juniorMechanic = restTemplate.getForObject(baseURL + "/juniorMechanics/" + id, JuniorMechanic.class);
        assertNotNull(juniorMechanic);
        restTemplate.delete(baseURL + "/juniorMechanics/" + id);
        try {
            juniorMechanic = restTemplate.getForObject(baseURL + "/juniorMechanics/" + id, JuniorMechanic.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        JuniorMechanic juniorMechanic = restTemplate.getForObject(baseURL + "/read", JuniorMechanic.class);
        assertNotNull(juniorMechanic);
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