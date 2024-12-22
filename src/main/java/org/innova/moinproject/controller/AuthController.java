package org.innova.moinproject.controller;


import org.innova.moinproject.dto.auth.AuthRequestDto;
import org.innova.moinproject.service.SoapAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final SoapAuthService soapAuthService;

    public AuthController(SoapAuthService soapAuthService) {
        this.soapAuthService = soapAuthService;
    }


    @PostMapping()
    public ResponseEntity<String> authenticateUser(@RequestBody AuthRequestDto requestDto) {
        String authToken = soapAuthService.authenticateUser(requestDto);
        if (authToken != null) {
            return ResponseEntity.ok("Authentication successful, token: " + authToken);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }
}
