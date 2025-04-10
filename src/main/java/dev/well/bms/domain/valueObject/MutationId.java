package dev.well.bms.domain.valueObject;

import dev.well.bms.ddd.DomainId;

public class MutationId implements DomainId {
    private final String _mutationId;

    public MutationId (String mutationId) {
        if (mutationId == null || mutationId.isBlank()) throw new IllegalArgumentException("Id cannot be null or empty");
        this._mutationId = mutationId;
    }

    @Override
    public boolean equals (Object objectToCompare) {
        if(this == objectToCompare) return true;

        if(objectToCompare instanceof MutationId mutationToCompare) {
            return this._mutationId.equals(mutationToCompare._mutationId);
        }
        return false;
    }

    @Override
    public String toString () {
        return _mutationId;
    }
}
