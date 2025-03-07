package dev.well.bms.factory;

import dev.well.bms.dto.BirdDto;
import org.springframework.stereotype.Component;

@Component
public class BirdDtoFactory implements IBirdDtoFactory{
    public BirdDto createBirdDto (Long id, String scientificName, String mutation, String birdRing, String dateOfBirth){
        return new BirdDto (id, scientificName, mutation, birdRing, dateOfBirth);
    }
}
