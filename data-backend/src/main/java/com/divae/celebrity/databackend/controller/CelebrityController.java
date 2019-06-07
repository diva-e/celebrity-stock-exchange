package com.divae.celebrity.databackend.controller;

import com.divae.celebrity.databackend.model.CelebrityModel;
import com.divae.celebrity.databackend.services.CelebrityReaderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("celebrities")
public class CelebrityController {


    private final CelebrityReaderService celebrityReaderService;

    public CelebrityController(CelebrityReaderService celebrityReaderService) {
        this.celebrityReaderService = celebrityReaderService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{id}")
    @ApiOperation("Get a celebrity")
    public ResponseEntity<CelebrityModel> getCelebrity(@PathVariable("id") String id) {

        final CelebrityModel modelFromDisk = celebrityReaderService.getCelebrityFromResourcesBy(id);
        if (modelFromDisk != null) {
            return new ResponseEntity<>(modelFromDisk, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
