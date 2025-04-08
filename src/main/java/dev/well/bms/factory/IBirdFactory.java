package dev.well.bms.factory;

import dev.well.bms.domain.Bird;

public interface IBirdFactory {
    Bird createBird (Long id, String scientificName, String mutation, String birdRing, String dateOfBirth);
}
