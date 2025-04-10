package dev.well.bms.domain.mutation;

import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.domain.valueObject.MutationId;

import java.util.UUID;

public class MutationFactoryImpl implements IMutationFactory {

    @Override
    public Mutation createMutation(Description description) {
        MutationId mutationId = new MutationId(UUID.randomUUID().toString());
        return new Mutation(mutationId, description);
    }
    @Override
    public Mutation createMutation(MutationId mutationId, Description description) {
        return new Mutation(mutationId, description);
    }
}
