package dev.well.bms.controller;

import dev.well.bms.dto.BirdDto;
import dev.well.bms.service.impl.BirdServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //Get Bird REST API
    @GetMapping("{id}")
    public ResponseEntity<BirdDto> getBirdById (@PathVariable("id") Long birdId){
        BirdDto birdDto = birdService.getBirdById(birdId);
        return  ResponseEntity.ok(birdDto);
    }

    //Get All Birds REST API
    @GetMapping
    public ResponseEntity<List<BirdDto>> getAllBirds(){
        List<BirdDto> birds = birdService.getAllBirds();
        return ResponseEntity.ok(birds);
    }

    //Update Bird REST API
    @PutMapping("{id}")
    public ResponseEntity<BirdDto> updateBird (@PathVariable("id") Long birdId, @RequestBody BirdDto birdDto){
        BirdDto updatedBirdDto = birdService.updateBird(birdId, birdDto);
        return ResponseEntity.ok(updatedBirdDto);
    }
}
