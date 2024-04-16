package com.amaseng.myinvois.models;

import java.math.BigDecimal;

public class MonetaryAmount {
    private BigDecimal amount;
    private String currency;

    public MonetaryAmount(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
