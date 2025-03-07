package dev.well.bms.factory;

import dev.well.bms.dto.BirdDto;

public interface IBirdDtoFactory {
    BirdDto createBirdDto (Long id, String scientificName, String mutation, String birdRing, String dateOfBirth);
}
