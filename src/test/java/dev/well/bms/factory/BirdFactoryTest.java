package dev.well.bms.factory;

import dev.well.bms.entity.Bird;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirdFactoryTest {

    @Test
    void createBird() {
        //arrange
        BirdFactory birdFactory = new BirdFactory();
        //act
        Bird bird = birdFactory.createBird(1L,"pintassilgo", "branco", "AG1", "07-02-2001");
        //assert
        assertNotNull(bird);
    }
}