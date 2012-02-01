package com.app.vaidyaa.client;

import com.app.vaidyaa.client.service.QuoteService;
import com.app.vaidyaa.client.service.QuoteServiceAsync;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class GwtWisdom implements EntryPoint {

        @Override
        public void onModuleLoad() {
                final Label quoteText = new Label();

                Timer timer = new Timer() {

                        public void run() {
                                // create an async callback to handle the
                                // result:
                                AsyncCallback<String> callback = new AsyncCallback<String>() {

                                        public void onFailure(Throwable t) {
                                                // display error text if we
                                                // can't get the quote:
                                                quoteText.setText("Failed to get a quote");
                                        }

                                        public void onSuccess(String result) {
                                                // display the retrieved quote
                                                // in the label:
                                                quoteText.setText(result);
                                        }
                                };
                                QuoteServiceAsync service = (QuoteServiceAsync) GWT
                                                .create(QuoteService.class);
                                service.getQuote(callback);
                        }
                };

                timer.scheduleRepeating(3000);
                RootPanel.get().add(quoteText);
        }

}
