package com.sunbase.demo.services;

import com.sunbase.demo.models.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Value("${api.base.url}")
    private String baseUrl;

    @Value("${sunbasedata.auth.token}")
    private String authToken;

    private final RestTemplate restTemplate;

    public CustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> createCustomer(Customer customer) {
        String url = baseUrl + "/assignment.jsp?cmd=create";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + authToken);

        HttpEntity<Customer> requestEntity = new HttpEntity<>(customer, headers);

        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );
    }

    public List<Customer> getCustomerList() {
        String url = baseUrl + "/assignment.jsp?cmd=get_customer_list";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<Customer[]> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                Customer[].class
        );

        return Arrays.asList(responseEntity.getBody());
    }

    public ResponseEntity<String> deleteCustomer(UUID uuid) {
        String url = baseUrl + "/assignment.jsp?cmd=delete&uuid=" + uuid;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authToken);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );
    }

    public ResponseEntity<String> updateCustomer(UUID uuid, Customer customer) {
        String url = baseUrl + "/assignment.jsp?cmd=update&uuid=" + uuid;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + authToken);

        HttpEntity<Customer> requestEntity = new HttpEntity<>(customer, headers);

        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );
    }
}
