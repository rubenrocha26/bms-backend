package dev.well.bms.service.impl;

import dev.well.bms.domain.mutation.IFactoryMutation;
import dev.well.bms.repository.IRepositoryMutation;
import dev.well.bms.service.IServiceMutation;

public class ServiceMutationImpl implements IServiceMutation {
    private final IFactoryMutation _mutationFactory;
    private final IRepositoryMutation _mutationRepository;

    public ServiceMutationImpl(IFactoryMutation mutationFactory, IRepositoryMutation mutationRepository){
        if(mutationFactory == null){
            throw new IllegalArgumentException("MutationFactory cannot be null");
        }
        _mutationFactory = mutationFactory;

        if(mutationRepository == null){
            throw new IllegalArgumentException("MutationRepository cannot be null");
        }
        _mutationRepository = mutationRepository;
    }
}
