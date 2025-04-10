package dev.well.bms.domain.valueObject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {
    @Test
    void shouldCreateColorWithValidValues() {
        //arrange
        String color = "red";
        //act
        Color colorObject = new Color(color);
        //assert
        assertNotNull(colorObject);
    }

    @Test
    void shouldThrowExceptionWhenParameterIsNull() {
        //arrange
        String color = null;
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new Color(color));
    }

    @Test
    void shouldThrowExceptionWhenParameterIsEmpty() {
        //arrange
        String color = "";
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new Color(color));
    }

    @Test
    void testEquals() {
        //arrange
        String color1 = "red";
        String color2 = "blue";
        Color colorObject1 = new Color(color1);
        Color colorObject2 = new Color(color2);
        Color colorObject3 = new Color(color1);
        //act
        boolean result1 = colorObject1.equals(colorObject1);
        boolean result2 = colorObject1.equals(colorObject2);
        boolean result3 = colorObject1.equals(color1);
        boolean result4 = colorObject1.equals(colorObject3);
        //assert
        assertTrue(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertTrue(result4);
    }

    @Test
    void testToString() {
        //arrange
        String color1 = "red";
        Color colorObject = new Color(color1);
        //act
        String result1 = colorObject.toString();
        //assert
        assertEquals(color1, result1);
    }
}