package dev.well.bms.domain.mutation;

import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.domain.valueObject.MutationId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FactoryMutationImpl implements IFactoryMutation {

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
