package com.scc.dog.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class UserContext {

    public static final String AUTHENTICATION_KEY = "X-SCC-authentification";
    public static final String AUTH_TOKEN     = "Authorization";

    private static final ThreadLocal<String> authToken= new ThreadLocal<String>();
    private static final ThreadLocal<String> authentificationKey= new ThreadLocal<String>();

    public static String getAuthToken() { return authToken.get(); }
    public static void setAuthToken(String aToken) {authToken.set(aToken);}

	public static String getAuthentificationKey() { return authentificationKey.get();}
	public static void setAuthentificationKey(String aKey) { authentificationKey.set(aKey);}

    public static HttpHeaders getHttpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(AUTHENTICATION_KEY, getAuthToken());
        return httpHeaders;
    }

}