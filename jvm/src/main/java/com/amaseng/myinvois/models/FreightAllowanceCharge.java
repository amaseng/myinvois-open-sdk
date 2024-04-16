package com.amaseng.myinvois.models;

import java.math.BigDecimal;

public class FreightAllowanceCharge {
    private boolean chargeIndicator;
    private String allowanceChargeReason;
    private BigDecimal amount;

    public FreightAllowanceCharge(boolean chargeIndicator, String allowanceChargeReason, BigDecimal amount) {
        this.chargeIndicator = chargeIndicator;
        this.allowanceChargeReason = allowanceChargeReason;
        this.amount = amount;
    }

    public boolean getChargeIndicator() {
        return chargeIndicator;
    }

    public String getAllowanceChargeReason() {
        return allowanceChargeReason;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
