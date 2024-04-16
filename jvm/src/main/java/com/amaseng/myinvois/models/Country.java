package com.amaseng.myinvois.models;

public class Country {
    private String identificationCode;
    private String listID;
    private String listAgencyID;

    public Country(String identificationCode, String listID, String listAgencyID) {
        this.identificationCode = identificationCode;
        this.listID = listID;
        this.listAgencyID = listAgencyID;
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    public String getListID() {
        return listID;
    }

    public String getListAgencyID() {
        return listAgencyID;
    }
}
