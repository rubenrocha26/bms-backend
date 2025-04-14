package dev.well.bms.service.impl;

import dev.well.bms.domain.mutation.FactoryMutationImpl;
import dev.well.bms.domain.mutation.IFactoryMutation;
import dev.well.bms.persistence.springData.RepositoryMutationSpringDataImpl;
import dev.well.bms.repository.IRepositoryMutation;
import dev.well.bms.service.IServiceMutation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ServiceMutationImplTest {
    @Test
    void shouldCreateServiceMutation() {
        //arrange
        IFactoryMutation mutationFactory = new FactoryMutationImpl();
        IRepositoryMutation mutationRepository = mock(RepositoryMutationSpringDataImpl.class);
        //act
        IServiceMutation mutationService = new ServiceMutationImpl(mutationFactory, mutationRepository);
        //assert
        assertNotNull(mutationService);
    }

}