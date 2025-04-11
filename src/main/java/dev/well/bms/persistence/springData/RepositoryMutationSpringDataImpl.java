package dev.well.bms.persistence.springData;

import dev.well.bms.domain.mutation.IFactoryMutation;
import dev.well.bms.domain.mutation.Mutation;
import dev.well.bms.domain.valueObject.MutationId;
import dev.well.bms.persistence.dataModel.MutationDataModel;
import dev.well.bms.repository.IRepositoryMutation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryMutationSpringDataImpl implements IRepositoryMutation {
    IRepositoryMutationSpringData _repositoryMutationSpringData;
    IFactoryMutation _mutationFactory;

    public RepositoryMutationSpringDataImpl(IRepositoryMutationSpringData repositoryMutationSpringData, IFactoryMutation mutationFactory) {
        this._repositoryMutationSpringData = repositoryMutationSpringData;
        this._mutationFactory = mutationFactory;
    }

    @Override
    public Mutation save (Mutation mutation) {
        if (mutation==null) throw new IllegalArgumentException("Mutation is null");

        MutationDataModel mutationDataModel = new MutationDataModel(mutation);

        this._repositoryMutationSpringData.save(mutationDataModel);

        return mutation;
    }

    @Override
    public Iterable<Mutation> findAll() {
        List<MutationDataModel> listMutationSaved = this._repositoryMutationSpringData.findAll();

        return MutationDataModel.toDomain(_mutationFactory, listMutationSaved);
    }

    @Override
    public Optional<Mutation> ofIdentity (MutationId id) {
        Optional<MutationDataModel> optionMutationDataModelSaved = this._repositoryMutationSpringData.findById(id.toString());

        if (optionMutationDataModelSaved.isPresent()) {
            Mutation mutationDomain = MutationDataModel.toDomain(_mutationFactory, optionMutationDataModelSaved.get());
            return Optional.of(mutationDomain);
        }else {
            return Optional.empty();
        }
    }

    @Override
    public boolean containsOfIdentity (MutationId id) {
        return this._repositoryMutationSpringData.existsById(id.toString());
    }
}
