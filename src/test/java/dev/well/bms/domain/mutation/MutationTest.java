package dev.well.bms.domain.mutation;

import dev.well.bms.domain.valueObject.Color;
import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.domain.valueObject.MutationId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MutationTest {
    @Test
    void shouldCreateMutationWithValidParameters() {
        //arrange
        MutationId mutationId = mock(MutationId.class);
        Color color = mock(Color.class);
        Description description = mock(Description.class);
        //act
        Mutation mutation = new Mutation(mutationId, color, description);
        //assert
        assertNotNull( mutation );
    }

    @Test
    void nullIdShouldThrowException() {
        //arrange
        Color color = mock(Color.class);
        Description description = mock(Description.class);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new Mutation(null, color, description));
    }

    @Test
    void nullColorShouldThrowException() {
        //arrange
        MutationId mutationId = mock(MutationId.class);
        Description description = mock(Description.class);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new Mutation(mutationId, null, description));
    }

    @Test
    void nullDescriptionShouldThrowException() {
        //arrange
        MutationId mutationId = mock(MutationId.class);
        Color color = mock(Color.class);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new Mutation(mutationId, color, null));
    }

    @Test
    void testEquals() {
        //arrange
        MutationId mutationId1 = mock(MutationId.class);
        Color color1 = mock(Color.class);
        Description description1 = mock(Description.class);
        MutationId mutationId2 = mock(MutationId.class);
        Color color2 = mock(Color.class);
        Description description2 = mock(Description.class);
        Mutation mutation = new Mutation(mutationId1, color1, description1);
        Mutation mutation2 = new Mutation(mutationId1, color1, description1);
        Mutation mutation3 = new Mutation(mutationId2, color2, description2);
        //act
        boolean result1 = mutation.equals(mutation2);
        boolean result2 = mutation.equals(mutation3);
        boolean result3 = mutation.equals(mutation);
        boolean result4 = mutation.equals(mutationId1);
        //assert
        assertTrue(result1);
        assertFalse(result2);
        assertTrue(result3);
        assertFalse(result4);
    }

    @Test
    void identity() {
        //arrange
        MutationId mutationIdMock = mock(MutationId.class);
        Color color = mock(Color.class);
        Description description = mock(Description.class);
        Mutation mutation = new Mutation(mutationIdMock, color, description);
        //act
        MutationId mutationId1 = mutation.identity();
        //assert
        assertEquals(mutationIdMock, mutationId1);
    }

    @Test
    void sameAs() {
        //arrange
        MutationId mutationId1 = mock(MutationId.class);
        Color color1 = mock(Color.class);
        Description description1 = mock(Description.class);
        MutationId mutationId2 = mock(MutationId.class);
        Color color2 = mock(Color.class);
        Description description2 = mock(Description.class);
        Mutation mutation = new Mutation(mutationId1, color1, description1);
        Mutation mutation2 = new Mutation(mutationId2, color2, description2);
        Mutation mutation3 = new Mutation(mutationId1, color2, description1);
        Mutation mutation4 = new Mutation(mutationId2, color1, description2);
        Mutation mutation5 = new Mutation(mutationId2, color1, description1);
        Mutation mutation6 = new Mutation(mutationId1, color1, description1);
        //act
        boolean result1 = mutation.sameAs(mutation2);
        boolean result2 = mutation.sameAs(mutation3);
        boolean result3 = mutation.sameAs(mutation3);
        boolean result4 = mutation.sameAs(mutation4);
        boolean result5 = mutation.sameAs(mutation5);
        boolean result6 = mutation.sameAs(mutation6);
        boolean result7 = mutation.sameAs(mutationId1);
        //assert
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
        assertFalse(result5);
        assertTrue(result6);
        assertFalse(result7);
    }
}