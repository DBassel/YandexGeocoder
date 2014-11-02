package com.yandex.geocoder.api.address;

import com.google.gson.annotations.SerializedName;

/**
 * Country, as described at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/reference/geocoder_namespaces-docpage/"> API reference</a> and <a href="http://docs.oasis-open.org/election/external/xAL.xsd">xAL 2.0</a>
 */
public class Country {
    @SerializedName("AddressLine")
    String addressLine;
    @SerializedName("CountryNameCode")
    String countryNameCode;
    @SerializedName("CountryName")
    String countryName;
    @SerializedName("AdministrativeArea")
    AdministrativeArea administrativeArea;

    Country(){

    }

    /**
     * @return fully qualified address line
     * */
    public String getAddressLine() {
        return addressLine;
    }

    /**
     * @return ISO 3166-1 Alpha-2 code of country
     * */
    public String getCountryNameCode() {
        return countryNameCode;
    }


    /**
     * @return country name
     * */
    public String getCountryName() {
        return countryName;
    }


    /**
     * @return AdministrativeArea object
     * */
    public AdministrativeArea getAdministrativeArea() {
        return administrativeArea;
    }


}


