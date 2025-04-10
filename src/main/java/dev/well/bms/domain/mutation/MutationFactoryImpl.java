package dev.well.bms.domain.mutation;

import dev.well.bms.domain.valueObject.Color;
import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.domain.valueObject.MutationId;

public class MutationFactoryImpl implements IMutationFactory {

    @Override
    public Mutation createMutation(Color color, Description description) {
        MutationId mutationId = new MutationId();
        return new Mutation(mutationId, color, description);
    }
}
