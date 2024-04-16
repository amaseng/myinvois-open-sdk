package com.amaseng.myinvois.models;

import java.math.BigDecimal;

public class QuantityUnit {
    private BigDecimal quantity;
    private String unitCode;

    public QuantityUnit(BigDecimal quantity, String unitCode) {
        this.quantity = quantity;
        this.unitCode = unitCode;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public String getUnitCode() {
        return unitCode;
    }
}
