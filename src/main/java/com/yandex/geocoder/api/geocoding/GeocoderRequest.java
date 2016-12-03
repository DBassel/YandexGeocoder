package com.yandex.geocoder.api.geocoding;


import java.util.Arrays;

/**
 * Request to send to Geocoder service
 * <br>More info at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/concepts/input_params-docpage/"> API reference documentation</a>
 * <br>Can be constructed via Builder
 */
public class GeocoderRequest {


    public static final int RESULTS_DEAFULT = 10;
    public static final int SKIP_DEFAULT = 0;
    public static final int RSPN_DEFAULT = 0;
    public static final int NOT_SPECIFIED = -1;



    /*Restrict search area to parameters ll, spn*/
    private int rspn = RSPN_DEFAULT;

    private double centerLat = NOT_SPECIFIED;//ll[0]
    private double centerLng = NOT_SPECIFIED;//ll[1]

    private double spanLatDiff = NOT_SPECIFIED;//spn[0]
    private double spanLngDiff = NOT_SPECIFIED;//spn[1]

    /*restrict amount of maximal returned results to this pos*/
    private int results = RESULTS_DEAFULT;

    /*specify how many objects should one skip in response*/
    private int skip = SKIP_DEFAULT;

    private String language;

    private String geocode;

    private String kind;

    /*key is not necessary to use geocoder, as long as you perform no more than 25 000 requests per day*/
    private String key;

    GeocoderRequest() {

    }

    /**
     * @return value of geocode specified
     */
    public String getGeocode() {
        return geocode;
    }


    /**
     * @return Kind of request, if specified, or null otherwise
     */
    public String getKind() {
        return kind;
    }


    /**
     * @return true, if search results should belong to a boundary
     */
    public boolean isSearchAreaRestricted() {
        return rspn == 1;
    }

    /**
     * @return true, if search area is specified, and the nearest results should be rendered first
     */
    public boolean isSearchAreaSpecified() {
        return !(
                centerLat == NOT_SPECIFIED ||
                        centerLng == NOT_SPECIFIED ||
                        spanLatDiff == NOT_SPECIFIED ||
                        spanLngDiff == NOT_SPECIFIED);
    }


    /**
     * @return centerLat lattitude of center of boundary, if boundary was specified, or NOT_SPECIFIED otherwise
     */
    public double getCenterLat() {
        return centerLat;
    }

    /**
     * @return centerLng  longitude of center of boundary
     */
    public double getCenterLng() {
        return centerLng;
    }

    /**
     * @return spanLatDiff = <tt>max(lat1, lat2) - min(lat1, lat2)</tt>, where <tt>lat1, lng1)</tt>, <tt>(lat2, lng2)</tt> define a boundary
     */
    public double getSpanLatDiff() {
        return spanLatDiff;
    }

    /**
     * @return spanLngDiff = <tt>max(lng1, lng2) - min(lng1, lng2)</tt>, where <tt>(lat1, lng1)</tt>, <tt>(lat2, lng2)</tt> define a boundary
     */
    public double getSpanLngDiff() {
        return spanLngDiff;
    }


    /**
     * @return maximal amount of results in response returned by geocoder
     */
    public int getResults() {
        return results;
    }

    /**
     * @return amount of results to skip in response returned by geocoder
     */
    public int getSkip() {
        return skip;
    }

    /**
     * @return language of response
     */
    public String getLanguage() {
        return language;
    }


    /**
     * @return the api key of request
     */
    public String getKey() {
        return key;
    }

    /**
     * A Builder to build a GeocodingRequest
     */
    public static class Builder {
        private GeocoderRequest constructedRequest;

        /**
         * @throws IllegalArgumentException if geocode is null or zero-length
         */
        public Builder(String geocode) {
            if (geocode == null || geocode.length() == 0) {
                throw new IllegalArgumentException("Missing geocode (address) argument: null or zero-length");
            }
            constructedRequest = new GeocoderRequest();
            constructedRequest.geocode = geocode;

        }

        /**
         * Set geocode parameter of request. See Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/concepts/input_params-docpage/">API reference  </a>
         *
         * @param geocode Address or coordinate string
         * @return the same Builder
         */
        public Builder setGeocode(String geocode) {
            constructedRequest.geocode = geocode;
            return this;
        }

        /**
         * The following values are allowed, as per Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/concepts/input_params-docpage/"> API reference  </a>:
         * <br><code>Kind.house</code>, <code>Kind.street</code>, <code>Kind.metro</code>, <code>Kind.district</code>, <code>Kind.locality</code>
         *
         * @throws IllegalArgumentException if provided Kind is other than those
         */
        public Builder setKind(String kind) {
            if (kind != null) {
                if (!Arrays.asList(Kind.HOUSE, Kind.STREET, Kind.METRO, Kind.DISTRICT,Kind.LOCALITY).contains(kind)) {
                    throw new IllegalArgumentException("Kind could be set to the following values only: house, street, metro, district, locality");
                }
            }
            constructedRequest.kind = kind;
            return this;
        }

        /**
         * Set search area to the specified boundary
         * <br>If <code>restrict</code> is true, then the search is restricted to the boundary
         * <br>Otherwise the search is not restricted, but the results close to the area are rendered first
         * <br>More info at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/concepts/input_params-docpage/"> API reference  </a>
         *
         ** @param restrict if {@code true} the results must belong to the specified bounday; if {@code false}, the results near the specified boundary are rendered first in the response

         * @param centerLat   lattitude of center of boundary
         * @param centerLng   longitude of center of boundary
         * @param spanLatDiff <tt>max(lat1, lat2) - min(lat1, lat2)</tt>, where <tt>(lat1, lng1)</tt>, <tt>(lat2, lng2)</tt> define a boundary
         * @param spanLngDiff <tt>max(lng1, lng2) - min(lng1, lng2)</tt>, where <tt>(lat1, lng1)</tt>, <tt>(lat2, lng2)</tt> define a boundary
         * @return the same Builder object
         */
        public Builder setSearchArea(boolean restrict, double centerLat, double centerLng, double spanLatDiff, double spanLngDiff) {
            constructedRequest.rspn = restrict ? 1 : 0;
            constructedRequest.centerLat = centerLat;
            constructedRequest.centerLng = centerLng;
            constructedRequest.spanLatDiff = spanLatDiff;
            constructedRequest.spanLngDiff = spanLngDiff;
            return this;
        }

        /**
         * Set search area to the specified boundary
         * <p/>
         * <p/>
         * <br>If <b>restrict</b> is true, then the search is restricted to the boundary
         * <br>Otherwise the search is not restricted, but the results close to the area are rendered first
         * <br>More info at <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/concepts/input_params-docpage/">Yandex API reference  </a>
         *
         * @param restrict if {@code true} the results must belong to the specified bounday; if {@code false}, the results near the specified boundary are rendered first in the response
         * @return the same Builder object
         */

        public Builder setSearchArea(boolean restrict, SearchBoundary boundary) {
            constructedRequest.rspn = restrict ? 1 : 0;
            constructedRequest.centerLat = boundary.centerLat;
            constructedRequest.centerLng = boundary.centerLng;
            constructedRequest.spanLatDiff = boundary.spanLatDiff;
            constructedRequest.spanLngDiff = boundary.spanLngDiff;
            return this;
        }

        /**
         * Specify maximum amount of returned results. The server never returns JSON with more than 100 results.
         * <br>Even if the {@code results } is greater than 100, the maximal amount of results in response will still be 100.
         *
         *
         * @param results maximal amount of results in response
         * @return the same Builder object
         * @throws IllegalArgumentException if {@code results <= 0}
         */
        public Builder setResults(int results) {
            if (results <= 0) {
                throw new IllegalArgumentException("results < 10 is not allowed");
            }
            constructedRequest.results = results;
            return this;
        }


        /**
         * Specify the amount of records the client should skip in response
         *
         * @param skip amount of results in response to skip
         * @return the same Builder object
         * @throws IllegalArgumentException if skip <= 0
         */
        public Builder setSkip(int skip) {
            if (skip <= 0) {
                throw new IllegalArgumentException("skip < 10 is not allowed");
            }
            constructedRequest.skip = skip;
            return this;
        }

        /**
         * Specify the language of response
         * @param language response language
         *                 @return the same builder object
         */
        public Builder setLanguage(String language) {
            constructedRequest.language = language;
            return this;
        }

        /**
         * Specify the API key (not necessary)
         * @param  key API key
         *             @return the same builder object
         */

        public Builder setKey(String key) {
            constructedRequest.key = key;
            return this;
        }

        /**
         * @return build GeocoderRequest
         * */
        public GeocoderRequest get() {
            return constructedRequest;
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeocoderRequest that = (GeocoderRequest) o;

        if (geocode != null ? !geocode.equals(that.geocode) : that.geocode != null) return false;
        if (kind != null ? !kind.equals(that.kind) : that.kind != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (key != null ? !key.equals(that.key) : that.key != null) return false;

        if (rspn != that.rspn) return false;
        if (centerLat != that.centerLat) return false;
        if (centerLng != that.centerLng) return false;
        if (spanLatDiff != that.spanLatDiff) return false;
        if (spanLngDiff != that.spanLngDiff) return false;
        if (results != that.results) return false;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = geocode != null ? geocode.hashCode() : 0;
        result = 31 * result + (kind != null ? kind.hashCode() : 0);
        result = 31 * result + rspn;

        result = 31 * result + results;
        result = 31 * result + skip;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        //now for doubles
        result = 31 * result + hashDouble(centerLat);
        result = 31 * result + hashDouble(centerLng);
        result = 31 * result + hashDouble(spanLatDiff);
        result = 31 * result + hashDouble(spanLngDiff);

        return result;
    }

    /**
     * tiny formatter for Double
     * @see java.lang.Double
     * */
    private int hashDouble(double value) {
        long bits = Double.doubleToLongBits(value);
        return (int) (bits ^ (bits >>> 32));
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "GeocoderRequest{" +
                "geocode='" + geocode + '\'' +
                ", kind=" + kind +
                ", rspn=" + rspn +
                ", centerLat=" + centerLat +
                ", centerLng=" + centerLng +
                ", spanLatDiff=" + spanLatDiff +
                ", spanLngDiff=" + spanLngDiff +
                ", results=" + results +
                ", skip=" + skip +
                ", language=" + language +
                ", key='" + key + '\'' +
                '}';
    }

    /**
     * Class used to define boundary of search
     */
    public static class SearchBoundary {

        /*Center of boundary lat/lng*/
        private double centerLat;
        private double centerLng;

        /*The spanning parameters of boundary, defined as
        *
        * spanLatDiff = max(lat1, lat2) - min(lat1, lat2)
        * spanLngDiff = max(lng1, lng2) - min(lng1, lng2)
        *
        * where (lat1, lng1), (lat2, lng2) define a lower and upper corners of boundary
        * */
        private double spanLatDiff;
        private double spanLngDiff;

        /**
         * @return lattitude of center of boundary
         */
        public double getCenterLat() {
            return centerLat;
        }

        /**
         * @return longitude of center of boundary
         */
        public double getCenterLng() {
            return centerLng;
        }

        /**
         * @return spanning attribute of lattitude, defined as max(lat1, lat2) - min(lat1, lat2), where (lat1, lng1), (lat2, lng2) define a boundary
         */
        public double getSpanLatDiff() {
            return spanLatDiff;
        }

        /**
         * @return spanning attribute of longitude, defined as max(lng1, lng2) - min(lng1, lng2), where (lat1, lng1), (lat2, lng2) define a boundary
         */
        public double getSpanLngDiff() {
            return spanLngDiff;
        }

        /**
         * Construct a boundary
         *
         * @param centerLat   lattitude of center of boundary
         * @param centerLng   longitude of center of boundary
         * @param spanLatDiff <tt>max(lat1, lat2) - min(lat1, lat2)</tt>, where <tt>(lat1, lng1)</tt>, <tt>(lat2, lng2)</tt> define a boundary
         * @param spanLngDiff <tt>max(lng1, lng2) - min(lng1, lng2)</tt>, where <tt>(lat1, lng1)</tt>, <tt>(lat2, lng2)</tt> define a boundary
         */
        public SearchBoundary(double centerLat, double centerLng, double spanLatDiff, double spanLngDiff) {
            this.centerLat = centerLat;
            this.centerLng = centerLng;
            this.spanLatDiff = spanLatDiff;
            this.spanLngDiff = spanLngDiff;
        }

        /**
         * Construct a boundary
         *
         * @param center location of center of boundary
         * @param point1 one of the boundary points
         * @param point2 another one of the boundary points
         */
        public SearchBoundary(LatLng center, LatLng point1, LatLng point2) {
            assert point1 != null && point2 != null && center != null;
            this.centerLat = center.lat;
            this.centerLng = center.lng;
            this.spanLatDiff = Math.max(point1.getLat(), point2.getLat()) - Math.min(point1.getLat(), point2.getLat());
            this.spanLngDiff = Math.max(point1.getLng(), point2.getLng()) - Math.min(point1.getLng(), point2.getLng());
        }

    }
}
