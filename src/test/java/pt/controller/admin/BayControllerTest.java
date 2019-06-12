package pt.controller.admin;

import pt.domain.Bay;
import pt.factory.BayFactory;
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
public class BayControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/bay";

    @Test
    public void create() {
        Bay bay = BayFactory.getBay("Bay One");

        ResponseEntity<Bay> postResponse = restTemplate.postForEntity(baseURL + "/create", bay, Bay.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Bay bay = restTemplate.getForObject(baseURL + "/Bay/" + id, Bay.class);

        restTemplate.put(baseURL + "/bays/" + id, bay);
        Bay updatedBay = restTemplate.getForObject(baseURL + "/Bay/" + id, Bay.class);
        assertNotNull(updatedBay);
    }

    @Test
    public void delete() {
        int id = 2;
        Bay bay = restTemplate.getForObject(baseURL + "/bays/" + id, Bay.class);
        assertNotNull(bay);
        restTemplate.delete(baseURL + "/bays/" + id);
        try {
            bay = restTemplate.getForObject(baseURL + "/bays/" + id, Bay.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Bay bay = restTemplate.getForObject(baseURL + "/read", Bay.class);
        assertNotNull(bay);
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