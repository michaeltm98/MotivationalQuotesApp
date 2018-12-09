package michaeltm98.com.motivationalquotesapp.data;

import java.util.ArrayList;

import michaeltm98.com.motivationalquotesapp.model.Quote;

public interface QuoteListAsyncResponse {
    void processFinished(ArrayList<Quote> quotes);
}
