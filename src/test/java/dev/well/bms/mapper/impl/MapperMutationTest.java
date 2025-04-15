package dev.well.bms.mapper.impl;

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
        IFactoryMutation mutationFactory = mock(IFactoryMutation.class);
        //act
        MapperMutationSpringDataImpl mapperMutation = new MapperMutationSpringDataImpl(mutationFactory);
        //assert
        assertNotNull(mapperMutation);
    }

    @Test
    void shouldThrowExceptionWhenMutationFactoryIsNull(){
        //arrange
        IFactoryMutation mutationFactory = null;
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new MapperMutationSpringDataImpl(mutationFactory));
    }

    @Test
    void dataModelToDomain() {
        //arrange
        IFactoryMutation mutationFactory = mock(IFactoryMutation.class);
        MapperMutationSpringDataImpl mapperMutation = new MapperMutationSpringDataImpl(mutationFactory);
        MutationDataModel mutationDataModel = mock(MutationDataModel.class);
        when(mutationDataModel.getMutationId()).thenReturn("mutationId");
        when(mutationDataModel.getDescription()).thenReturn("description");

        Mutation mutation = mock(Mutation.class);
        when(mutation.identity()).thenReturn(new MutationId("mutationId"));
        when(mutation.getDescription()).thenReturn(new Description("description"));

        when(mutationFactory.createMutation(new MutationId("mutationId"), new Description("description"))).thenReturn(mutation);
        //act
        Mutation result = mapperMutation.dataModelToDomain(mutationDataModel);
        //assert
        assertNotNull(result);
        assertEquals("mutationId", result.identity().toString());
        assertEquals("description", result.getDescription().toString());
    }

    @Test
    void testDataModelToDomain() {
        // arrange
        IFactoryMutation mutationFactory = mock(IFactoryMutation.class);
        MapperMutationSpringDataImpl mapperMutation = new MapperMutationSpringDataImpl(mutationFactory);
        MutationDataModel mutationDataModel1 = mock(MutationDataModel.class);
        MutationDataModel mutationDataModel2 = mock(MutationDataModel.class);

        when(mutationDataModel1.getMutationId()).thenReturn("mutationId1");
        when(mutationDataModel1.getDescription()).thenReturn("description1");
        when(mutationDataModel2.getMutationId()).thenReturn("mutationId2");
        when(mutationDataModel2.getDescription()).thenReturn("description2");

        Mutation mutation1 = mock(Mutation.class);
        Mutation mutation2 = mock(Mutation.class);

        when(mutation1.identity()).thenReturn(new MutationId("mutationId1"));
        when(mutation1.getDescription()).thenReturn(new Description("description1"));
        when(mutation2.identity()).thenReturn(new MutationId("mutationId2"));
        when(mutation2.getDescription()).thenReturn(new Description("description2"));

        when(mutationFactory.createMutation(new MutationId("mutationId1"), new Description("description1"))).thenReturn(mutation1);
        when(mutationFactory.createMutation(new MutationId("mutationId2"), new Description("description2"))).thenReturn(mutation2);

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
        IFactoryMutation mutationFactory = mock(IFactoryMutation.class);
        MapperMutationSpringDataImpl mapperMutation = new MapperMutationSpringDataImpl(mutationFactory);
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
        IFactoryMutation mutationFactory = mock(IFactoryMutation.class);
        MapperMutationSpringDataImpl mapperMutation = new MapperMutationSpringDataImpl(mutationFactory);
        List<MutationDataModel> nullList = null;

        // act & assert
        assertThrows(NullPointerException.class, () -> mapperMutation.dataModelToDomain(nullList));
    }

    @Test
    void nullDataModelThrowsException() {
        //arrange
        IFactoryMutation mutationFactory = mock(IFactoryMutation.class);
        MapperMutationSpringDataImpl mapperMutation = new MapperMutationSpringDataImpl(mutationFactory);
        MutationDataModel mutationDataModel = null;
        //act + assert
        assertThrows(NullPointerException.class,() -> mapperMutation.dataModelToDomain(mutationDataModel));
    }
}