package dev.well.bms.domain.valueObject;

import dev.well.bms.ddd.ValueObject;

public class Description implements ValueObject {
    private final String description;

    public Description (String description) {
        if(description == null || description.isBlank()) throw new IllegalArgumentException("Description cannot be null or empty");

        this.description = description;
    }

    @Override
    public boolean equals (Object objectToCompare) {
        if (this == objectToCompare) return true;

        if(objectToCompare instanceof Description descriptionToCompare) {
            return this.description.equals(descriptionToCompare.description);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
