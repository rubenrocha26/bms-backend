package dev.well.bms.domain.mutation;

import dev.well.bms.domain.valueObject.Color;
import dev.well.bms.domain.valueObject.Description;

import java.util.UUID;

public interface IMutationFactory {
    Mutation createMutation (Color color, Description description);
}
