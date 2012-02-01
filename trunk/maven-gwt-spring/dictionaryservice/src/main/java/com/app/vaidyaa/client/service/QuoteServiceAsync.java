package com.app.vaidyaa.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface QuoteServiceAsync {

        void getQuote(AsyncCallback<String> callback);

}
