package com.amaseng.myinvois.models;

public class TaxSubTotal {
    private MonetaryAmount taxableAmount;
    private MonetaryAmount taxAmount;
    private TaxCategory taxCategory;

    public TaxSubTotal(MonetaryAmount taxableAmount, MonetaryAmount taxAmount, TaxCategory taxCategory) {
        this.taxableAmount = taxableAmount;
        this.taxAmount = taxAmount;
        this.taxCategory = taxCategory;
    }

    public MonetaryAmount getTaxableAmount() {
        return taxableAmount;
    }

    public MonetaryAmount getTaxAmount() {
        return taxAmount;
    }

    public TaxCategory getTaxCategory() {
        return taxCategory;
    }
}
