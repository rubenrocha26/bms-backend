package dev.well.bms.factory;

import dev.well.bms.entity.Bird;
import org.springframework.stereotype.Component;

@Component
public class BirdFactory implements IBirdFactory{
    public Bird createBird (Long id, String scientificName, String mutation, String birdRing, String dateOfBirth){
        return new Bird(id,scientificName,mutation,birdRing,dateOfBirth);
    }
}
