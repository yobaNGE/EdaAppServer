package com.example.edaappserver.controllers;

import com.example.edaappserver.requests.AuthenticationRequest;
import com.example.edaappserver.requests.RegisterRequest;
import com.example.edaappserver.responses.AuthenticationResponse;
import com.example.edaappserver.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }



//    @GetMapping("/getMenuItemPicture/{id}")
//    public ResponseEntity<Resource> serveFile(@PathVariable int id) throws IOException {
//        System.out.println("aaaaaaaaaaaaaa");
//        Path filePath = Paths.get(fileStorageLocation).resolve(id + ".jpg");
//        Resource resource = new UrlResource(filePath.toUri());
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .contentType(MediaType.IMAGE_JPEG)
//                .body(resource);
//    }
}
