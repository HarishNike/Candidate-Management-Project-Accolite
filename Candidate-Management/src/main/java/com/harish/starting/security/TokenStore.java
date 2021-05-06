package com.harish.starting.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.stereotype.Component;

import java.net.HttpCookie;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class TokenStore {
	@Autowired
	OAuth2AuthorizedClientService clientService;
	Instant start;
    private final Map< String, Authentication > cache = new HashMap<>();
HttpCookie cook;
Authentication a;
    public Map<String,String> generateToken( Authentication authentication ) {
        String token = UUID.randomUUID().toString();
        a=authentication;
//    	OAuth2AccessTokenResponse response=authentication;
       OAuth2AuthenticationToken oauthtoken=( OAuth2AuthenticationToken)authentication;
    	OAuth2AuthorizedClient client=clientService.loadAuthorizedClient(oauthtoken.getAuthorizedClientRegistrationId(),oauthtoken.getName());
//    	String token=client.getAccessToken().getTokenValue();
    	OAuth2RefreshToken refreshToken = new OAuth2RefreshToken("refresh-token", client.getAccessToken().getIssuedAt());	
    	Instant r=client.getAccessToken().getExpiresAt();
    	System.out.println("Expiration time "+refreshToken.getExpiresAt());
//    	String refresh=client.getRefreshToken().getTokenValue();
//    	System.out.println(token.toString());
    	Map<String,String> m=new HashMap<String,String>();
        m.put("accessToken", token);
        m.put("refreshToken", refreshToken.toString());
       cache.put( token, authentication );
       cache.put(refreshToken.toString(), authentication);
       cook=new HttpCookie("accessToken",token);
       cook.setMaxAge(0);
        start = Instant.now();
        return m;
    }

    public Authentication getAuth( String token ) {
//        return cache.getOrDefault( token, null );
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
    	String a1=cook.getValue();System.out.println("max age"+cook.getMaxAge());
//     System.out.println("ithu cookie"+a1);
//     System.out.println("ithu token"+token);
    	if(timeElapsed.toMillis()<=190000) {System.out.println("equal than"); return a;}
     System.out.println("not equal ahm");
     return null;
    
    }
}