package pt.controller.admin;

import pt.domain.Truck;
import pt.factory.TruckFactory;
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
public class TruckControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/truck";

    @Test
    public void create() {
        Truck truck = TruckFactory.getTruck("Truck One");

        ResponseEntity<Truck> postResponse = restTemplate.postForEntity(baseURL + "/create", truck, Truck.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Truck truck = restTemplate.getForObject(baseURL + "/Truck/" + id, Truck.class);

        restTemplate.put(baseURL + "/trucks/" + id, truck);
        Truck updatedTruck = restTemplate.getForObject(baseURL + "/Truck/" + id, Truck.class);
        assertNotNull(updatedTruck);
    }

    @Test
    public void delete() {
        int id = 2;
        Truck truck = restTemplate.getForObject(baseURL + "/trucks/" + id, Truck.class);
        assertNotNull(truck);
        restTemplate.delete(baseURL + "/trucks/" + id);
        try {
            truck = restTemplate.getForObject(baseURL + "/trucks/" + id, Truck.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Truck truck = restTemplate.getForObject(baseURL + "/read", Truck.class);
        assertNotNull(truck);
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