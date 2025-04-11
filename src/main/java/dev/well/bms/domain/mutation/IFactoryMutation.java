package dev.well.bms.domain.mutation;

import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.domain.valueObject.MutationId;

public interface IFactoryMutation {
    Mutation createMutation(Description description);
    Mutation createMutation (MutationId mutationId, Description description);
}
