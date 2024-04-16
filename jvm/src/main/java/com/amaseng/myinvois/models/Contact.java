package com.amaseng.myinvois.models;

public class Contact {
    private String telephone;
    private String electronicMail;

    public Contact(String telephone, String electronicMail) {
        this.telephone = telephone;
        this.electronicMail = electronicMail;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getElectronicMail() {
        return electronicMail;
    }
}
