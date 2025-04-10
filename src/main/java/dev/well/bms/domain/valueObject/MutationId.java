package dev.well.bms.domain.valueObject;

import dev.well.bms.ddd.DomainId;

import java.util.UUID;

public class MutationId implements DomainId {
    private final UUID _mutationId;

    public MutationId () {
        this._mutationId = UUID.randomUUID();
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
    public String toString() {
        return this._mutationId.toString();
    }
}
