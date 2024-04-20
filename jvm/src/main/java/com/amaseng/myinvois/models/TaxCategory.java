package com.amaseng.myinvois.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaxCategory {
    private String id;
    private TaxScheme taxScheme;

    public TaxCategory(String id, TaxScheme taxScheme) {
        this.id = id;
        this.taxScheme = taxScheme;
    }

    public String getId() {
        return id;
    }

    public TaxScheme getTaxScheme() {
        return taxScheme;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("ID", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", id); }}); }});
        map.put("TaxScheme", new ArrayList<Object>() {{ add(taxScheme.toMap()); }});
        return map;
    }
}
