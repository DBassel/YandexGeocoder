package api.geocoding;

import com.google.gson.annotations.SerializedName;

public class GeoObject {

    @SerializedName("metaDataProperty")
    MetadataProperty property;
    @SerializedName("description")
    String description;
    @SerializedName("name")
    String name;

    @SerializedName("Point")
    Point point;

    GeoObject(){}
    /**
     * @return MetadataProperty, a wrapper around GeocoderMetadata for the object
     */
    public MetadataProperty getMetadataProperty() {
        return property;
    }

    /**
     * @return description of the object. Yandex Geocoder returns it in format "[<b>Locality</b>][,][<b>SubAdministrative Area</b>][,][<b>AdministrativeArea</b>][,][<b>Country</b>]"
     * <br>e.g. "Moscow, Russia" for a geocode "Moscow, Tverskaya, 25"
     */
    public String getDescription() {
        return description;
    }


    /**
     * @return name of the object. Yandex Geocoder returns the name of the toponym that has the the most "detailed" kind.
     * <br>e.g. "Tverskaya ulitsa, 25" for a geocode "Moscow, Tverskaya 25"
     * <br>e.g. "Tverskaya ulitsa" for a geocode "Moscow, Tverskaya"
     */
    public String getName() {
        return name;
    }


    /**
     * @return wrapper holding a string of latitude,longitude
     */
    public Point getPoint() {
        return point;
    }


    /**
     * A wrapper around GeocoderMetadata
     */
    public static class MetadataProperty {
        @SerializedName("GeocoderMetaData")
        GeocoderMetadata geocoderMetadata;

        public GeocoderMetadata getGeocoderMetadata() {
            return geocoderMetadata;
        }
    }

    public static class Point {
        @SerializedName("pos")
        String pos;

        /**
         * @return a string of latitude,longitude as provided by geocoder
         */
        public String getPositionString() {
            return pos;
        }

        /**
         * @return LatLng representation of a Point
         */
        public LatLng toLatLng() {
            return new LatLng(pos);
        }

    }

}

