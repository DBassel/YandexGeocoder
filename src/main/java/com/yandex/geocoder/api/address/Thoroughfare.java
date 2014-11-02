package com.yandex.geocoder.api.address;

import com.google.gson.annotations.SerializedName;

/**
 * Thoroughfare, as described at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/reference/geocoder_namespaces-docpage/"> API reference</a> and <a href="http://docs.oasis-open.org/election/external/xAL.xsd">xAL 2.0</a>
 */
public class Thoroughfare {
    @SerializedName("ThoroughfareName")
    String thoroughfareName;

    @SerializedName("Premise")
    Premise premise;

    Thoroughfare(){

    }

    /**
     * @return name of the thoroughfare
     * */
    public String getThoroughfareName() {
        return thoroughfareName;
    }


    /**
     * @return Premise object
     * */
    public Premise getPremise() {
        return premise;
    }


}