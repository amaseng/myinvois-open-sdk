package com.amaseng.myinvois.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class FreightAllowanceCharge {
    private boolean chargeIndicator;
    private String allowanceChargeReason;
    private BigDecimal amount;
    private String currencyID;

    public FreightAllowanceCharge(boolean chargeIndicator, String allowanceChargeReason, BigDecimal amount, String currencyID) {
        this.chargeIndicator = chargeIndicator;
        this.allowanceChargeReason = allowanceChargeReason;
        this.amount = amount;
        this.currencyID = currencyID;
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

    public String getCurrencyID() {
        return currencyID;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("ChargeIndicator", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", chargeIndicator); }}); }});
            put("AllowanceChargeReason", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", allowanceChargeReason); }}); }});
            put("Amount", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{
                put("_", amount);
                put("currencyID", currencyID);
            }}); }});
        }};
    }
}
