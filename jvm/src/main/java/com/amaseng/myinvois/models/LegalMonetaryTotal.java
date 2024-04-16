package com.amaseng.myinvois.models;

public class LegalMonetaryTotal {
    private MonetaryAmount lineExtensionAmount;
    private MonetaryAmount TaxExclusiveAmount;
    private MonetaryAmount taxInclusiveAmount;
    private MonetaryAmount allowanceTotalAmount;
    private MonetaryAmount chargeTotalAmount;
    private MonetaryAmount payableRoundingAmount;
    private MonetaryAmount payableAmount;

    public LegalMonetaryTotal(MonetaryAmount lineExtensionAmount, MonetaryAmount TaxExclusiveAmount, MonetaryAmount taxInclusiveAmount, MonetaryAmount allowanceTotalAmount, MonetaryAmount chargeTotalAmount, MonetaryAmount payableRoundingAmount, MonetaryAmount payableAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
        this.TaxExclusiveAmount = TaxExclusiveAmount;
        this.taxInclusiveAmount = taxInclusiveAmount;
        this.allowanceTotalAmount = allowanceTotalAmount;
        this.chargeTotalAmount = chargeTotalAmount;
        this.payableRoundingAmount = payableRoundingAmount;
        this.payableAmount = payableAmount;
    }

    public MonetaryAmount getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public MonetaryAmount getTaxExclusiveAmount() {
        return TaxExclusiveAmount;
    }

    public MonetaryAmount getTaxInclusiveAmount() {
        return taxInclusiveAmount;
    }

    public MonetaryAmount getAllowanceTotalAmount() {
        return allowanceTotalAmount;
    }

    public MonetaryAmount getChargeTotalAmount() {
        return chargeTotalAmount;
    }

    public MonetaryAmount getPayableRoundingAmount() {
        return payableRoundingAmount;
    }

    public MonetaryAmount getPayableAmount() {
        return payableAmount;
    }
}
