package dev.well.bms.domain.valueObject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirdScientificNameTest {

    @Test
    void shouldCreateBirdScientificNameWithValidValues() {
        //arrange
        String scientificName = "Pintassilgo";
        //act
        BirdScientificName birdScientificName = new BirdScientificName(scientificName);
        //assert
        assertNotNull(birdScientificName);
    }

    @Test
    void shouldThrowExceptionIfScientificNameIsNull() {
        //arrange
        String scientificName = null;
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new BirdScientificName(scientificName));
    }

    @Test
    void shouldThrowExceptionIfScientificNameIsEmpty() {
        //arrange
        String scientificName = "";
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new BirdScientificName(scientificName));
    }

    @Test
    void testEquals() {
        //arrange
        String scientificName = "Pintassilgo";
        BirdScientificName birdScientificName1 = new BirdScientificName(scientificName);
        BirdScientificName birdScientificName2 = new BirdScientificName(scientificName);
        //act
        boolean result = birdScientificName1.equals(birdScientificName1);
        boolean result2 = birdScientificName1.equals(birdScientificName2);
        boolean result3 = birdScientificName2.equals(scientificName);
        //assert
        assertTrue(result);
        assertTrue(result2);
        assertFalse(result3);
    }

    @Test
    void testToString() {
        //arrange
        String scientificName = "Pintassilgo";
        BirdScientificName birdScientificName = new BirdScientificName(scientificName);
        //act
        String string = birdScientificName.toString();
        //assert
        assertEquals(scientificName, string);

    }
}