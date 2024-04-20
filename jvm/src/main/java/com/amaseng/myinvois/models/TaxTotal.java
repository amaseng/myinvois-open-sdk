package com.amaseng.myinvois.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaxTotal {
    private MonetaryAmount taxAmount;
    private TaxSubTotal[] taxSubTotal;

    public TaxTotal(MonetaryAmount taxAmount, TaxSubTotal[] taxSubTotal) {
        this.taxAmount = taxAmount;
        this.taxSubTotal = taxSubTotal;
    }

    public MonetaryAmount getTaxAmount() {
        return taxAmount;
    }

    public TaxSubTotal[] getTaxSubTotal() {
        return taxSubTotal;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("TaxAmount", new ArrayList<Object>() {{ add(taxAmount.toMap()); }});
        if (taxSubTotal != null && taxSubTotal.length > 0)
            map.put("TaxSubtotal", Arrays.stream(taxSubTotal).map(TaxSubTotal::toMap).toArray());
        return map;
    }
}
