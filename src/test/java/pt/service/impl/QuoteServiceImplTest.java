package pt.service.impl;

import pt.domain.Quote;
import pt.factory.QuoteFactory;
import pt.service.QuoteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class QuoteServiceImplTest {
    private QuoteService service;
    private Quote quote;

    private Quote getSavedQuote(){
        Set<Quote> savedQuotes = this.service.getAll();
        return savedQuotes.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = QuoteServiceImpl.getService();
        this.quote = QuoteFactory.getQuote("Test Quote");
    }

    @Test
    public void create() {

        Quote testCreate = this.service.create(this.quote);
        Assert.assertSame(testCreate, this.quote);

    }

    @Test
    public void delete() {

        int startingSize = this.service.getAll().size();
        Quote savedQuote = getSavedQuote();
        this.service.delete(savedQuote.getQuoteId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another quote after deleting so that Read() has something to read.
        this.service.create(this.quote);

    }

    @Test
    public void read() {

        Quote savedQuote = getSavedQuote();
        String id = savedQuote.getQuoteId();
        Quote readQuote = this.service.read(id);
        Assert.assertEquals(savedQuote, readQuote);
    }

    @Test
    public void update() {

        Quote saved = getSavedQuote();
        String id = saved.getQuoteId();
        String newName = "Hello";
        saved.setName(newName);
        this.service.update(saved);

        Assert.assertEquals(newName,this.service.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Quote> all = this.service.getAll();
        Assert.assertNotNull(all);

    }
}