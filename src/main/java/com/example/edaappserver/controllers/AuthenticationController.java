package com.example.edaappserver.controllers;

import com.example.edaappserver.requests.AuthenticationRequest;
import com.example.edaappserver.requests.ChangeRoleRequest;
import com.example.edaappserver.requests.RegisterRequest;
import com.example.edaappserver.responses.AuthenticationResponse;
import com.example.edaappserver.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/changeRole")
    public String changeRole(
            @RequestBody ChangeRoleRequest request
            ){
        return authenticationService.changeRole(request);
    }
}
