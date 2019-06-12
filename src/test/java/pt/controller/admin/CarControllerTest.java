package pt.controller.admin;

import pt.domain.Car;
import pt.factory.CarFactory;
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
public class CarControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/car";

    @Test
    public void create() {
        Car car = CarFactory.getCar("Car One");

        ResponseEntity<Car> postResponse = restTemplate.postForEntity(baseURL + "/create", car, Car.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Car car = restTemplate.getForObject(baseURL + "/Car/" + id, Car.class);

        restTemplate.put(baseURL + "/cars/" + id, car);
        Car updatedCar = restTemplate.getForObject(baseURL + "/Car/" + id, Car.class);
        assertNotNull(updatedCar);
    }

    @Test
    public void delete() {
        int id = 2;
        Car car = restTemplate.getForObject(baseURL + "/cars/" + id, Car.class);
        assertNotNull(car);
        restTemplate.delete(baseURL + "/cars/" + id);
        try {
            car = restTemplate.getForObject(baseURL + "/cars/" + id, Car.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Car car = restTemplate.getForObject(baseURL + "/read", Car.class);
        assertNotNull(car);
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