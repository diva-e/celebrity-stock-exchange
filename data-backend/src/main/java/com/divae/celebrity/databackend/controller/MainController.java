package com.divae.celebrity.databackend.controller;

import com.divae.celebrity.databackend.model.CelebrityModel;
import com.divae.celebrity.databackend.services.CelebrityReaderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    private final CelebrityReaderService celebrityReaderService;

    public MainController(CelebrityReaderService celebrityReaderService) {
        this.celebrityReaderService = celebrityReaderService;
    }


    @PostMapping("/add-celebrity")
    @ApiOperation("Creates a new celebrity")
    public ResponseEntity addNewCelebrity(@RequestBody final CelebrityModel celebrityModel) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-celebrity")
    @ApiOperation("Get a celebrity")
    public ResponseEntity<CelebrityModel> getCelebrity() {
        final CelebrityModel modelFromDisk = celebrityReaderService.getModelFromDisk();
        if (modelFromDisk != null) {
            return new ResponseEntity<>(modelFromDisk, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
