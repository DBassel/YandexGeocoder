package api.geocoder;


import api.yg.GeoObject;
import api.yg.GeoObjectCollection;
import api.yg.GeocoderRequest;
import api.yg.GeocoderResponse;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;


/**
 * Geocoder class to perform requests to Yandex Geocoding service
 * */
public class Geocoder {

    private static final String GEOCODE_REQUEST_HOST = "geocode-maps.yandex.ru";
    private static final String GEOCODE_REQUEST_SERVER_HTTP = "http://" + GEOCODE_REQUEST_HOST;
    private static final String GEOCODE_REQUEST_SERVER_HTTPS = "https://" + GEOCODE_REQUEST_HOST;
    private static final String GEOCODE_REQUEST_QUERY_BASIC = "/1.x/?format=json";
    private static final String ENCODING = "UTF-8";

    /**
     * Default format for doubles in request
     */
    private DecimalFormat format = new DecimalFormat("#.######");

    public Geocoder() {

    }

    /**
     * Process geocoding request
     *
     * @param geocoderRequest request to a Yandex Geocoder service
     * @return response from geocoding service
     */
    public GeocoderResponse geocode( GeocoderRequest geocoderRequest) throws IOException {


        Gson gson = new Gson();
        String urlString = getURL(geocoderRequest);

        return request(gson, urlString);

    }


    /**
     * @param gson      an initialized gson object instance
     * @param urlString fully constructed request URL
     * @return response from geocoding service
     */
    protected GeocoderResponse request(Gson gson, String urlString) throws IOException {
        final URL url = new URL(urlString);
        final Reader reader = new BufferedReader(new InputStreamReader(url.openStream(), ENCODING));
        try {
            return gson.fromJson(reader, GeocoderResponse.class);
        } finally {
            reader.close();
        }
    }


    /**
     * Get the most accurate result out of response. Performs one pass-through the array searching for GeoObject with the most detailed Kind
     *
     * @param response response from geocoding service
     * @return the most accurate result, <b>or null</b>, if response is null or zero-sized
     */
    public GeoObject getMostAccurateResult(GeocoderResponse response) {
        if (response == null) {
            return null;
        } else {
            List<GeoObjectCollection.GeoObjectHolder> list = response.getResponse().getCollection().getGeoObjectHolders();
            if (list == null || list.size() == 0) {
                return null;
            } else {
                GeoObject mostAccurate = list.get(0).getObject();
                for (GeoObjectCollection.GeoObjectHolder holder : response.getResponse().getCollection().getGeoObjectHolders()) {
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
     * Get the URL for a specific geocoding service request
     *
     * @param geocoderRequest request to a Yandex Geocoder service
     * @return URL for performing a geocoding service request
     */
    public String getURL(GeocoderRequest geocoderRequest) {


        final StringBuilder url = new StringBuilder(geocoderRequest.getKey() == null ? GEOCODE_REQUEST_SERVER_HTTP : GEOCODE_REQUEST_SERVER_HTTPS);

        url.append(GEOCODE_REQUEST_QUERY_BASIC);

        url.append("&geocode=").append(geocoderRequest.getGeocode().replace(' ', '+'));

        if (geocoderRequest.getKey() != null && geocoderRequest.getKey().length() != 0) {
            url.append("&key=").append(geocoderRequest.getKey());
        }

        if (geocoderRequest.getKind() != null) {
            url.append("&kind=").append(geocoderRequest.getKind().toString());
        }

        if (geocoderRequest.getLanguage() != null) {
            url.append("&lang=").append(geocoderRequest.getLanguage().toString());
        }

        if (geocoderRequest.isSearchAreaRestricted()) {
            url.append("&rspn=1");
        }

        if (geocoderRequest.isSearchAreaRestricted() || geocoderRequest.isSearchAreaSpecified()) {
            url.append("&ll=")
                    .append(
                            String.format("%s,%s",
                                    formatDoubleDefault(geocoderRequest.getCenterLat()),
                                    formatDoubleDefault(geocoderRequest.getCenterLng()))
                    )
                    .append("&spn=")
                    .append(
                            String.format("%s,%s",
                                    formatDoubleDefault(geocoderRequest.getSpanLatDiff()),
                                    formatDoubleDefault(geocoderRequest.getSpanLngDiff())
                            ));
        }

        if (geocoderRequest.getResults() != GeocoderRequest.RESULTS_DEAFULT) {
            url.append("&results=").append(String.valueOf(geocoderRequest.getResults()));
        }
        if (geocoderRequest.getSkip() != GeocoderRequest.SKIP_DEFAULT) {
            url.append("&skip=").append(String.valueOf(geocoderRequest.getSkip()));
        }

        return url.toString();
    }

    /**
     * Format a double value to a String value
     * By default uses DecimalFormat with RoundingMode.HALF_EVEN
     *
     * @param f value to be formatted
     * @return a formatted String
     */
    protected String formatDoubleDefault(double f) {
        return format.format(f);
    }

}
