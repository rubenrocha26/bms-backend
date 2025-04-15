package dev.well.bms.service.impl;

import dev.well.bms.domain.mutation.IFactoryMutation;
import dev.well.bms.domain.mutation.Mutation;
import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.repository.IRepositoryMutation;
import dev.well.bms.service.IServiceMutation;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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

    @Override
    public Mutation createMutation (Description description) {
        if(description == null) throw new IllegalArgumentException("Description cannot be null");

        return this._mutationFactory.createMutation(description);
    }

    @Override
    public Optional<Mutation> saveMutation (Mutation mutation) {
        if(mutation == null) throw new IllegalArgumentException("Mutation cannot be null");

        //antes de guardar verifica se já existe alguma mutação com o mesmo ID ou Descrição
        Iterable<Mutation> mutationsAlreadySaved = _mutationRepository.findAll();
        for(Mutation m : mutationsAlreadySaved){
            if(m.identity().equals(mutation.identity()) || m.getDescription().equals(mutation.getDescription())){
                return Optional.empty();
            }
        }

        //Se a mutação não for gravada retorna empty
        Mutation mutationSaved = _mutationRepository.save(mutation);
        if(mutationSaved == null) return Optional.empty();

        return Optional.of(mutationSaved);
    }

}
