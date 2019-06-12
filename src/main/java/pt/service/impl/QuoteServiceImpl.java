package pt.service.impl;

import pt.domain.Quote;
import pt.repository.QuoteRepository;
import pt.repository.impl.QuoteRepositoryImpl;
import pt.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    @Qualifier("QuoteRepo")
    private static QuoteServiceImpl service = null;
    private QuoteRepository repository;

    private QuoteServiceImpl(){
        this.repository = QuoteRepositoryImpl.getRepository();
    }

    public static QuoteService getService(){
        if (service == null) service = new QuoteServiceImpl();
        return service;
    }

    @Override
    public Quote create(Quote quote) {
        return this.repository.create(quote);
    }

    @Override
    public Quote update(Quote quote) {
        return this.repository.update(quote);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Quote read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Quote> getAll() {
        return repository.getAll();
    }

}