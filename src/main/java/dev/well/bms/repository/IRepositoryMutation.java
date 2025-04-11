package dev.well.bms.repository;

import dev.well.bms.ddd.IRepository;
import dev.well.bms.domain.mutation.Mutation;
import dev.well.bms.domain.valueObject.MutationId;

public interface IRepositoryMutation extends IRepository<MutationId, Mutation> {
}
