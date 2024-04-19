package com.amaseng.myinvois.models;

import java.util.LinkedHashMap;
import java.util.Map;

public class PartyIdentification {
    private String id;
    private String schemeID;

    public PartyIdentification(String id, String schemeID) {
        this.id = id;
        this.schemeID = schemeID;
    }

    public String getId() {
        return id;
    }

    public String getSchemeID() {
        return schemeID;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("_", id);
            put("schemeID", schemeID);
        }};
    }
}
