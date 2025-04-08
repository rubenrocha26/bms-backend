package dev.well.bms.mapper;

import dev.well.bms.dto.BirdDto;
import dev.well.bms.domain.Bird;
import dev.well.bms.factory.BirdDtoFactory;
import dev.well.bms.factory.BirdFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BirdMapperTest {

    @Test
    void canCreateBirdMapperWithAllArgs(){
        //arrange
        BirdFactory birdFactory = new BirdFactory();
        BirdDtoFactory birdDtoFactory = new BirdDtoFactory();
        //act
        BirdMapper birdMapper = new BirdMapper(birdFactory, birdDtoFactory);
        //assert
        assertNotNull(birdMapper);
    }

    @Test
    void birdCanBeMappedToBirdDto() {
        //arrange
        Bird bird = new Bird(1L,"pintassilgo", "branco", "AG1", "07-02-2001");
        BirdFactory birdFactory = new BirdFactory();
        BirdDtoFactory birdDtoFactory = new BirdDtoFactory();
        BirdMapper birdMapper = new BirdMapper(birdFactory,birdDtoFactory);
        //act
        BirdDto birdDto = birdMapper.mapToBirdDto(bird);
        //assert
        assertNotNull(birdDto);
        assertEquals("pintassilgo", birdDto.getScientificName());
    }

    @Test
    void birdDtoCanBeMappedToBird() {
        //arrange
        BirdDto birdDto = new BirdDto(1L,"pintassilgo", "branco", "AG1", "07-02-2001");
        BirdFactory birdFactory = new BirdFactory();
        BirdDtoFactory birdDtoFactory = new BirdDtoFactory();
        BirdMapper birdMapper = new BirdMapper(birdFactory,birdDtoFactory);
        //act
        Bird bird = birdMapper.mapToBird(birdDto);
        //assert
        assertNotNull(bird);
        assertEquals("pintassilgo", bird.getScientificName());
    }

    //Isolation Tests
    @Test
    void birdCanBeMappedToBirdDtoIsolationTest(){
        //arrange
        Bird doubleBird = mock(Bird.class);
        BirdDto doubleBirdDto = mock(BirdDto.class);
        BirdFactory birdFactory = mock(BirdFactory.class);
        BirdDtoFactory birdDtoFactory = mock(BirdDtoFactory.class);
        BirdMapper birdMapper = new BirdMapper(birdFactory, birdDtoFactory);

        when(doubleBird.getId()).thenReturn(1L);
        when(doubleBird.getScientificName()).thenReturn("pintassilgo");
        when(doubleBird.getMutation()).thenReturn("branco");
        when(doubleBird.getBirdRing()).thenReturn("AG1");
        when(doubleBird.getDateOfBirth()).thenReturn("07-02-2001");

        when(birdDtoFactory.createBirdDto(1L,"pintassilgo","branco", "AG1", "07-02-2001")).thenReturn(doubleBirdDto);

        //act
        BirdDto birdDto = birdMapper.mapToBirdDto(doubleBird);
        //assert
        assertNotNull(birdDto);
    }

    @Test
    void birdDtoCanBeMappedToBirdIsolationTest(){
        //arrange
        Bird doubleBird = mock(Bird.class);
        BirdDto doubleBirdDto = mock(BirdDto.class);
        BirdFactory birdFactory = mock(BirdFactory.class);
        BirdDtoFactory birdDtoFactory = mock(BirdDtoFactory.class);
        BirdMapper birdMapper = new BirdMapper(birdFactory, birdDtoFactory);

        when(doubleBirdDto.getId()).thenReturn(1L);
        when(doubleBirdDto.getScientificName()).thenReturn("pintassilgo");
        when(doubleBirdDto.getMutation()).thenReturn("branco");
        when(doubleBirdDto.getBirdRing()).thenReturn("AG1");
        when(doubleBirdDto.getDateOfBirth()).thenReturn("07-02-2001");

        when(birdFactory.createBird(1L,"pintassilgo","branco", "AG1", "07-02-2001")).thenReturn(doubleBird);
        //act
        Bird bird = birdMapper.mapToBird(doubleBirdDto);
        //assert
        assertNotNull(bird);
    }
}