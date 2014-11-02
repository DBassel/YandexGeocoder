package com.yandex.geocoder.api.address;


import com.google.gson.annotations.SerializedName;

/**
 * AddressDetails, as described at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/reference/geocoder_namespaces-docpage/"> API reference</a> and <a href="http://docs.oasis-open.org/election/external/xAL.xsd">xAL 2.0</a>
 */
public class AddressDetails {


    AddressDetails() {
    }


    @SerializedName("Country")
    private Country country;

    /**@return Country object*/
    public Country getCountry() {
        return country;
    }


}
