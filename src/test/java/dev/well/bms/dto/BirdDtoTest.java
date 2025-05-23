package dev.well.bms.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirdDtoTest {

    @Test
    void canCreateBirdWithAllArgs(){
        //arrange
        BirdDto bird = new BirdDto(1L, "pintassilgo", "branco", "AG2019", "03-04-2001");
        //act + assert
        assertNotNull(bird);
    }

    @Test
    void canCreateBirdWithNoArgs(){
        //arrange
        BirdDto bird = new BirdDto();
        //act + assert
        assertNotNull(bird);
    }

    @Test
    void getId() {
        //arrange
        BirdDto bird = new BirdDto(1L, "pintassilgo", "branco", "AG2019", "03-04-2001");
        //act
        Long result = bird.getId();
        //assert
        assertEquals(1L,result);
    }

    @Test
    void getScientificName() {
        //arrange
        BirdDto bird = new BirdDto(1L, "pintassilgo", "branco", "AG2019", "03-04-2001");
        //act
        String result = bird.getScientificName();
        //assert
        assertEquals("pintassilgo",result);
    }

    @Test
    void getMutation() {
        //arrange
        BirdDto bird = new BirdDto(1L, "pintassilgo", "branco", "AG2019", "03-04-2001");
        //act
        String result = bird.getMutation();
        //assert
        assertEquals("branco",result);
    }

    @Test
    void getBirdRing() {
        //arrange
        BirdDto bird = new BirdDto(1L, "pintassilgo", "branco", "AG2019", "03-04-2001");
        //act
        String result = bird.getBirdRing();
        //assert
        assertEquals("AG2019",result);
    }

    @Test
    void getDateOfBirth() {
        //arrange
        BirdDto bird = new BirdDto(1L, "pintassilgo", "branco", "AG2019", "03-04-2001");
        //act
        String result = bird.getDateOfBirth();
        //assert
        assertEquals("03-04-2001",result);
    }

    @Test
    void setId() {
        //arrange
        BirdDto bird = new BirdDto(1L, "pintassilgo", "branco", "AG2019", "03-04-2001");
        //act
        bird.setId(2L);
        Long result = bird.getId();
        //assert
        assertEquals(2L, result);
    }

    @Test
    void setScientificName() {
        //arrange
        BirdDto bird = new BirdDto(1L, "pintassilgo", "branco", "AG2019", "03-04-2001");
        //act
        bird.setScientificName("canario");
        String result = bird.getScientificName();
        //assert
        assertEquals("canario", result);
    }

    @Test
    void setMutation() {
        //arrange
        BirdDto bird = new BirdDto(1L, "pintassilgo", "branco", "AG2019", "03-04-2001");
        //act
        bird.setMutation("verde");
        String result = bird.getMutation();
        //assert
        assertEquals("verde", result);
    }

    @Test
    void setBirdRing() {
        //arrange
        BirdDto bird = new BirdDto(1L, "pintassilgo", "branco", "AG2019", "03-04-2001");
        //act
        bird.setBirdRing("AS2020");
        String result = bird.getBirdRing();
        //assert
        assertEquals("AS2020", result);
    }

    @Test
    void setDateOfBirth() {
        //arrange
        BirdDto bird = new BirdDto(1L, "pintassilgo", "branco", "AG2019", "03-04-2001");
        //act
        bird.setDateOfBirth("03-10-2002");
        String result = bird.getDateOfBirth();
        //assert
        assertEquals("03-10-2002", result);
    }
}