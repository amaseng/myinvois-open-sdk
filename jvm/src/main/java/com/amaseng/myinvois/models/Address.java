package com.amaseng.myinvois.models;

public class Address {
    private String cityName;
    private String postalZone;
    private String countrySubentityCode;
    private String[] addressLine;
    private Country country;

    public Address(String cityName, String postalZone, String countrySubentityCode, String[] addressLine, Country country) {
        this.cityName = cityName;
        this.postalZone = postalZone;
        this.countrySubentityCode = countrySubentityCode;
        this.addressLine = addressLine;
        this.country = country;
    }

    public String getCityName() {
        return cityName;
    }

    public String getPostalZone() {
        return postalZone;
    }

    public String getCountrySubentityCode() {
        return countrySubentityCode;
    }

    public String[] getAddressLine() {
        return addressLine;
    }

    public Country getCountry() {
        return country;
    }
}