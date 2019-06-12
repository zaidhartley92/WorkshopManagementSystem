package pt.repository.impl;

import org.junit.Test;

import pt.domain.Quote;
import pt.factory.QuoteFactory;
import pt.repository.QuoteRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@FixMethodOrder(MethodSorters.DEFAULT)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class QuoteRepositoryImplTest {

    @Autowired
    private QuoteRepository repository;
    private Quote quote;

    private Quote getSavedQuote(){
        Set<Quote> savedQuotes = this.repository.getAll();
        return savedQuotes.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = QuoteRepositoryImpl.getRepository();
        this.quote = QuoteFactory.getQuote("Test Quote");
    }

    @Test
    public void create() {

        Quote testCreate = this.repository.create(this.quote);
        Assert.assertSame(testCreate, this.quote);

    }

    @Test
    public void delete() {

        int startingSize = this.repository.getAll().size();
        Quote savedQuote = getSavedQuote();
        this.repository.delete(savedQuote.getQuoteId());

        Assert.assertEquals(startingSize-1,this.repository.getAll().size());

        //Create another quote after deleting so that Read() has something to read.
        this.repository.create(this.quote);

    }

    @Test
    public void read() {

        Quote savedQuote = getSavedQuote();
        String id = savedQuote.getQuoteId();
        Quote readQuote = this.repository.read(id);
        Assert.assertEquals(savedQuote, readQuote);
    }

    @Test
    public void update() {

        Quote saved = getSavedQuote();
        String id = saved.getQuoteId();
        String newName = "Hello";
        saved.setName(newName);
        this.repository.update(saved);

        Assert.assertEquals(newName,this.repository.read(id).getName());

    }

    @Test
    public void getAll() {

        Set<Quote> all = this.repository.getAll();
        Assert.assertNotNull(all);

    }
}