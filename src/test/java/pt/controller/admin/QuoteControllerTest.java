package pt.controller.admin;

import pt.domain.Quote;
import pt.factory.QuoteFactory;
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
public class QuoteControllerTest {

    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/quote";

    @Test
    public void create() {
        Quote quote = QuoteFactory.getQuote("Quote One");

        ResponseEntity<Quote> postResponse = restTemplate.postForEntity(baseURL + "/create", quote, Quote.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Quote quote = restTemplate.getForObject(baseURL + "/Quote/" + id, Quote.class);

        restTemplate.put(baseURL + "/quotes/" + id, quote);
        Quote updatedQuote = restTemplate.getForObject(baseURL + "/Quote/" + id, Quote.class);
        assertNotNull(updatedQuote);
    }

    @Test
    public void delete() {
        int id = 2;
        Quote quote = restTemplate.getForObject(baseURL + "/quotes/" + id, Quote.class);
        assertNotNull(quote);
        restTemplate.delete(baseURL + "/quotes/" + id);
        try {
            quote = restTemplate.getForObject(baseURL + "/quotes/" + id, Quote.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Quote quote = restTemplate.getForObject(baseURL + "/read", Quote.class);
        assertNotNull(quote);
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