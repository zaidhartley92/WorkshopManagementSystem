package pt.repository.impl;

import pt.domain.Quote;
import pt.repository.QuoteRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("QuoteRepo")
public class QuoteRepositoryImpl implements QuoteRepository {

    private static QuoteRepositoryImpl repository = null;
    private Set<Quote> quotes;

    private QuoteRepositoryImpl(){
        this.quotes = new HashSet<>();
    }

    public static QuoteRepositoryImpl getRepository(){
        if (repository == null) repository = new QuoteRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Quote> getAll() {
        return this.quotes;
    }

    @Override
    public Quote create(Quote quote) {
        this.quotes.add(quote);
        return quote;
    }

    @Override
    public Quote update(Quote quote) {

        Quote[] cloneOfQuotes = quotes.toArray(new Quote[quotes.size()]);
        for (int i = 0; i<cloneOfQuotes.length;i++) {
            if (cloneOfQuotes[i].equals(quote)) {
                quotes.remove(cloneOfQuotes[i]);
            }
        }
        return create(quote);
    }

    @Override
    public void delete(String quoteId) {
        Quote[] cloneOfQuotes = quotes.toArray(new Quote[quotes.size()]);
        for (int i = 0; i<cloneOfQuotes.length;i++) {
            if (cloneOfQuotes[i].getQuoteId() == quoteId) {
                if (quotes.contains(cloneOfQuotes[i])){
                    quotes.remove(cloneOfQuotes[i]);
                }
            }
        }
    }

    @Override
    public Quote read(String quoteId) {

        Quote quoteToReturn = null;

        Quote[] cloneOfQuotes = quotes.toArray(new Quote[quotes.size()]);

        for (int i = 0; i<cloneOfQuotes.length;i++) {
            if (cloneOfQuotes[i].getQuoteId() == quoteId) {
                quoteToReturn = cloneOfQuotes[i];
            }
        }

        return quoteToReturn;
    }
}