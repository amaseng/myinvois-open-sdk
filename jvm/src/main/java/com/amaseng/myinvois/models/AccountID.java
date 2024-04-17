package com.amaseng.myinvois.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AccountID {
    private String id;
    private String schemeAgencyName;

    public AccountID(String id, String schemeAgencyName) {
        this.id = id;
        this.schemeAgencyName = schemeAgencyName;
    }

    public String getId() {
        return id;
    }

    public String getSchemeAgencyName() {
        return schemeAgencyName;
    }

    public Map<Object, Object> toMap() {
        return new HashMap<Object, Object>() {{
            put("_", id);
            put("schemeAgencyName", schemeAgencyName);
        }};
    }
}
