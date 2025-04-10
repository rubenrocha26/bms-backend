package dev.well.bms.domain.valueObject;

import dev.well.bms.ddd.ValueObject;

public class Color implements ValueObject {
    private final String color;

    public Color(String color) {
        if(color == null || color.isBlank()) throw new IllegalArgumentException("Color cannot be null or empty");

        this.color = color;
    }

    @Override
    public boolean equals (Object objectToCompare) {
        if (this == objectToCompare) return true;

        if(objectToCompare instanceof Color colorToCompare) {
            return this.color.equals(colorToCompare.color);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.color;
    }
}
