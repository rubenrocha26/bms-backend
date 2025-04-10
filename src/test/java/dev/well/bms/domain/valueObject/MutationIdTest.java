package dev.well.bms.domain.valueObject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MutationIdTest {
    @Test
    void shouldCreateMutationId() {
        //arrange
        //act
        MutationId mutationId = new MutationId();
        //assert
        assertNotNull(mutationId);
    }

    @Test
    void testEquals() {
        //arrange
        MutationId mutationId1 = new MutationId();
        MutationId mutationId2 = new MutationId();
        String id1 = mutationId1.toString();
        //act
        boolean result1 = mutationId1.equals(mutationId1);
        boolean result2 = mutationId1.equals(mutationId2);
        boolean result3 = mutationId1.equals(id1);
        //assert
        assertTrue(result1);
        assertFalse(result2);
        assertFalse(result3);
    }

    @Test
    void testToString() {
        //arrange
        MutationId mutationId1 = new MutationId();
        //act
        String id1 = mutationId1.toString();
        //assert
        assertEquals(id1, mutationId1.toString());
    }
}