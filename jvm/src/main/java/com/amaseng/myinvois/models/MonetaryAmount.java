package com.amaseng.myinvois.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MonetaryAmount {
    private BigDecimal amount;
    private String currencyID;

    public MonetaryAmount(BigDecimal amount, String currencyID) {
        this.amount = amount;
        this.currencyID = currencyID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrencyID() {
        return currencyID;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("_", amount);
        map.put("currencyID", currencyID);
        return map;
    }
}
