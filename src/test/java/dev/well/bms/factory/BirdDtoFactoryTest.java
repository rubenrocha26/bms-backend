package dev.well.bms.factory;

import dev.well.bms.dto.BirdDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirdDtoFactoryTest {

    @Test
    void createBirdDto() {
        //arrange
        BirdDtoFactory birdDtoFactory = new BirdDtoFactory();
        //act
        BirdDto birdDto = birdDtoFactory.createBirdDto(1L,"pintassilgo", "branco", "AG1", "07-02-2001");
        //assert
        assertNotNull(birdDto);
    }
}