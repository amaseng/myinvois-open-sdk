package com.amaseng.myinvois.models;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Charge {
    private boolean chargeIndicator;
    private String allowanceChargeReason;
    private Optional<BigDecimal> multiplierFactorNumeric;
    private MonetaryAmount amount;

    public Charge(boolean chargeIndicator, String allowanceChargeReason, Optional<BigDecimal> multiplierFactorNumeric, MonetaryAmount amount) {
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

    public Optional<BigDecimal> getMultiplierFactorNumeric() {
        return multiplierFactorNumeric;
    }

    public MonetaryAmount getAmount() {
        return amount;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("ChargeIndicator", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", chargeIndicator); }}); }});
        map.put("AllowanceChargeReason", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", allowanceChargeReason); }}); }});
        multiplierFactorNumeric.ifPresent(multiplierFactorNumeric -> map.put("MultiplierFactorNumeric", new ArrayList<Object>() {{ add(multiplierFactorNumeric); }}));
        map.put("Amount", new ArrayList<Object>() {{ add(amount.toMap()); }});
        return map;
    }
}
