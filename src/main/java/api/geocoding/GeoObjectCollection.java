package api.geocoding;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * A class holding the results of geocoding
 * */
public class GeoObjectCollection {

    @SerializedName("metaDataProperty")
    MetadataProperty property;

    @SerializedName("featureMember")
    List<GeoObjectHolder> geoObjects;

    GeoObjectCollection(){

    }

    /**
     * @return a list of wrappers around GeoObject results
     * */
    public List<GeoObjectHolder> getGeoObjectHolders() {
        return geoObjects;
    }

    /**
     * @return a wrapper around GeocoderResponseMetadata
     * */
    public MetadataProperty getMetadataProperty() {
        return property;
    }

    /**
     * A wrapper around GeocoderResponseMetadata
     * */
    public static class MetadataProperty {

        @SerializedName("GeocoderResponseMetaData")
        GeocoderResponseMetadata metadata;

        public GeocoderResponseMetadata getMetadata() {
            return metadata;
        }
    }


    /**
     * A wrapper around GeoObject
    * */
    public static class GeoObjectHolder {
        @SerializedName("GeoObject")
        GeoObject object;

        /**
         * @return a object held by this wrapper
         * */
        public GeoObject getObject() {
            return object;
        }
    }

}
