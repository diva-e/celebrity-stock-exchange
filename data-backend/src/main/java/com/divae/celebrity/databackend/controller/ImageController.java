package com.divae.celebrity.databackend.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("images")
public class ImageController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{id}")
    @ApiOperation("Get a celebrity image")
    public ResponseEntity<InputStreamResource> getImage(@PathVariable("id") String id) throws IOException {

        ClassPathResource imgFile = new ClassPathResource("images/" + id + ".jpg");

        if (imgFile.exists()) {

            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new InputStreamResource(imgFile.getInputStream()));

        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
