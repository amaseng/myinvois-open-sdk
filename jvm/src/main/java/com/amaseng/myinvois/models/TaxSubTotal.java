package com.amaseng.myinvois.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaxSubTotal {
    private MonetaryAmount taxableAmount;
    private MonetaryAmount taxAmount;
    private TaxCategory taxCategory;

    public TaxSubTotal(MonetaryAmount taxableAmount, MonetaryAmount taxAmount, TaxCategory taxCategory) {
        this.taxableAmount = taxableAmount;
        this.taxAmount = taxAmount;
        this.taxCategory = taxCategory;
    }

    public MonetaryAmount getTaxableAmount() {
        return taxableAmount;
    }

    public MonetaryAmount getTaxAmount() {
        return taxAmount;
    }

    public TaxCategory getTaxCategory() {
        return taxCategory;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("TaxableAmount", new ArrayList<Object>() {{ add(taxableAmount.toMap()); }});
        map.put("TaxAmount", new ArrayList<Object>() {{ add(taxAmount.toMap()); }});
        map.put("TaxCategory", new ArrayList<Object>() {{ add(taxCategory.toMap()); }});
        return map;
    }
}
