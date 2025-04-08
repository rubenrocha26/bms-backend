package dev.well.bms.controller;

import dev.well.bms.dto.BirdDto;
import dev.well.bms.domain.Bird;
import dev.well.bms.factory.BirdDtoFactory;
import dev.well.bms.factory.BirdFactory;
import dev.well.bms.service.impl.BirdServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BirdControllerTest {

    @Test
    void controllerCreateBirdIsolationTest() {
        //arrange
        BirdServiceImpl birdService = mock(BirdServiceImpl.class);
        BirdFactory birdFactory = mock(BirdFactory.class);
        Bird doubleBird = mock(Bird.class);
        BirdDtoFactory birdDtoFactory = mock(BirdDtoFactory.class);
        BirdDto doubleBirdDto = mock(BirdDto.class);

        when(doubleBird.getId()).thenReturn(1L);
        when(doubleBird.getScientificName()).thenReturn("pintassilgo");
        when(doubleBird.getMutation()).thenReturn("branco");
        when(doubleBird.getBirdRing()).thenReturn("AG1");
        when(doubleBird.getDateOfBirth()).thenReturn("07-02-2001");

        when(doubleBirdDto.getId()).thenReturn(1L);
        when(doubleBirdDto.getScientificName()).thenReturn("pintassilgo");
        when(doubleBirdDto.getMutation()).thenReturn("branco");
        when(doubleBirdDto.getBirdRing()).thenReturn("AG1");
        when(doubleBirdDto.getDateOfBirth()).thenReturn("07-02-2001");

        when(birdFactory.createBird(1L, "pintassilgo", "branco", "AG1", "07-02-2001")).thenReturn(doubleBird);
        when(birdDtoFactory.createBirdDto(1L, "pintassilgo", "branco", "AG1", "07-02-2001")).thenReturn(doubleBirdDto);

        when(birdService.createBird(doubleBirdDto)).thenReturn(doubleBirdDto);
        BirdController birdController = new BirdController(birdService);
        //act
        BirdDto savedBirdDto = birdController.createBird(doubleBirdDto).getBody();
        //assert
        assertNotNull(savedBirdDto);
    }

    @Test
    void controllerGetBirdByIdIsolationTest(){
        //arrange
        BirdServiceImpl birdService = mock(BirdServiceImpl.class);
        BirdFactory birdFactory = mock(BirdFactory.class);
        Bird doubleBird = mock(Bird.class);
        BirdDtoFactory birdDtoFactory = mock(BirdDtoFactory.class);
        BirdDto doubleBirdDto = mock(BirdDto.class);

        when(doubleBird.getId()).thenReturn(1L);
        when(doubleBird.getScientificName()).thenReturn("pintassilgo");
        when(doubleBird.getMutation()).thenReturn("branco");
        when(doubleBird.getBirdRing()).thenReturn("AG1");
        when(doubleBird.getDateOfBirth()).thenReturn("07-02-2001");

        when(doubleBirdDto.getId()).thenReturn(1L);
        when(doubleBirdDto.getScientificName()).thenReturn("pintassilgo");
        when(doubleBirdDto.getMutation()).thenReturn("branco");
        when(doubleBirdDto.getBirdRing()).thenReturn("AG1");
        when(doubleBirdDto.getDateOfBirth()).thenReturn("07-02-2001");

        when(birdFactory.createBird(1L, "pintassilgo", "branco", "AG1", "07-02-2001")).thenReturn(doubleBird);
        when(birdDtoFactory.createBirdDto(1L, "pintassilgo", "branco", "AG1", "07-02-2001")).thenReturn(doubleBirdDto);

        when(birdService.getBirdById(1L)).thenReturn(doubleBirdDto);
        BirdController birdController = new BirdController(birdService);
        //act
        BirdDto gotBirdDto = birdController.getBirdById(1L).getBody();
        //assert
        assertNotNull(gotBirdDto);
    }

    @Test
    void controllerGetAllBirdsIsolationTest(){
        //arrange
        BirdServiceImpl birdService = mock(BirdServiceImpl.class);
        BirdFactory birdFactory = mock(BirdFactory.class);
        Bird doubleBird = mock(Bird.class);
        BirdDtoFactory birdDtoFactory = mock(BirdDtoFactory.class);
        BirdDto doubleBirdDto = mock(BirdDto.class);

        when(doubleBird.getId()).thenReturn(1L);
        when(doubleBird.getScientificName()).thenReturn("pintassilgo");
        when(doubleBird.getMutation()).thenReturn("branco");
        when(doubleBird.getBirdRing()).thenReturn("AG1");
        when(doubleBird.getDateOfBirth()).thenReturn("07-02-2001");

        when(doubleBirdDto.getId()).thenReturn(1L);
        when(doubleBirdDto.getScientificName()).thenReturn("pintassilgo");
        when(doubleBirdDto.getMutation()).thenReturn("branco");
        when(doubleBirdDto.getBirdRing()).thenReturn("AG1");
        when(doubleBirdDto.getDateOfBirth()).thenReturn("07-02-2001");

        when(birdFactory.createBird(1L, "pintassilgo", "branco", "AG1", "07-02-2001")).thenReturn(doubleBird);
        when(birdDtoFactory.createBirdDto(1L, "pintassilgo", "branco", "AG1", "07-02-2001")).thenReturn(doubleBirdDto);

        when(birdService.createBird(doubleBirdDto)).thenReturn(doubleBirdDto);
        BirdController birdController = new BirdController(birdService);
        //act
        List<BirdDto> birds = birdController.getAllBirds().getBody();
        //assert
        assertNotNull(birds);
    }

    @Test
    void controllerUpdateBirdIsolationTest(){
        //arrange
        BirdServiceImpl birdService = mock(BirdServiceImpl.class);
        BirdFactory birdFactory = mock(BirdFactory.class);
        Bird doubleBird = mock(Bird.class);
        BirdDtoFactory birdDtoFactory = mock(BirdDtoFactory.class);
        BirdDto doubleBirdDto = mock(BirdDto.class);

        when(doubleBird.getId()).thenReturn(1L);
        when(doubleBird.getScientificName()).thenReturn("pintassilgo");
        when(doubleBird.getMutation()).thenReturn("branco");
        when(doubleBird.getBirdRing()).thenReturn("AG1");
        when(doubleBird.getDateOfBirth()).thenReturn("07-02-2001");

        when(doubleBirdDto.getId()).thenReturn(1L);
        when(doubleBirdDto.getScientificName()).thenReturn("pintassilgo");
        when(doubleBirdDto.getMutation()).thenReturn("branco");
        when(doubleBirdDto.getBirdRing()).thenReturn("AG1");
        when(doubleBirdDto.getDateOfBirth()).thenReturn("07-02-2001");

        when(birdFactory.createBird(1L, "pintassilgo", "branco", "AG1", "07-02-2001")).thenReturn(doubleBird);
        when(birdDtoFactory.createBirdDto(1L, "pintassilgo", "branco", "AG1", "07-02-2001")).thenReturn(doubleBirdDto);
        when(birdService.createBird(doubleBirdDto)).thenReturn(doubleBirdDto);
        when(birdService.updateBird(1L,doubleBirdDto)).thenReturn(doubleBirdDto);
        BirdController birdController = new BirdController(birdService);
        //act
        BirdDto birdDto = birdController.updateBird(1L, doubleBirdDto).getBody();
        //assert
        assertNotNull(birdDto);
    }
}