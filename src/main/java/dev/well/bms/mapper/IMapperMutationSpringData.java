package dev.well.bms.mapper;

import dev.well.bms.domain.mutation.Mutation;
import dev.well.bms.persistence.dataModel.MutationDataModel;

public interface IMapperMutationSpringData {
     Mutation dataModelToDomain (MutationDataModel mutationDataModel);
     Iterable<Mutation> dataModelToDomain (Iterable<MutationDataModel> mutationDataModel);
}
