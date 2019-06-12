package pt.factory;

import pt.domain.Quote;
import pt.util.Misc;

public class QuoteFactory {
    public static Quote getQuote(String Name) {
        return new Quote.Builder().quoteId(Misc.generateId())
                .name(Name)
                .build();
    }

}
