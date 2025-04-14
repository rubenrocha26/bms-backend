package dev.well.bms.mapper;

import dev.well.bms.domain.mutation.FactoryMutationImpl;
import dev.well.bms.domain.mutation.IFactoryMutation;
import dev.well.bms.domain.mutation.Mutation;
import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.domain.valueObject.MutationId;
import dev.well.bms.persistence.dataModel.MutationDataModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MapperMutationTest {
    @Test
    void shouldCreateMapperMutation(){
        //arrange
        //act
        MapperMutation mapperMutation = new MapperMutation();
        //assert
        assertNotNull(mapperMutation);
    }

    @Test
    void dataModelToDomain() {
        //arrange
        MapperMutation mapperMutation = new MapperMutation();
        MutationDataModel mutationDataModel = mock(MutationDataModel.class);
        when(mutationDataModel.getMutationId()).thenReturn("mutationId");
        when(mutationDataModel.getDescription()).thenReturn("description");
        //act
        Mutation result = mapperMutation.dataModelToDomain(mutationDataModel);
        //assert
        assertNotNull(result);
    }

    @Test
    void testDataModelToDomain() {
        MapperMutation mapperMutation = new MapperMutation();
        MutationDataModel mutationDataModel1 = mock(MutationDataModel.class);
        MutationDataModel mutationDataModel2 = mock(MutationDataModel.class);

        when(mutationDataModel1.getMutationId()).thenReturn("mutationId1");
        when(mutationDataModel1.getDescription()).thenReturn("description1");
        when(mutationDataModel2.getMutationId()).thenReturn("mutationId2");
        when(mutationDataModel2.getDescription()).thenReturn("description2");

        List<MutationDataModel> listDataModel = List.of(mutationDataModel1, mutationDataModel2);

        // act
        Iterable<Mutation> listMutationsDomain = mapperMutation.dataModelToDomain(listDataModel);

        // assert
        assertNotNull(listMutationsDomain);
        List<Mutation> mutations = new ArrayList<>();
        listMutationsDomain.forEach(mutations::add);
        assertEquals(2, mutations.size());
        assertEquals("mutationId1", mutations.get(0).identity().toString());
        assertEquals("description1", mutations.get(0).getDescription().toString());
        assertEquals("mutationId2", mutations.get(1).identity().toString());
        assertEquals("description2", mutations.get(1).getDescription().toString());
    }
    @Test
    void shouldReturnEmptyListWhenInputListIsEmpty() {
        // arrange
        MapperMutation mapperMutation = new MapperMutation();
        List<MutationDataModel> emptyList = new ArrayList<>();

        // act
        Iterable<Mutation> listMutationsDomain = mapperMutation.dataModelToDomain(emptyList);

        // assert
        assertNotNull(listMutationsDomain);
        List<Mutation> mutations = new ArrayList<>();
        listMutationsDomain.forEach(mutations::add);
        assertTrue(mutations.isEmpty());
    }

    @Test
    void shouldThrowExceptionWhenInputListIsNull() {
        // arrange
        MapperMutation mapperMutation = new MapperMutation();
        List<MutationDataModel> nullList = null;

        // act & assert
        assertThrows(NullPointerException.class, () -> mapperMutation.dataModelToDomain(nullList));
    }

    @Test
    void nullDataModelThrowsException() {
        //arrange
        MapperMutation mapperMutation = new MapperMutation();
        MutationDataModel mutationDataModel = null;
        //act + assert
        assertThrows(NullPointerException.class,() -> mapperMutation.dataModelToDomain(mutationDataModel));
    }
}