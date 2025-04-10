package dev.well.bms.domain.valueObject;

import dev.well.bms.ddd.ValueObject;

public class Color implements ValueObject {
    private final String _color;

    public Color(String _color) {
        if(_color == null || _color.isBlank()) throw new IllegalArgumentException("Color cannot be null or empty");

        this._color = _color;
    }

    @Override
    public boolean equals (Object objectToCompare) {
        if (this == objectToCompare) return true;

        if(objectToCompare instanceof Color colorToCompare) {
            return this._color.equals(colorToCompare._color);
        }
        return false;
    }

    @Override
    public String toString() {
        return this._color;
    }
}
