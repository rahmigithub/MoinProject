package org.innova.moinproject.utility;

import org.innova.moinproject.dto.fault.CancelFaultRequestDto;
import org.innova.moinproject.dto.fault.CompleteFaultRequestDto;
import org.innova.moinproject.dto.fault.CreateFaultRequestDto;
import org.innova.moinproject.dto.fault.UpdateFaultRequestDto;
import org.springframework.stereotype.Component;

@Component
public class SoapFaultRequestBuilder {

    public String createFaultRequest(CreateFaultRequestDto requestDto) {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                + "<soapenv:Header/>"
                + "<soapenv:Body>"
                + "<customerNumber>" + requestDto.getCustomerNumber() + "</customerNumber>"
                + "<faultType>" + requestDto.getFaultType() + "</faultType>"
                + "<faultDescription>" + requestDto.getFaultDescription() + "</faultDescription>"
                + "</soapenv:Body>"
                + "</soapenv:Envelope>";
    }

    public String updateFaultRequest(UpdateFaultRequestDto requestDto) {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" >"
                + "<soapenv:Header/>"
                + "<soapenv:Body>"
                + "<faultUUID>" + requestDto.getFaultUUID() + "</faultUUID>"
                + "<faultType>" + requestDto.getFaultType() + "</faultType>"
                + "<faultDescription>" + requestDto.getFaultDescription() + "</faultDescription>"
                + "</soapenv:Body>"
                + "</soapenv:Envelope>";
    }

    public String cancelFaultRequest(CancelFaultRequestDto requestDto) {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" >"
                + "<soapenv:Header/>"
                + "<soapenv:Body>"
                + "<faultUUID>" + requestDto.getFaultUUID() + "</faultUUID>"
                + "<cancelReason>" + requestDto.getCancelReason() + "</cancelReason>"
                + "</soapenv:Body>"
                + "</soapenv:Envelope>";
    }

    public String completeFaultRequest(CompleteFaultRequestDto requestDto) {
        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" >"
                + "<soapenv:Header/>"
                + "<soapenv:Body>"
                + "<faultUUID>" + requestDto.getFaultUUID() + "</faultUUID>"
                + "<satisfactionScore>" + requestDto.getSatisfactionScore() + "</satisfactionScore>"
                + "</soapenv:Body>"
                + "</soapenv:Envelope>";
    }
}
