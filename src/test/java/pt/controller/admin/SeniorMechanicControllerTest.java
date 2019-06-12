package pt.controller.admin;

import pt.domain.SeniorMechanic;
import pt.factory.SeniorMechanicFactory;
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
public class SeniorMechanicControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/seniorMechanic";

    @Test
    public void create() {
        SeniorMechanic seniorMechanic = SeniorMechanicFactory.getSeniorMechanic("SeniorMechanic One");

        ResponseEntity<SeniorMechanic> postResponse = restTemplate.postForEntity(baseURL + "/create", seniorMechanic, SeniorMechanic.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        SeniorMechanic seniorMechanic = restTemplate.getForObject(baseURL + "/SeniorMechanic/" + id, SeniorMechanic.class);

        restTemplate.put(baseURL + "/seniorMechanics/" + id, seniorMechanic);
        SeniorMechanic updatedSeniorMechanic = restTemplate.getForObject(baseURL + "/SeniorMechanic/" + id, SeniorMechanic.class);
        assertNotNull(updatedSeniorMechanic);
    }

    @Test
    public void delete() {
        int id = 2;
        SeniorMechanic seniorMechanic = restTemplate.getForObject(baseURL + "/seniorMechanics/" + id, SeniorMechanic.class);
        assertNotNull(seniorMechanic);
        restTemplate.delete(baseURL + "/seniorMechanics/" + id);
        try {
            seniorMechanic = restTemplate.getForObject(baseURL + "/seniorMechanics/" + id, SeniorMechanic.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        SeniorMechanic seniorMechanic = restTemplate.getForObject(baseURL + "/read", SeniorMechanic.class);
        assertNotNull(seniorMechanic);
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