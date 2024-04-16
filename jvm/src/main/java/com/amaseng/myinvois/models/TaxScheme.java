package com.amaseng.myinvois.models;

public class TaxScheme {
    private String id;
    private String schemeID;
    private String schemeAgencyID;

    public TaxScheme(String id, String schemeID, String schemeAgencyID) {
        this.id = id;
        this.schemeID = schemeID;
        this.schemeAgencyID = schemeAgencyID;
    }

    public String getId() {
        return id;
    }

    public String getSchemeID() {
        return schemeID;
    }

    public String getSchemeAgencyID() {
        return schemeAgencyID;
    }

}
