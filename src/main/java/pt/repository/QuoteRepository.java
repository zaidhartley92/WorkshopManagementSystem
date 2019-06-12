package pt.repository;

import pt.domain.Quote;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuoteRepository extends IRepository<Quote, String>{

    Set<Quote> getAll();

}