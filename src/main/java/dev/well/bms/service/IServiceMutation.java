package dev.well.bms.service;

import dev.well.bms.domain.mutation.Mutation;
import dev.well.bms.domain.valueObject.Description;

import java.util.Optional;

public interface IServiceMutation {
    Mutation createMutation (Description description);
    Optional<Mutation> saveMutation (Mutation mutation);

}
