package com.amaseng.myinvois.models;

public class AccountID {
    private String id;
    private String schemeAgencyName;

    public AccountID(String id, String schemeAgencyName) {
        this.id = id;
        this.schemeAgencyName = schemeAgencyName;
    }

    public String getId() {
        return id;
    }

    public String getSchemeAgencyName() {
        return schemeAgencyName;
    }
}
