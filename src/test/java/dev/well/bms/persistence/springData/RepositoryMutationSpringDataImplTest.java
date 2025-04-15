package dev.well.bms.persistence.springData;

import dev.well.bms.domain.mutation.Mutation;
import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.domain.valueObject.MutationId;
import dev.well.bms.mapper.impl.MapperMutation;
import dev.well.bms.persistence.dataModel.MutationDataModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RepositoryMutationSpringDataImplTest {

    @Test
    void shouldCreateRepositoryMutation() {
        //arrange
        IRepositoryMutationSpringData mutationSpringData = mock(IRepositoryMutationSpringData.class);
        MapperMutation mapperMutation = mock(MapperMutation.class);
        //act
        RepositoryMutationSpringDataImpl repositoryMutationSpringData = new RepositoryMutationSpringDataImpl(mutationSpringData, mapperMutation);
        //assert
        assertNotNull(repositoryMutationSpringData);
    }

    @Test
    void shouldSaveMutation() {
        //arrange
        IRepositoryMutationSpringData mutationSpringData = mock(IRepositoryMutationSpringData.class);
        MapperMutation mapperMutation = mock(MapperMutation.class);
        RepositoryMutationSpringDataImpl repositoryMutationSpringData = new RepositoryMutationSpringDataImpl(mutationSpringData, mapperMutation);
        Mutation mutation = mock(Mutation.class);
        when(mutation.identity()).thenReturn(mock(MutationId.class));
        when(mutation.getDescription()).thenReturn(mock(Description.class));
        //act
        Mutation mutationSaved = repositoryMutationSpringData.save(mutation);
        //assert
        assertNotNull(mutationSaved);
    }

    @Test
    void shouldThrowExceptionWhenMutationIdIsNull() {
        //arrange
        IRepositoryMutationSpringData mutationSpringData = mock(IRepositoryMutationSpringData.class);
        MapperMutation mapperMutation = mock(MapperMutation.class);
        RepositoryMutationSpringDataImpl repositoryMutationSpringData = new RepositoryMutationSpringDataImpl(mutationSpringData, mapperMutation);
        Mutation mutation = null;
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> repositoryMutationSpringData.save(mutation));
    }

    @Test
    void findAll() {
        //arrange
        IRepositoryMutationSpringData mutationSpringData = mock(IRepositoryMutationSpringData.class);
        MapperMutation mapperMutation = mock(MapperMutation.class);
        RepositoryMutationSpringDataImpl repositoryMutationSpringData = new RepositoryMutationSpringDataImpl(mutationSpringData, mapperMutation);

        MutationDataModel mutationDataModel1 = mock(MutationDataModel.class);
        MutationDataModel mutationDataModel2 = mock(MutationDataModel.class);

        when(mutationSpringData.findAll()).thenReturn(List.of(mutationDataModel1, mutationDataModel2));

        Mutation mutation1 = mock(Mutation.class);
        Mutation mutation2 = mock(Mutation.class);

        when(mutation1.identity()).thenReturn(new MutationId("1"));
        when(mutation1.getDescription()).thenReturn(new Description("Claro"));
        when(mutation2.identity()).thenReturn(new MutationId("2"));
        when(mutation2.getDescription()).thenReturn(new Description("Escuro"));

        when(mapperMutation.dataModelToDomain(List.of(mutationDataModel1, mutationDataModel2))).thenReturn(List.of(mutation1, mutation2));

        //act
        Iterable<Mutation> mutations = repositoryMutationSpringData.findAll();
        //assert
        assertNotNull(mutations);
        List<Mutation> mutationList = new ArrayList<>();
        mutations.forEach(mutationList::add);
        assertEquals(2, mutationList.size());
        assertTrue(mutationList.stream().anyMatch(m -> m.identity().equals(new MutationId("1")) && m.getDescription().equals(new Description("Claro"))));
        assertTrue(mutationList.stream().anyMatch(m -> m.identity().equals(new MutationId("2")) && m.getDescription().equals(new Description("Escuro"))));
    }

    @Test
    void shouldReturnMutationWhenOfIdentityIsCalledWithValidId() {
        // arrange
        IRepositoryMutationSpringData mutationSpringData = mock(IRepositoryMutationSpringData.class);
        MapperMutation mapperMutation = mock(MapperMutation.class);
        RepositoryMutationSpringDataImpl repositoryMutationSpringData = new RepositoryMutationSpringDataImpl(mutationSpringData, mapperMutation);

        MutationId mutationId = new MutationId("1");
        MutationDataModel mutationDataModel = mock(MutationDataModel.class);
        when(mutationDataModel.getMutationId()).thenReturn("1");// Ensure valid ID is returned
        when(mutationDataModel.getDescription()).thenReturn("Claro");
        when(mutationSpringData.findById("1")).thenReturn(Optional.of(mutationDataModel));

        Mutation mutation = mock(Mutation.class);
        when(mapperMutation.dataModelToDomain(mutationDataModel)).thenReturn(mutation);

        // act
        Optional<Mutation> result = repositoryMutationSpringData.ofIdentity(mutationId);

        // assert
        assertTrue(result.isPresent());
        assertEquals(mutation, result.get());
    }

    @Test
    void shouldReturnEmptyWhenOfIdentityIsCalledWithInvalidId() {
        // arrange
        IRepositoryMutationSpringData mutationSpringData = mock(IRepositoryMutationSpringData.class);
        MapperMutation mapperMutation = mock(MapperMutation.class);
        RepositoryMutationSpringDataImpl repositoryMutationSpringData = new RepositoryMutationSpringDataImpl(mutationSpringData, mapperMutation);

        MutationId mutationId = new MutationId("invalid");
        when(mutationSpringData.findById("invalid")).thenReturn(Optional.empty());

        // act
        Optional<Mutation> result = repositoryMutationSpringData.ofIdentity(mutationId);

        // assert
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnTrueWhenContainsOfIdentityIsCalledWithExistingId() {
        // arrange
        IRepositoryMutationSpringData mutationSpringData = mock(IRepositoryMutationSpringData.class);
        MapperMutation mapperMutation = mock(MapperMutation.class);
        RepositoryMutationSpringDataImpl repositoryMutationSpringData = new RepositoryMutationSpringDataImpl(mutationSpringData, mapperMutation);

        MutationId mutationId = new MutationId("1");
        when(mutationSpringData.existsById("1")).thenReturn(true);

        // act
        boolean result = repositoryMutationSpringData.containsOfIdentity(mutationId);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenContainsOfIdentityIsCalledWithNonExistingId() {
        // arrange
        IRepositoryMutationSpringData mutationSpringData = mock(IRepositoryMutationSpringData.class);
        MapperMutation mapperMutation = mock(MapperMutation.class);
        RepositoryMutationSpringDataImpl repositoryMutationSpringData = new RepositoryMutationSpringDataImpl(mutationSpringData, mapperMutation);

        MutationId mutationId = new MutationId("invalid");
        when(mutationSpringData.existsById("invalid")).thenReturn(false);

        // act
        boolean result = repositoryMutationSpringData.containsOfIdentity(mutationId);

        // assert
        assertFalse(result);
    }
}