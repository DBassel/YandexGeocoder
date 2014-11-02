package api.xal;

import com.google.gson.annotations.SerializedName;

/**
 * Premise, as described at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/reference/geocoder_namespaces-docpage/"> API reference</a> and <a href="http://docs.oasis-open.org/election/external/xAL.xsd">xAL 2.0</a>
 */
public class Premise {
    @SerializedName("PremiseNumber")
    String premiseNumber;

    Premise(){

    }

    /**
     * @return premise number String
     * */
    public String getPremiseNumber() {
        return premiseNumber;
    }

}
