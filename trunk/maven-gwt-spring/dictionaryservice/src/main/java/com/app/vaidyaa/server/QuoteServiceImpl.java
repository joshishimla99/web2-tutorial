package com.app.vaidyaa.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.app.vaidyaa.client.service.QuoteService;

public class QuoteServiceImpl implements QuoteService {

        private Random randomizer = new Random();
        private static List<String> quotes = new ArrayList<String>();

        static {
                quotes.add("No great thing is created suddenly - Epictetus");
                quotes.add("Well done is better than well said - Ben Franklin");
                quotes.add("No wind favors he who has no destined port - Montaigne");
                quotes.add("Sometimes even to live is an act of courage - Seneca");
                quotes.add("Know thyself - Socrates");
        }

        public String getQuote() {
                return quotes.get(randomizer.nextInt(quotes.size()));
        }
}