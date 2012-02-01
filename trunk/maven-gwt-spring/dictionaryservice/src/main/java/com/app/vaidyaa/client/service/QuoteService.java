package com.app.vaidyaa.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("quote.rpc")
public interface QuoteService extends RemoteService {
    public String getQuote();
}
