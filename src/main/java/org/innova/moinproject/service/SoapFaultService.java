package org.innova.moinproject.service;

import org.innova.moinproject.dto.fault.CancelFaultRequestDto;
import org.innova.moinproject.dto.fault.CompleteFaultRequestDto;
import org.innova.moinproject.dto.fault.CreateFaultRequestDto;
import org.innova.moinproject.dto.fault.UpdateFaultRequestDto;
import org.innova.moinproject.utility.SoapFaultRequestBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class SoapFaultService {
    private final RestTemplate restTemplate;
    private final SoapFaultRequestBuilder soapFaultRequestBuilder;

    @Value("${soap.fault.url}")
    private String soapFaultUrl;

    public SoapFaultService(RestTemplate restTemplate, SoapFaultRequestBuilder soapFaultRequestBuilder) {
        this.restTemplate = restTemplate;
        this.soapFaultRequestBuilder = soapFaultRequestBuilder;
    }

    public UUID createFault(CreateFaultRequestDto requestDto) {
        String soapRequest = soapFaultRequestBuilder.createFaultRequest(requestDto);
        String response = sendSoapRequest(soapRequest, soapFaultUrl);
        return extractFaultUUID(response);
    }

    public String updateFault(UpdateFaultRequestDto requestDto) {
        String soapRequest = soapFaultRequestBuilder.updateFaultRequest(requestDto);
        String response = sendSoapRequest(soapRequest, soapFaultUrl);
        return extractStatus(response);
    }

    public String cancelFault(CancelFaultRequestDto requestDto) {
        String soapRequest = soapFaultRequestBuilder.cancelFaultRequest(requestDto);
        String response = sendSoapRequest(soapRequest, soapFaultUrl);
        return extractStatus(response);
    }

    public String completeFault(CompleteFaultRequestDto requestDto) {
        String soapRequest = soapFaultRequestBuilder.completeFaultRequest(requestDto);
        String response = sendSoapRequest(soapRequest, soapFaultUrl);
        return extractStatus(response);
    }

    private String sendSoapRequest(String soapRequest, String url) {
        return restTemplate.postForObject(url, soapRequest, String.class);
    }

    private UUID extractFaultUUID(String response) {
        int start = response.indexOf("<faultUUID>") +11 ;
        int end = response.indexOf("</faultUUID>");
        return UUID.fromString(response.substring(start, end));
    }

    private String extractStatus(String response) {
        int start = response.indexOf("<status>") +8 ;
        int end = response.indexOf("</status>");
        return response.substring(start, end);

    }
}
