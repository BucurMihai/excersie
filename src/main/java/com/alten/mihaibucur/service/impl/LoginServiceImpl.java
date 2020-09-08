package com.alten.mihaibucur.service.impl;

import com.alten.mihaibucur.service.interfaces.LoginService;
import com.alten.mihaibucur.service.util.Constants;
import com.alten.mihaibucur.service.data.JwtRequestData;
import com.alten.mihaibucur.service.data.JwtResponseData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class LoginServiceImpl implements LoginService {

    private final static String USERNAME_HEADER = "ionescu";
    private final static String ENDPOINT_PATH = "/login";


    @Override
    public String getToken() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = Constants.ENDPOINT_URL + ENDPOINT_PATH;
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set(Constants.CONTENT_HEADER_KEY,Constants.CONTENT_HEADER_VALUE);
        JwtRequestData jwtRequest = new JwtRequestData();
        jwtRequest.setUsername(USERNAME_HEADER);

        HttpEntity<JwtRequestData> request = new HttpEntity<>(jwtRequest, headers);
        ResponseEntity<JwtResponseData> result = restTemplate.postForEntity(uri, request, JwtResponseData.class);
        return result.getBody() != null ? result.getBody().getToken() : "";
    }
}
