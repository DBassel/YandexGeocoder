package com.yandex.geocoder.api.geocoding;


/**
 * Kind of toponym
 * <br>Described at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/concepts/About-docpage/"> API 1.x</a>
 *
 */
public enum Kind {

    //order of items is important!! when looking for the best match
    /**House*/ house("house"),
    /**Street*/street("street"),
    /**Metro*/metro("metro"),
    /**District*/district("district"),
    /**Locality*/locality("locality"),
    /**Area*/area("area"),
    /**Province*/province("province"),
    /**Country*/country("country"),
    /**Hydro*/hydro("hydro"),
    /**Railway*/railway("railway"),
    /**Route*/route("route"),
    /**Vegetation*/vegetation("vegetation"),
    /**Airport*/airport("airport"),
    /**Other*/other("other");

    private final String value;

    Kind(final String v) {
        value = v;
    }

    /**
     * @return a String representation of an enum
     * */
    public String value() {
        return value;
    }

    /**
     * @param v String value
     * @return Kind representation of a String
     * <br>Throws IllegalArgumentException if no Kind matches the provided String
     * */
    public static Kind fromValue(final String v) {
        for (Kind kind : Kind.values()) {
            if (kind.value.equals(v)) {
                return kind;
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
