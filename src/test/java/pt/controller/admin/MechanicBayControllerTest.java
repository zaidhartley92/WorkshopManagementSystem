package pt.controller.admin;

import pt.domain.MechanicBay;
import pt.factory.MechanicBayFactory;
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
public class MechanicBayControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/mechanicBay";

    @Test
    public void create() {
        MechanicBay mechanicBay = MechanicBayFactory.getMechanicBay("MechanicBay One");

        ResponseEntity<MechanicBay> postResponse = restTemplate.postForEntity(baseURL + "/create", mechanicBay, MechanicBay.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        MechanicBay mechanicBay = restTemplate.getForObject(baseURL + "/MechanicBay/" + id, MechanicBay.class);

        restTemplate.put(baseURL + "/mechanicBays/" + id, mechanicBay);
        MechanicBay updatedMechanicBay = restTemplate.getForObject(baseURL + "/MechanicBay/" + id, MechanicBay.class);
        assertNotNull(updatedMechanicBay);
    }

    @Test
    public void delete() {
        int id = 2;
        MechanicBay mechanicBay = restTemplate.getForObject(baseURL + "/mechanicBays/" + id, MechanicBay.class);
        assertNotNull(mechanicBay);
        restTemplate.delete(baseURL + "/mechanicBays/" + id);
        try {
            mechanicBay = restTemplate.getForObject(baseURL + "/mechanicBays/" + id, MechanicBay.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        MechanicBay mechanicBay = restTemplate.getForObject(baseURL + "/read", MechanicBay.class);
        assertNotNull(mechanicBay);
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