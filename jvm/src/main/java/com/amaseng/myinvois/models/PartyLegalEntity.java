package com.amaseng.myinvois.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class PartyLegalEntity {
    private String registrationName;

    public PartyLegalEntity(String registrationName) {
        this.registrationName = registrationName;
    }

    public String getRegistrationName() {
        return registrationName;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("RegistrationName", new ArrayList<Object>() {{
                add(new LinkedHashMap<Object, Object>() {{
                    put("_", registrationName);
                }});
            }});
        }};
    }
}
