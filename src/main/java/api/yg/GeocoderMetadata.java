package api.yg;

import api.xal.AddressDetails;
import com.google.gson.annotations.SerializedName;

/**
 * Contains detailed information on the found toponym
 * <br>More info at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/reference/GeocoderMetaData-docpage/">API reference documentation</a>
 */
public class GeocoderMetadata {

    /*Kind of toponym*/
    @SerializedName("kind")
    private Kind kind;

    /*Precision of match request-respone building number pos */
    @SerializedName("precision")
    private Precision precision;

    /*Full toponym address*/
    @SerializedName("text")
    private String text;

    @SerializedName("AddressDetails")
    private AddressDetails addressDetails;

    GeocoderMetadata() {
    }


    /**
     * @return Kind of the toponym
     * <br>Described at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/reference/GeocoderMetaData-docpage/">API 1.x</a>
     */
    public Kind getKind() {
        return kind;
    }


    /**
     * @return Precision of the found toponym
     * <br>Described at Yandex Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/reference/GeocoderMetaData-docpage/">API 1.x</a>
     */
    public Precision getPrecision() {
        return precision;
    }


    /**
     * @return Full address of the found toponym, returned as a single String
     * <br>Described at Yandex Geocoder<a href="https://tech.yandex.ru/maps/doc/geocoder/desc/reference/GeocoderMetaData-docpage/">API 1.x</a>
     */
    public String getText() {
        return text;
    }


    /**
     * @return AddressDetails object of the found toponym
     * <br>Described at Yandex  Geocoder <a href="https://tech.yandex.ru/maps/doc/geocoder/desc/reference/GeocoderMetaData-docpage/">API 1.x</a>
     */
    public AddressDetails getAddressDetails() {
        return addressDetails;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeocoderMetadata that = (GeocoderMetadata) o;

        if (kind != null ? !kind.equals(that.kind) : that.kind != null) return false;
        if (precision != null ? !precision.equals(that.precision) : that.precision != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (addressDetails != null ? !addressDetails.equals(that.addressDetails) : that.addressDetails != null)
            return false;

        return true;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = kind != null ? kind.hashCode() : 0;
        result = 31 * result + (precision != null ? precision.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (addressDetails != null ? addressDetails.hashCode() : 0);
        return result;
    }


}
