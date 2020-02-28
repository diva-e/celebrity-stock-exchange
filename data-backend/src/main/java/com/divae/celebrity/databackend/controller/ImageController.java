package com.divae.celebrity.databackend.controller;

import java.io.IOException;

import com.divae.celebrity.databackend.services.ImageReaderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "*")
public class ImageController {

	private final ImageReaderService imageReaderService;

	public ImageController(ImageReaderService imageReaderService) {
		this.imageReaderService = imageReaderService;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	@ApiOperation("Get a celebrity image")
	public ResponseEntity<InputStreamResource> getImage(@PathVariable("id") String id) throws IOException {

		InputStreamResource imageResource = imageReaderService.getImageFromResourcesBy(id);

		if(imageResource != null) {

			return ResponseEntity
					.ok()
					.contentType(MediaType.IMAGE_JPEG)
					.body(imageResource);

        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
