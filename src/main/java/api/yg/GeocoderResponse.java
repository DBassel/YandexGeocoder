package api.yg;

import com.google.gson.annotations.SerializedName;


/**
 * Response from Yandex Geocoding service
 * */
public class GeocoderResponse {

    GeocoderResponse(){

    }


    @SerializedName("response")
    Response response;

    /**
     * Get the response object holding the actual response
     * @return response object from server
     * */
    public Response getResponse() {
        return response;
    }

    /**
     * Wrapper holding the results of response
     * */
    public static class Response {
        @SerializedName("Attribution")
        String attribution;//remove
        @SerializedName("GeoObjectCollection")
        GeoObjectCollection collection;


        /**
         * @return Attribution property. Geocoder always returns empty string - ""
         * */
        public String getAttribution() {
            return attribution;
        }

        /**
         * @return wrapper holding the metadata and actual results of geocoding service, if any
         * */
        public GeoObjectCollection getCollection() {
            return collection;
        }


    }

}
