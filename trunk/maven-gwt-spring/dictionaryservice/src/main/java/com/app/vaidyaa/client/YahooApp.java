package com.app.vaidyaa.client;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.YahooApi;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class YahooApp implements EntryPoint {

        @Override
        public void onModuleLoad() {
                OAuthService service = new ServiceBuilder()
                                .apiKey("dj0yJmk9eXBXUE42dVdpYTVnJmQ9WVdrOWVESkNWWFZHTjJVbWNHbzlOall6TnprME1EWXkmcz1jb25zdW1lcnNlY3JldCZ4PTU3")
                                .apiSecret("308549b80bfd9d7b933fd1a7dbceea57ee577f61")
                                .provider(YahooApi.class).build();

                Token requestToken = service.getRequestToken();
                final String requestUrl = service.getAuthorizationUrl(requestToken);
                
                Button openWindow = new Button("Please click here to authorize");
                openWindow.addClickHandler(new ClickHandler() {
                        
                    public void onClick(final ClickEvent clickEvent) {
                        Window.open(requestUrl, null, null);
                    }
                });
                RootPanel.get().add(openWindow);
        }

}
