package com.app.vaidyaa.server;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.LinkedInApi;
import org.scribe.builder.api.YahooApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Sample application using OAuth in the Google Data Java Client. See the
 * comments below to learn about the details.
 * 
 * 
 */
class OAuthExample {

        private static String yahooRequestURL = "http://yboss.yahooapis.com/ysearch/web?q=Mary%20Corbett%20Pacific%20Biosciences%20LinkedIn&format=json";

        public static void main(String[] args) throws Exception {

                OAuthService service = new ServiceBuilder()
                                .apiKey("dj0yJmk9VUhBa3JiVEprNDBQJmQ9WVdrOVJuWlVSVnBvTXpBbWNHbzlNVGd5TURZeU5qYzJNZy0tJnM9Y29uc3VtZXJzZWNyZXQmeD04Mw--")
                                .apiSecret("71b9644f89bf063776fdf59abc143d32d76e9f15")
                                .provider(YahooApi.class)
                                .build();

                Token requestToken = service.getRequestToken();
                String requestUrl = service.getAuthorizationUrl(requestToken);
                System.out.println(requestToken.getRawResponse());
                System.out.println(requestUrl);
                System.out.println("Please visit the URL above to authorize your OAuth "
                                + "request token.  Once that is complete, enter the verifier to "
                                + "continue...");
                String verifier = "";
                while (true) {
                        try {
                                int tmp = System.in.read();
                                char c = (char) tmp;
                                if (c == '\n')
                                        break;                                
                                verifier = verifier + c;
                        } catch (IOException e) {
                        }
                }
                verifier = verifier.trim();
                System.out.println("Verifier is => " + verifier);
        
                Token accessToken = service.getAccessToken(requestToken,
                                new Verifier(verifier));
                System.out.println(accessToken.getToken());
                System.out.println(accessToken.getSecret());
                
                System.out.println("Making a call to API");
                OAuthRequest request = new OAuthRequest(Verb.GET, yahooRequestURL);
                service.signRequest(accessToken, request);
                Response response = request.send();
                String responseBody  = response.getBody();
//                String responseBody = "{\"bossresponse\":{\"responsecode\":\"200\",\"web\":{\"start\":\"0\",\"count\":\"50\",\"totalresults\":\"139\",\"results\":[{\"date\": \"\",\"clickurl\":\"http:////www.linkedin.com//pub//gayatri-deo//16//183//618\",\"url\":\"http:////www.linkedin.com//pub//gayatri-deo//16//183//618\",\"dispurl\":\"www.<b>linkedin<//b>.com//pub//<b>gayatri<//b>-<b>deo<//b>//16//183//618\",\"title\":\"<b>Gayatri Deo | LinkedIn<//b>\",\"abstract\":\"View <b>Gayatri<//b> <b>Deo<//b>'s professional profile on <b>LinkedIn<//b>. Experience: Software Developer, InsideView, Inc.\"}]}}}";
                System.out.println("Response " + response.getBody());
                
                JSONBossResponse jSONBossResponse = new Gson().fromJson(responseBody,
    					new TypeToken<JSONBossResponse>() {
    					}.getType());
                if (jSONBossResponse != null && jSONBossResponse.getBossResponse()!=null && jSONBossResponse.getBossResponse().getResponsecode().equals("200")) {
                	for (Results results : jSONBossResponse.getBossResponse().getWeb().getResults()) {
                		System.out.println(results.getClickurl());
                	}
                }

        }
}
