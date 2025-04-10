package dev.well.bms.domain.mutation;

import dev.well.bms.ddd.DomainEntity;
import dev.well.bms.domain.valueObject.Color;
import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.domain.valueObject.MutationId;

public class Mutation implements DomainEntity<MutationId> {
    private final MutationId _mutationId;
    private final Color _color;
    private final Description _description;

    protected Mutation (MutationId mutationId, Color color, Description description) {
        if (mutationId == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        this._mutationId = mutationId;

        if(color == null) {
            throw new IllegalArgumentException("Color cannot be null or blank");
        }
        this._color = color;

        if(description == null) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        this._description = description;
    }

    @Override
    public boolean equals (Object objectToCompare) {
        if(this == objectToCompare) return true;

        if(objectToCompare instanceof Mutation mutation) {
            return this._mutationId.equals(mutation._mutationId);
        }
        return false;
    }

    @Override
    public MutationId identity() {
        return this._mutationId;
    }

    @Override
    public boolean sameAs (Object objectToCompare){
        if (objectToCompare instanceof Mutation mutation) {
            return this._mutationId.equals(mutation._mutationId) && this._color.equals(mutation._color) && this._description.equals(mutation._description);
        }
        return false;
    }
}
