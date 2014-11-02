package api.xal;

import com.google.gson.annotations.SerializedName;


/**
 * AdministrativeArea, as described at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/reference/geocoder_namespaces-docpage/"> API reference</a> and <a href="http://docs.oasis-open.org/election/external/xAL.xsd">xAL 2.0</a>
 */
public class AdministrativeArea {

    @SerializedName("AdministrativeAreaName")
    String administrativeAreaName;

    @SerializedName("SubAdministrativeArea")
    SubAdministrativeArea subAdministrativeArea;


    AdministrativeArea(){

    }
    /**
     * @return name of the administrative area
     * */
    public String getAdministrativeAreaName() {
        return administrativeAreaName;
    }

    /**
     * @return SubAdministrativeArea object
     * */
    public SubAdministrativeArea getSubAdministrativeArea() {
        return subAdministrativeArea;
    }

}
