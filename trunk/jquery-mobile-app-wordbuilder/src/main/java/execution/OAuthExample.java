package execution;

/* Copyright (c) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.GoogleApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

/**
 * Sample application using OAuth in the Google Data Java Client. See the
 * comments below to learn about the details.
 * 
 * 
 */
class OAuthExample {

        private static String googleRequestURL = "https://www.googleapis.com/oauth2/v1/userinfo";

        public static void main(String[] args) throws Exception {

                OAuthService service = new ServiceBuilder()
                                .apiKey("956472147350.apps.googleusercontent.com")
                                .apiSecret("-XowDwvlhiYagCIg78yYwcQS")
                                .provider(GoogleApi.class)
                                // The "scope" parameter is required to specify the type of requests to be made.
                                .scope("https://www.googleapis.com/auth/userinfo.email") 
                                .build();

                /**
                 * Commented out the code for getting the authorization tokens.
                 * 
                 */
//                Token requestToken = service.getRequestToken();
//                String requestUrl = service.getAuthorizationUrl(requestToken);
//                System.out.println(requestUrl);
//                System.out.println("Please visit the URL above to authorize your OAuth "
//                                + "request token.  Once that is complete, enter the verifier to "
//                                + "continue...");
//                String verifier = "";
//                while (true) {
//                        try {
//                                int tmp = System.in.read();
//                                char c = (char) tmp;
//                                if (c == '\n')
//                                        break;                                
//                                verifier = verifier + c;
//                        } catch (IOException e) {
//                        }
//                }
//                System.out.println("Verifier is => " + verifier);
//        
//                Token accessToken = service.getAccessToken(requestToken,
//                                new Verifier(verifier));
//                System.out.println(accessToken.getToken());
//                System.out.println(accessToken.getSecret());
                
                Token accessToken = new Token("1/x0cFdCqxALInmpvl3UClLHGkV7la-6FxvG8p7un4Fd4", "chSaTbApwFW_ob10ilq4bRj7");

                System.out.println("Making a call to Google API");
                OAuthRequest request = new OAuthRequest(Verb.GET, googleRequestURL + "?access_token" + accessToken.getToken());
                service.signRequest(accessToken, request);
                Response response = request.send();
                System.out.println("Response " + response.getBody());
        }
}
