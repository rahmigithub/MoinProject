package org.innova.moinproject.utility;

import org.innova.moinproject.dto.auth.AuthRequestDto;
import org.springframework.stereotype.Component;

@Component
public class SoapAuthRequestBuilder {

    public String createAuthRequest(AuthRequestDto requestDto) {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                + "<soapenv:Header/>"
                + "<soapenv:Body>"
                + "<username>" + requestDto.getUsername() + "</username>"
                + "<password>" + requestDto.getPassword() + "</password>"
                + "</soapenv:Body>"
                + "</soapenv:Envelope>";
    }
}
