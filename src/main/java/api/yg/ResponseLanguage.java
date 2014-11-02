package api.yg;


/**
 * Languages supported by Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/concepts/input_params-docpage/"> API 1.x</a>
 */
public enum ResponseLanguage {

    /**
     * Russian language
     */RUSSIAN("ru_RU"),
    /**
     * Ukrainean language
     */UKRAINIAN("uk_UA"),
    /**
     * Belorussian language
     */BELORUSSIAN("be_BY"),
    /**
     * English language (United States)
     */US_ENGLISH("en_US"),
    /**
     * Turkish language
     */TURKISH("tr_TR");

    private final String value;

    ResponseLanguage(final String v) {
        value = v;
    }

    /**
     * @return a String representation of this enum
     */
    public String value() {
        return value;
    }


    /**
     * @param v String value
     * @return a ResponseLanguage representation of the String
     * <br>Will throw IllegalArgumentException if no ResponseLanguage matches the String
     */
    public static ResponseLanguage fromValue(final String v) {
        for (ResponseLanguage lan : ResponseLanguage.values()) {
            if (lan.value.equals(v)) {
                return lan;
            }
        }
        throw new IllegalArgumentException(v);
    }

    /**
     *
     * {@inheritDoc}*/
    @Override
    public String toString() {
        return value();
    }
}
