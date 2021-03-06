package com.yandex.geocoder.api.address;

import com.google.gson.annotations.SerializedName;

/**
 * SubAdministrativeArea object, as described at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/reference/geocoder_namespaces-docpage/"> API reference</a> and <a href="http://docs.oasis-open.org/election/external/xAL.xsd">xAL 2.0</a>
 */
public  class SubAdministrativeArea {
    @SerializedName("SubAdministrativeAreaName")
    String subAdministrativeAreaName;
    @SerializedName("Locality")
    Locality locality;

    SubAdministrativeArea(){

    }

    /**
     * @return name of the SubAdministrativeArea
     * */
    public String getSubAdministrativeAreaName() {
        return subAdministrativeAreaName;
    }

    /**
     * @return Locality object
     * */
    public Locality getLocality() {
        return locality;
    }

}
