package com.example.edaappserver.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(path = "api/v1/user/")
@RequiredArgsConstructor
public class UserController {
    private final String fileStorageLocation = System.getProperty("user.dir") + "\\ServerPictures";
    @GetMapping("/MenuItemPictures/{category}/{id}")
    public ResponseEntity<Resource> serveFile(
            @PathVariable String id,
            @PathVariable String category) throws IOException {
        Path filePath = Paths.get(fileStorageLocation).resolve(category + "\\" + id + ".png");
        Resource resource = new UrlResource(filePath.toUri());
        System.out.println("чето вывело " + id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }


//    @GetMapping("/files/{fileName:.+}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws MalformedURLException, MalformedURLException {
//        Path filePath = Paths.get(fileStorageLocation).resolve(fileName).normalize();
//        Resource resource = new UrlResource(filePath.toUri());
//
//        if (!resource.exists()) {
//            throw new RuntimeException("File not found: " + fileName);
//        }
//
//        return ResponseEntity.ok().body(resource);
//    }
}
