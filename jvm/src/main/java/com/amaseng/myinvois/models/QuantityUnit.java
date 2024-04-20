package com.amaseng.myinvois.models;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

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

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("_", quantity);
        map.put("unitCode", unitCode);
        return map;
    }
}
