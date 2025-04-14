package dev.well.bms.persistence.dataModel;

import dev.well.bms.domain.mutation.IFactoryMutation;
import dev.well.bms.domain.mutation.Mutation;
import dev.well.bms.domain.mutation.FactoryMutationImpl;
import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.domain.valueObject.MutationId;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MutationDataModelTest {

    @Test
    void shouldCreateMutationDataModel() {
        //arrange
        //act
        MutationDataModel mutationDataModel = new MutationDataModel();
        //assert
        assertNotNull(mutationDataModel);
    }

    @Test
    void shouldCreateMutationDataModelFromDomain() {
        //arrange
        MutationId mutationId = mock(MutationId.class);
        Description description = mock(Description.class);
        Mutation mutation = mock(Mutation.class);
        when(mutation.identity()).thenReturn(mutationId);
        when(mutationId.toString()).thenReturn("mutationId");
        when(mutation.getDescription()).thenReturn(description);
        when(description.toString()).thenReturn("description");
        //act
        MutationDataModel mutationDataModel = new MutationDataModel(mutation);
        //assert
        assertNotNull(mutationDataModel);
    }

    @Test
    void shouldReturnMutationId(){
        //arrange
        MutationId mutationId = mock(MutationId.class);
        Description description = mock(Description.class);
        Mutation mutation = mock(Mutation.class);
        when(mutation.identity()).thenReturn(mutationId);
        when(mutationId.toString()).thenReturn("mutationId");
        when(mutation.getDescription()).thenReturn(description);
        when(description.toString()).thenReturn("description");
        MutationDataModel mutationDataModel = new MutationDataModel(mutation);
        //act
        String result = mutationDataModel.getMutationId();
        //assert
        assertEquals("mutationId", result);
    }

    @Test
    void shouldReturnDescription(){
        //arrange
        MutationId mutationId = mock(MutationId.class);
        Description description = mock(Description.class);
        Mutation mutation = mock(Mutation.class);
        when(mutation.identity()).thenReturn(mutationId);
        when(mutationId.toString()).thenReturn("mutationId");
        when(mutation.getDescription()).thenReturn(description);
        when(description.toString()).thenReturn("description");
        MutationDataModel mutationDataModel = new MutationDataModel(mutation);
        //act
        String result = mutationDataModel.getDescription();
        //assert
        assertEquals("description", result);
    }
}