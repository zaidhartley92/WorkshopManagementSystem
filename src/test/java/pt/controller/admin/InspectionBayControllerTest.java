package pt.controller.admin;

import pt.domain.InspectionBay;
import pt.factory.InspectionBayFactory;
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
public class InspectionBayControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/inspectionBay";

    @Test
    public void create() {
        InspectionBay inspectionBay = InspectionBayFactory.getInspectionBay("InspectionBay One");

        ResponseEntity<InspectionBay> postResponse = restTemplate.postForEntity(baseURL + "/create", inspectionBay, InspectionBay.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        InspectionBay inspectionBay = restTemplate.getForObject(baseURL + "/InspectionBay/" + id, InspectionBay.class);

        restTemplate.put(baseURL + "/inspectionBays/" + id, inspectionBay);
        InspectionBay updatedInspectionBay = restTemplate.getForObject(baseURL + "/InspectionBay/" + id, InspectionBay.class);
        assertNotNull(updatedInspectionBay);
    }

    @Test
    public void delete() {
        int id = 2;
        InspectionBay inspectionBay = restTemplate.getForObject(baseURL + "/inspectionBays/" + id, InspectionBay.class);
        assertNotNull(inspectionBay);
        restTemplate.delete(baseURL + "/inspectionBays/" + id);
        try {
            inspectionBay = restTemplate.getForObject(baseURL + "/inspectionBays/" + id, InspectionBay.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        InspectionBay inspectionBay = restTemplate.getForObject(baseURL + "/read", InspectionBay.class);
        assertNotNull(inspectionBay);
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