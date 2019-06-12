package pt.factory;
import org.junit.Assert;
import org.junit.Test;
import pt.domain.Quote;

public class QuoteFactoryTest {

    //Create
    @Test
    public void getQuote() {

        String name = "ADP 3";
        Quote quote = QuoteFactory.getQuote(name);
        System.out.println(quote);
        Assert.assertNotNull(quote.getQuoteId());

    }

    //Read
    @Test
    public void getName() {

        String name = "ADP 3";
        Quote quote = QuoteFactory.getQuote(name);
        System.out.println(quote);
        Assert.assertEquals("ADP 3", quote.getName());
    }

    //Update
    @Test
    public void updateQuote() {

        String name ="ADP 3";
        Quote quote = QuoteFactory.getQuote(name);
        quote.setName("Fun");
        System.out.println(quote);
        Assert.assertEquals("Fun", quote.getName());
    }

    //Delete
    @Test
    public void deleteQuote() {

        String name = "ADP 3";
        Quote quote = QuoteFactory.getQuote(name);
        quote = null;
        System.out.println(quote);
        Assert.assertNull(quote);
    }
}