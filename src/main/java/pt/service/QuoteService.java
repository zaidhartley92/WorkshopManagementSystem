package pt.service;
import pt.domain.Quote;

import java.util.Set;

public interface QuoteService extends IService<Quote, String>{
    Set<Quote> getAll();
}
