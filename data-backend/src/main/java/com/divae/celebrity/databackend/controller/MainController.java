package com.divae.celebrity.databackend.controller;

import com.divae.celebrity.databackend.model.CelebrityModel;
import com.divae.celebrity.databackend.services.CelebrityReaderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get-celebrity/{id}")
    @ApiOperation("Get a celebrity")
    public ResponseEntity<CelebrityModel> getCelebrity(@PathVariable("id") String id) {

        final CelebrityModel modelFromDisk = celebrityReaderService.getCelebrityFromDiskBy(id);
        if (modelFromDisk != null) {
            return new ResponseEntity<>(modelFromDisk, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
