package dev.well.bms.mapper;

import dev.well.bms.dto.BirdDto;
import dev.well.bms.domain.Bird;
import dev.well.bms.factory.BirdDtoFactory;
import dev.well.bms.factory.BirdFactory;
import org.springframework.stereotype.Component;

@Component
public class BirdMapper {

    private BirdFactory birdFactory;
    private BirdDtoFactory birdDtoFactory;

    public BirdMapper (BirdFactory birdFactory, BirdDtoFactory birdDtoFactory){
        this.birdFactory = birdFactory;
        this.birdDtoFactory = birdDtoFactory;
    }


    public BirdDto mapToBirdDto (Bird bird){
        Long id = bird.getId();
        String scientificName = bird.getScientificName();
        String mutation = bird.getMutation();
        String birdRing = bird.getBirdRing();
        String dateOfBirth = bird.getDateOfBirth();

        return birdDtoFactory.createBirdDto(id, scientificName, mutation, birdRing, dateOfBirth);
    }

    public Bird mapToBird(BirdDto birdDto){
        Long id = birdDto.getId();
        String scientificName = birdDto.getScientificName();
        String mutation = birdDto.getMutation();
        String birdRing = birdDto.getBirdRing();
        String dateOfBirth = birdDto.getDateOfBirth();

        return birdFactory.createBird(id,scientificName,mutation,birdRing,dateOfBirth);
    }
}
