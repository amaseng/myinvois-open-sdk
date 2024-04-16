package com.amaseng.myinvois.models;

public class TaxTotal {
    private MonetaryAmount taxAmount;
    private TaxSubTotal[] taxSubTotal;

    public TaxTotal(MonetaryAmount taxAmount, TaxSubTotal[] taxSubTotal) {
        this.taxAmount = taxAmount;
        this.taxSubTotal = taxSubTotal;
    }

    public MonetaryAmount getTaxAmount() {
        return taxAmount;
    }

    public TaxSubTotal[] getTaxSubTotal() {
        return taxSubTotal;
    }
}
