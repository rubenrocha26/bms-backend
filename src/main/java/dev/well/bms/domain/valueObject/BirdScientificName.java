package dev.well.bms.domain.valueObject;

import dev.well.bms.ddd.ValueObject;

public class BirdScientificName implements ValueObject {
    private final String scientificName;

    public BirdScientificName(String scientificName) {
        if(scientificName == null || scientificName.isBlank()) {
            throw new IllegalArgumentException("ScientificName cannot be null or empty");
        }
        this.scientificName = scientificName;
    }

    @Override
    public boolean equals (Object objectToCompare) {
        if(this == objectToCompare) return true;

        if(objectToCompare instanceof BirdScientificName birdScientificName) {
            return this.scientificName.equals(birdScientificName.scientificName);
        }
        return false;
    }

    @Override
    public String toString () {
        return this.scientificName;
    }
}
