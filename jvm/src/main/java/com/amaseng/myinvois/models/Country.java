package com.amaseng.myinvois.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Country {
    private String identificationCode;
    private String listID;
    private String listAgencyID;

    public Country(String identificationCode, String listID, String listAgencyID) {
        this.identificationCode = identificationCode;
        this.listID = listID;
        this.listAgencyID = listAgencyID;
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    public String getListID() {
        return listID;
    }

    public String getListAgencyID() {
        return listAgencyID;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("IdentificationCode", new ArrayList<Object>() {{
                add(new LinkedHashMap<Object, Object>() {{
                    put("_", identificationCode);
                    put("listID", listID);
                    put("listAgencyID", listAgencyID);
                }});
            }});
        }};
    }
}
