package com.yandex.geocoder.api.geocoding;


/**
 * Kind of toponym
 * <br>Described at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/concepts/About-docpage/"> API 1.x</a>
 *
 */
public interface Kind {

    String HOUSE = "house";
    String STREET = "street";
    String METRO = "metro";
    String DISTRICT = "district";
    String LOCALITY = "locality";
    String AREA = "area";
    String PROVINCE = "province";
    String COUNTRY = "country";
    String HYDRO = "hydro";
    String RAILWAY = "railway";
    String ROUTE = "route";
    String VEGETATION = "vegetation";
    String AIRPORT = "airport";
    String OTHER = "other";
}
