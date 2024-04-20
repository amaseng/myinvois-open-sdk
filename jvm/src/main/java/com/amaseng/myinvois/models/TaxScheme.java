package com.amaseng.myinvois.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaxScheme {
    private String id;
    private String schemeID;
    private String schemeAgencyID;

    public TaxScheme(String id, String schemeID, String schemeAgencyID) {
        this.id = id;
        this.schemeID = schemeID;
        this.schemeAgencyID = schemeAgencyID;
    }

    public String getId() {
        return id;
    }

    public String getSchemeID() {
        return schemeID;
    }

    public String getSchemeAgencyID() {
        return schemeAgencyID;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("ID", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{
            put("_", id);
            put("schemeID", schemeID);
            put("schemeAgencyID", schemeAgencyID);
        }}); }});
        return map;
    }

}
