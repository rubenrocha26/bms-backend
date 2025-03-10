package dev.well.bms.service.impl;

import dev.well.bms.dto.BirdDto;
import dev.well.bms.entity.Bird;
import dev.well.bms.exception.ResourceNotFoundException;
import dev.well.bms.mapper.BirdMapper;
import dev.well.bms.repository.BirdRepository;
import dev.well.bms.service.IBirdService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BirdServiceImpl implements IBirdService {

    private BirdRepository birdRepository;
    private BirdMapper birdMapper;

    public BirdServiceImpl (BirdRepository birdRepository, BirdMapper birdMapper){
        this.birdRepository = birdRepository;
        this.birdMapper = birdMapper;
    }

    @Override
    public BirdDto createBird(BirdDto birdDto) {

        Bird bird = birdMapper.mapToBird(birdDto);

        //If birdRingAlready registered
        if(birdRepository.existsByBirdRing(bird.getBirdRing())){
            throw new IllegalArgumentException("Bird with the same birdRing already exists");
        }else {
            Bird savedBird = birdRepository.save(bird);

            return birdMapper.mapToBirdDto(savedBird);
        }
    }

    @Override
    public BirdDto getBirdById(Long birdId) {
        Bird bird = birdRepository.findById(birdId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Bird does not exist with given id : " + birdId));
        return birdMapper.mapToBirdDto(bird);
    }

    @Override
    public List<BirdDto> getAllBirds() {
        List<Bird> birds = birdRepository.findAll();

        return birds.stream().map((bird ) -> birdMapper.mapToBirdDto(bird) ).collect(Collectors.toList());
    }

    @Override
    public BirdDto updateBird(Long birdId, BirdDto updatedBird) {
        Bird bird = birdRepository.findById(birdId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Bird does not exist with given id : " + birdId));
        bird.setScientificName(updatedBird.getScientificName());
        bird.setMutation(updatedBird.getMutation());
        bird.setBirdRing(updatedBird.getBirdRing());
        bird.setDateOfBirth(updatedBird.getDateOfBirth());

        Bird updatedBirdFromRepository = birdRepository.save(bird);

        return birdMapper.mapToBirdDto(updatedBirdFromRepository);
    }

    @Override
    public void deleteBird(Long birdId) {
        Bird bird = birdRepository.findById(birdId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Bird does not exist with given id : " + birdId));

        birdRepository.deleteById(birdId);
    }
}
