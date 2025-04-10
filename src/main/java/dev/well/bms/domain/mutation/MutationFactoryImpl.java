package dev.well.bms.domain.mutation;

import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.domain.valueObject.MutationId;

public class MutationFactoryImpl implements IMutationFactory {

    @Override
    public Mutation createMutation(Description description) {
        MutationId mutationId = new MutationId();
        return new Mutation(mutationId, description);
    }
}
