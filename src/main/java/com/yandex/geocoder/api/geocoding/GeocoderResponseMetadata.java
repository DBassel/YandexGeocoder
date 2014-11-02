package com.yandex.geocoder.api.geocoding;

import com.google.gson.annotations.SerializedName;

/**
 * Server response metadata
 */
public class GeocoderResponseMetadata {

    /*Requested address*/
    @SerializedName("request")
    private String request;

    /*Contains part of word corrected by Yandex typo-service
    * XML example: <yg:suggest>m<fix>o</fix>scow</yg:suggest> for request "mascow"
    * */
    @SerializedName("suggest")
    private String suggest;

    /*Amount of toponyms found */
    @SerializedName("found")
    private int found;

    /*Amount of requested results*/
    @SerializedName("results")
    private int results;

    /*How much elements should one skip in server response*/
    @SerializedName("skip")
    private int skip;

    GeocoderResponseMetadata(){

    }

    /**
     * Requested address
     *
     * @return requested address
     */
    public String getRequest() {
        return request;
    }


    /**
     * Return part of word corrected by Yandex typo-service
     * XML example: <yg:suggest>m<fix>o</fix>scow</yg:suggest> for request "mascow"
     * */
    public String getSuggest() {
        return suggest;
    }



    /**
     * @return Amount of toponyms found
     */
    public int getFound() {
        return found;
    }

    /**
     * @return maximal amount of results in response
     */
    public int getResults() {
        return results;
    }


    /**
     * @return how much elements should one skip in server response
     */
    public int getSkip() {
        return skip;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = request != null ? request.hashCode() : 0;
        result = 31 * result + found;
        result = 31 * result + this.results;
        result = 31 * result + skip;
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeocoderResponseMetadata that = (GeocoderResponseMetadata) o;

        if (request != null ? !request.equals(that.request) : that.request != null) return false;
        if (results != that.results) return false;
        if (found != that.found) return false;
        if (skip != that.skip) return false;

        return true;
    }


}
