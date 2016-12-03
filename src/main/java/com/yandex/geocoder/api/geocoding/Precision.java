package com.yandex.geocoder.api.geocoding;

/**
 * Precision of match when comparing building number from response with found building number.
 * Described at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/concepts/input_params-docpage/"> API 1.x</a>
 */
public interface Precision {

    String EXACT = "exact";
    String NUMBER = "number";
    String NEAR = "near";
    String RANGE = "range";
    String STREET = "street";
    String OTHER = "other";

}
