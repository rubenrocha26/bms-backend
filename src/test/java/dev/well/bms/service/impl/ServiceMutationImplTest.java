package dev.well.bms.service.impl;

import dev.well.bms.domain.mutation.FactoryMutationImpl;
import dev.well.bms.domain.mutation.IFactoryMutation;
import dev.well.bms.domain.mutation.Mutation;
import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.persistence.springData.RepositoryMutationSpringData;
import dev.well.bms.repository.IRepositoryMutation;
import dev.well.bms.service.IServiceMutation;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ServiceMutationImplTest {
    @Test
    void shouldCreateServiceMutation() {
        //arrange
        IFactoryMutation mutationFactory = new FactoryMutationImpl();
        IRepositoryMutation mutationRepository = mock(RepositoryMutationSpringData.class);
        //act
        IServiceMutation mutationService = new ServiceMutationImpl(mutationFactory, mutationRepository);
        //assert
        assertNotNull(mutationService);
    }

    @Test
    void shouldThrowExceptionIfRepositoryMutationIsNull() {
        //arrange
        IFactoryMutation mutationFactory = new FactoryMutationImpl();
        IRepositoryMutation mutationRepository = null;
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new ServiceMutationImpl(mutationFactory, mutationRepository));
    }

    @Test
    void shouldThrowExceptionIfMutationFactoryIsNull() {
        //arrange
        IFactoryMutation mutationFactory = null;
        IRepositoryMutation mutationRepository = mock(RepositoryMutationSpringData.class);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> new ServiceMutationImpl(mutationFactory, mutationRepository));
    }

    @Test
    void shouldCreateMutation() {
        //arrange
        IFactoryMutation mutationFactory = new FactoryMutationImpl();
        IRepositoryMutation mutationRepository = mock(RepositoryMutationSpringData.class);
        IServiceMutation mutationService = new ServiceMutationImpl(mutationFactory, mutationRepository);
        Description description = new Description("description");
        //act
        Mutation mutation = mutationService.createMutation(description);
        //assert
        assertNotNull(mutation);
    }

    @Test
    void shouldThrowExceptionWhenDescriptionIsNull() {
        //arrange
        IFactoryMutation mutationFactory = new FactoryMutationImpl();
        IRepositoryMutation mutationRepository = mock(RepositoryMutationSpringData.class);
        IServiceMutation mutationService = new ServiceMutationImpl(mutationFactory, mutationRepository);
        Description description = null;
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> mutationService.createMutation(description));
    }

    @Test
    void shouldSaveMutation() {
        //arrange
        IFactoryMutation mutationFactory = new FactoryMutationImpl();
        IRepositoryMutation mutationRepository = mock(RepositoryMutationSpringData.class);
        IServiceMutation mutationService = new ServiceMutationImpl(mutationFactory, mutationRepository);


        Description description = new Description("description");
        Mutation mutation = mutationService.createMutation(description);

        Description description2 = new Description("description2");
        Mutation newMutation = mutationService.createMutation(description2);

        Description description3 = new Description("description3");
        Mutation mutation3 = mutationService.createMutation(description3);

        when(mutationRepository.findAll()).thenReturn(List.of(mutation3));
        when(mutationRepository.save(mutation)).thenReturn(mutation);
        when(mutationRepository.save(newMutation)).thenReturn(newMutation);
        //act
        Optional<Mutation> mutationSaved = mutationService.saveMutation(mutation);
        Optional<Mutation> mutationSaved2 = mutationService.saveMutation(newMutation);
        //assert
        assertTrue(mutationSaved.isPresent());
        assertEquals(mutation, mutationSaved.get());
        assertTrue(mutationSaved2.isPresent());
        assertEquals(newMutation, mutationSaved2.get());
    }

    @Test
    void shouldThrowExceptionWhenMutationToBeSavedIsNull() {
        //arrange
        IFactoryMutation mutationFactory = new FactoryMutationImpl();
        IRepositoryMutation mutationRepository = mock(RepositoryMutationSpringData.class);
        IServiceMutation mutationService = new ServiceMutationImpl(mutationFactory, mutationRepository);
        Mutation mutation = null;
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> mutationService.saveMutation(mutation));
    }

    @Test
    void shouldReturnOptionalEmptyWhenMutationWithSameDescriptionIsAlreadySaved() {
        //arrange
        IFactoryMutation mutationFactory = new FactoryMutationImpl();
        IRepositoryMutation mutationRepository = mock(RepositoryMutationSpringData.class);
        IServiceMutation mutationService = new ServiceMutationImpl(mutationFactory, mutationRepository);

        Description description = new Description("description");
        Mutation existingMutation = mutationService.createMutation(description);
        Mutation newMutation = mutationService.createMutation(description);
        mutationService.saveMutation(existingMutation);
        when(mutationRepository.findAll()).thenReturn(List.of(existingMutation));
        //act
        Optional<Mutation> mutationSaved = mutationService.saveMutation(newMutation);
        //assert
        assertEquals(Optional.empty(), mutationSaved);
    }

    @Test
    void shouldReturnOptionalEmptyWhenMutationWithSameIdIsAlreadySaved() {
        //arrange
        IFactoryMutation mutationFactory = new FactoryMutationImpl();
        IRepositoryMutation mutationRepository = mock(RepositoryMutationSpringData.class);
        IServiceMutation mutationService = new ServiceMutationImpl(mutationFactory, mutationRepository);
        Description description = new Description("description");
        Mutation existingMutation = mutationService.createMutation(description);
        mutationService.saveMutation(existingMutation);
        when(mutationRepository.findAll()).thenReturn(List.of(existingMutation));
        //act
        Optional<Mutation> mutationSaved = mutationService.saveMutation(existingMutation);
        //assert
        assertEquals(Optional.empty(), mutationSaved);
    }

}