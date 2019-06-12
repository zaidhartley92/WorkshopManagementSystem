package pt.controller.admin;

import pt.domain.ParkingBay;
import pt.factory.ParkingBayFactory;
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
public class ParkingBayControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/parkingBay";

    @Test
    public void create() {
        ParkingBay parkingBay = ParkingBayFactory.getParkingBay("ParkingBay One");

        ResponseEntity<ParkingBay> postResponse = restTemplate.postForEntity(baseURL + "/create", parkingBay, ParkingBay.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        ParkingBay parkingBay = restTemplate.getForObject(baseURL + "/ParkingBay/" + id, ParkingBay.class);

        restTemplate.put(baseURL + "/parkingBays/" + id, parkingBay);
        ParkingBay updatedParkingBay = restTemplate.getForObject(baseURL + "/ParkingBay/" + id, ParkingBay.class);
        assertNotNull(updatedParkingBay);
    }

    @Test
    public void delete() {
        int id = 2;
        ParkingBay parkingBay = restTemplate.getForObject(baseURL + "/parkingBays/" + id, ParkingBay.class);
        assertNotNull(parkingBay);
        restTemplate.delete(baseURL + "/parkingBays/" + id);
        try {
            parkingBay = restTemplate.getForObject(baseURL + "/parkingBays/" + id, ParkingBay.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        ParkingBay parkingBay = restTemplate.getForObject(baseURL + "/read", ParkingBay.class);
        assertNotNull(parkingBay);
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