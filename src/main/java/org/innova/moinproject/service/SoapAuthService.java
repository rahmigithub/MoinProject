package org.innova.moinproject.service;


import org.innova.moinproject.dto.auth.AuthRequestDto;
import org.innova.moinproject.utility.SoapAuthRequestBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SoapAuthService {

    private final RestTemplate restTemplate;
    private final SoapAuthRequestBuilder soapAuthRequestBuilder;

    @Value("${soap.auth.url}")
    private String soapAuthUrl;

    public SoapAuthService(RestTemplate restTemplate, SoapAuthRequestBuilder soapAuthRequestBuilder) {
        this.restTemplate = restTemplate;
        this.soapAuthRequestBuilder = soapAuthRequestBuilder;
    }

    public String authenticateUser(AuthRequestDto requestDto) {
        String soapRequest = soapAuthRequestBuilder.createAuthRequest(requestDto);
        String response = sendSoapRequest(soapRequest, soapAuthUrl);
        return extractAuthToken(response);
    }

    private String sendSoapRequest(String soapRequest, String url) {
        return restTemplate.postForObject(url, soapRequest, String.class);
    }

    private String extractAuthToken(String response) {
        int start = response.indexOf("<authToken>") + 11;
        int end = response.indexOf("</authToken>");
        return response.substring(start, end);
    }
}
