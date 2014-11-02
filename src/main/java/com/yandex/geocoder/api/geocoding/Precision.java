package com.yandex.geocoder.api.geocoding;

/**
 * Precision of match when comparing building number from response with found building number.
 * Described at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/concepts/input_params-docpage/"> API 1.x</a>
 */
public enum Precision {

    /**The exact match of building and housing or construction, e.g. "25A" for "25A"*/
    exact("exact"),
    /**Only the number matched, e.g. "25k1" for "25 korpus 1"*/
    number("number"),
    /**The result has a number close to the requested one, e.g. "18" for request "16/3" */
    near("near"),
    /**The response contains approximate location of the requested building*/
    range("range"),
    /**Street only was found*/
    street("street"),
    /**Even the street was not found, though geocoder found something different - Sub/AdministrativeArea, Locality, etc*/
    other("other");

    private final String value;

    Precision(final String value) {
        this.value = value;
    }

    /**
     * @return a String representation of this enum
     * */
    public String value() {
        return value;
    }

    /**
     * @param v String value
     * @return a Precision representation of the String
     * <br>Will throw IllegalArgumentException if no Precision matches the String
     * */
    public static Precision fromValue(final String v) {
        for (Precision precision : Precision.values()) {
            if (precision.value.equals(v)) {
                return precision;
            }
        }
        throw new IllegalArgumentException(v);
    }

    /**
     * {@inheritDoc}
     * */
    @Override
    public String toString() {
        return value();
    }
}
