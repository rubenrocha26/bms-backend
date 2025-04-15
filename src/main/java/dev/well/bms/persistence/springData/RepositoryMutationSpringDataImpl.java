package dev.well.bms.persistence.springData;
import dev.well.bms.domain.mutation.Mutation;
import dev.well.bms.domain.valueObject.MutationId;
import dev.well.bms.mapper.impl.MapperMutation;
import dev.well.bms.persistence.dataModel.MutationDataModel;
import dev.well.bms.repository.IRepositoryMutation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryMutationSpringDataImpl implements IRepositoryMutation {
    private final IRepositoryMutationSpringData _repositoryMutationSpringData;
    private final MapperMutation _mapperMutation;

    public RepositoryMutationSpringDataImpl(IRepositoryMutationSpringData repositoryMutationSpringData, MapperMutation mapperMutation) {
        this._repositoryMutationSpringData = repositoryMutationSpringData;
        this._mapperMutation = mapperMutation;
    }

    @Override
    public Mutation save (Mutation mutation) {
        if (mutation==null) throw new IllegalArgumentException("Mutation is null");

        MutationDataModel mutationDataModel = new MutationDataModel(mutation);

        //cria um mutationDataModelSaved, mas é retornado objeto de domínio
        MutationDataModel mutationDataModelSaved = this._repositoryMutationSpringData.save(mutationDataModel);

        return mutation;
    }

    @Override
    public Iterable<Mutation> findAll() {
        List<MutationDataModel> listMutationSaved = this._repositoryMutationSpringData.findAll();

        return _mapperMutation.dataModelToDomain(listMutationSaved);
    }

    @Override
    public Optional<Mutation> ofIdentity (MutationId id) {
        Optional<MutationDataModel> optionMutationDataModelSaved = this._repositoryMutationSpringData.findById(id.toString());

        if (optionMutationDataModelSaved.isPresent()) {

            Mutation mutationDomain = _mapperMutation.dataModelToDomain(optionMutationDataModelSaved.get());
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
