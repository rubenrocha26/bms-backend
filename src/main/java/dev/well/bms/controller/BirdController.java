package dev.well.bms.controller;

import dev.well.bms.dto.BirdDto;
import dev.well.bms.entity.Bird;
import dev.well.bms.service.impl.BirdServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/birds")
public class BirdController {

    private BirdServiceImpl birdService;

    public BirdController (BirdServiceImpl birdService){
        this.birdService = birdService;
    }

    //Add Bird REST API
    @PostMapping
    public ResponseEntity<BirdDto> createBird (@RequestBody BirdDto birdDto){
        BirdDto savedBird = birdService.createBird(birdDto);
        return new ResponseEntity<>(savedBird, HttpStatus.CREATED);

    }
}
