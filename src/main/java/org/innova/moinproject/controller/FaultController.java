package org.innova.moinproject.controller;

import org.innova.moinproject.dto.fault.CancelFaultRequestDto;
import org.innova.moinproject.dto.fault.CompleteFaultRequestDto;
import org.innova.moinproject.dto.fault.CreateFaultRequestDto;
import org.innova.moinproject.dto.fault.UpdateFaultRequestDto;
import org.innova.moinproject.service.SoapFaultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/faults")
public class FaultController {

    private final SoapFaultService soapRequestService;

    public FaultController(SoapFaultService soapRequestService) {
        this.soapRequestService = soapRequestService;
    }

    @PostMapping("/new")
    public ResponseEntity<UUID> createFault(@RequestBody CreateFaultRequestDto requestDto) {
        return ResponseEntity.ok(soapRequestService.createFault(requestDto));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateFault(@RequestBody UpdateFaultRequestDto requestDto) {
        return ResponseEntity.ok(soapRequestService.updateFault(requestDto));
    }

    @GetMapping("/cancel")
    public ResponseEntity<String> cancelFault(@RequestBody CancelFaultRequestDto requestDto) {
        return ResponseEntity.ok(soapRequestService.cancelFault(requestDto));
    }

    @PostMapping("/complete")
    public ResponseEntity<String> completeFault(@RequestBody CompleteFaultRequestDto requestDto) {
        return ResponseEntity.ok(soapRequestService.completeFault(requestDto));
    }
}

