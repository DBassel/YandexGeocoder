package com.yandex.geocoder.api.geocoding;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Response from Yandex Geocoding service
 */
public class GeocoderResponse {

    GeocoderResponse() {

    }


    @SerializedName("response")
    Response response;

    /**
     * Get the response object holding the actual response
     *
     * @return response object from server
     */
    public Response getResponse() {
        return response;
    }


    /**
     * Get the most accurate result out of response. Performs one pass-through the array searching for GeoObject with the most detailed Kind
     *
     * @return the most accurate result, <b>or null</b>, if response is null or zero-sized
     */
    public GeoObject getMostAccurateResult() {
        if (response == null) {
            return null;
        } else {
            List<GeoObjectCollection.GeoObjectHolder> list = response.getCollection().getGeoObjectHolders();
            if (list == null || list.size() == 0) {
                return null;
            } else {
                GeoObject mostAccurate = list.get(0).getObject();
                for (GeoObjectCollection.GeoObjectHolder holder : response.getCollection().getGeoObjectHolders()) {
                    GeoObject current = holder.getObject();
                    if (mostAccurate.getMetadataProperty().getGeocoderMetadata().getKind()
                            .compareTo(current.getMetadataProperty().getGeocoderMetadata().getKind()) > 0) {
                        mostAccurate = current;
                    }

                }
                return mostAccurate;
            }
        }
    }

    /**
     * Wrapper holding the results of response
     */
    public static class Response {
        @SerializedName("Attribution")
        String attribution;//remove
        @SerializedName("GeoObjectCollection")
        GeoObjectCollection collection;


        /**
         * @return Attribution property. Geocoder always returns empty string - ""
         */
        public String getAttribution() {
            return attribution;
        }

        /**
         * @return wrapper holding the metadata and actual results of geocoding service, if any
         */
        public GeoObjectCollection getCollection() {
            return collection;
        }


    }

}
