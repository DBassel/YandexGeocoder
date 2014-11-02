package com.yandex.geocoder.api.address;

import com.google.gson.annotations.SerializedName;

/**
 * Locality, as described at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/reference/geocoder_namespaces-docpage/"> API reference</a> and <a href="http://docs.oasis-open.org/election/external/xAL.xsd">xAL 2.0</a>
 */
public  class Locality {
    @SerializedName("LocalityName")
    String localityName;
    @SerializedName("Thoroughfare")
    Thoroughfare thoroughfare;
    @SerializedName("DependentLocality")
    DependentLocality dependentLocality;


    Locality() {

    }

    /**
     * @return name of the locality
     * */
    public String getLocalityName() {
        return localityName;
    }

    /**
     * @return Thoroughfare object
     * */
    public Thoroughfare getThoroughfare() {
        return thoroughfare;
    }


    /**
     *
     * @return dependent locality.
     * */
    public DependentLocality getDependentLocality() {
        return dependentLocality;
    }
}
