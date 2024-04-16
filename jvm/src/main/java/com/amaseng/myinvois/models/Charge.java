package com.amaseng.myinvois.models;

import java.math.BigDecimal;

public class Charge {
    private boolean chargeIndicator;
    private String allowanceChargeReason;
    private BigDecimal multiplierFactorNumeric;
    private MonetaryAmount amount;

    public Charge(boolean chargeIndicator, String allowanceChargeReason, BigDecimal multiplierFactorNumeric, MonetaryAmount amount) {
        this.chargeIndicator = chargeIndicator;
        this.allowanceChargeReason = allowanceChargeReason;
        this.multiplierFactorNumeric = multiplierFactorNumeric;
        this.amount = amount;
    }

    public boolean getChargeIndicator() {
        return chargeIndicator;
    }

    public String getAllowanceChargeReason() {
        return allowanceChargeReason;
    }

    public BigDecimal getMultiplierFactorNumeric() {
        return multiplierFactorNumeric;
    }

    public MonetaryAmount getAmount() {
        return amount;
    }
}
