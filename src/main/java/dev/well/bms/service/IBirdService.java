package dev.well.bms.service;

import dev.well.bms.dto.BirdDto;

import java.util.List;

public interface IBirdService {
    BirdDto createBird (BirdDto birdDto);

    BirdDto getBirdById (Long birdId);

    List<BirdDto> getAllBirds();
}
