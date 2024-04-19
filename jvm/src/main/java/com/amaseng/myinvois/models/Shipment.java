package com.amaseng.myinvois.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Shipment {
    private String id;
    private FreightAllowanceCharge freightAllowanceCharge;

    public Shipment(String id, FreightAllowanceCharge freightAllowanceCharge) {
        this.id = id;
        this.freightAllowanceCharge = freightAllowanceCharge;
    }

    public String getId() {
        return id;
    }

    public FreightAllowanceCharge getFreightAllowanceCharge() {
        return freightAllowanceCharge;
    }

    public Map<Object, Object> toMap() {
        return new HashMap<Object, Object>() {{
            put("ID", new ArrayList<Object>() {{ add(new HashMap<Object, Object>() {{ put("_", id); }}); }});
            put("FreightAllowanceCharge", new ArrayList<Object>() {{ add(freightAllowanceCharge.toMap()); }});
        }};
    }
}
