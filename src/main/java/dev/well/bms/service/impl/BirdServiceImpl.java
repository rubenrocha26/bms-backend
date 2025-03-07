package dev.well.bms.service.impl;

import dev.well.bms.dto.BirdDto;
import dev.well.bms.entity.Bird;
import dev.well.bms.mapper.BirdMapper;
import dev.well.bms.repository.BirdRepository;
import dev.well.bms.service.IBirdService;
import org.springframework.stereotype.Service;

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
        Bird savedBird = birdRepository.save(bird);

        return birdMapper.mapToBirdDto(savedBird);
    }
}
