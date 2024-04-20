package com.amaseng.myinvois.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaxCategory {
    private String id;
    private BigDecimal percent;
    private TaxScheme taxScheme;

    public TaxCategory(String id, BigDecimal percent, TaxScheme taxScheme) {
        this.id = id;
        this.percent = percent;
        this.taxScheme = taxScheme;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public TaxScheme getTaxScheme() {
        return taxScheme;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("ID", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", id); }}); }});
        map.put("Percent", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", percent); }}); }});
        map.put("TaxScheme", new ArrayList<Object>() {{ add(taxScheme.toMap()); }});
        return map;
    }
}
