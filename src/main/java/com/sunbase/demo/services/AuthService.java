package com.sunbase.demo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class AuthService {

    @Value("${sunbasedata.auth.api.url}")
    private String apiUrl;

    public ResponseEntity<String> authenticate() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("login_id", "test@sunbasedata.com");
        requestBody.put("password", "Test@123");

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(apiUrl, requestEntity, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity;
        } else {
            throw new RuntimeException("Authentication failed. Status code: " + responseEntity.getStatusCode());
        }
    }
}
