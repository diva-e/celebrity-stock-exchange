package com.divae.celebrity.databackend.controller;

import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("images")
public class ImageController {

	@RequestMapping(value = "{id}", method = RequestMethod.GET,
			produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<InputStreamResource> getImage(@PathVariable("id") String id) throws IOException {

		ClassPathResource imgFile = new ClassPathResource("image/" + id + ".jpg");

		if(imgFile.exists()) {

			return ResponseEntity
					.ok()
					.contentType(MediaType.IMAGE_JPEG)
					.body(new InputStreamResource(imgFile.getInputStream()));

		} else {
			return ResponseEntity.notFound().build();
		}
	}
}