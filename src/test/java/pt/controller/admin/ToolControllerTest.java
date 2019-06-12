package pt.controller.admin;

import pt.domain.Tool;
import pt.factory.ToolFactory;
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
public class ToolControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/tool";

    @Test
    public void create() {
        Tool tool = ToolFactory.getTool("Tool One");

        ResponseEntity<Tool> postResponse = restTemplate.postForEntity(baseURL + "/create", tool, Tool.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Tool tool = restTemplate.getForObject(baseURL + "/Tool/" + id, Tool.class);

        restTemplate.put(baseURL + "/tools/" + id, tool);
        Tool updatedTool = restTemplate.getForObject(baseURL + "/Tool/" + id, Tool.class);
        assertNotNull(updatedTool);
    }

    @Test
    public void delete() {
        int id = 2;
        Tool tool = restTemplate.getForObject(baseURL + "/tools/" + id, Tool.class);
        assertNotNull(tool);
        restTemplate.delete(baseURL + "/tools/" + id);
        try {
            tool = restTemplate.getForObject(baseURL + "/tools/" + id, Tool.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Tool tool = restTemplate.getForObject(baseURL + "/read", Tool.class);
        assertNotNull(tool);
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