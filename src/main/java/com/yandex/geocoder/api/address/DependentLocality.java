package com.yandex.geocoder.api.address;


import com.google.gson.annotations.SerializedName;

public class DependentLocality {


    @SerializedName("DependentLocalityName")
    String dependentLocalityName;
    @SerializedName("Thoroughfare")
    Thoroughfare thoroughfare;
    @SerializedName("Premise")
    Premise premise;

    DependentLocality() {

    }

    /**
     * @return name of locality
     */
    public String getDependentLocalityName() {
        return dependentLocalityName;
    }


    /**
     * @return thoroughfare object
     */
    public Thoroughfare getThoroughfare() {
        return thoroughfare;
    }


    /**
     * @return get premise, if any
     * */
    public Premise getPremise() {
        return premise;
    }
}
