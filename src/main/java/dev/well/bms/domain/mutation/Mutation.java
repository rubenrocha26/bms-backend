package dev.well.bms.domain.mutation;

import dev.well.bms.ddd.DomainEntity;
import dev.well.bms.ddd.ValueObject;
import dev.well.bms.domain.valueObject.Color;
import dev.well.bms.domain.valueObject.Description;
import dev.well.bms.domain.valueObject.MutationId;

public class Mutation implements DomainEntity<MutationId> {
    private final MutationId _mutationId;
    private final Color _color;
    private final Description _description;

    public Mutation (MutationId id, Color color, Description description) {
        this._mutationId = id;

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
        return null;
    }

    @Override
    public boolean sameAs (Object objectToCompare){
        return true;
    }
}
