package com.amaseng.myinvois.models;

public class TaxCategory {
    private String id;
    private TaxScheme taxScheme;

    public TaxCategory(String id, TaxScheme taxScheme) {
        this.id = id;
        this.taxScheme = taxScheme;
    }

    public String getId() {
        return id;
    }

    public TaxScheme getTaxScheme() {
        return taxScheme;
    }
}
