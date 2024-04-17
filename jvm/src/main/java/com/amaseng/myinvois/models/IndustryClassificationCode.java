package com.amaseng.myinvois.models;

import java.util.HashMap;
import java.util.Map;

public class IndustryClassificationCode {
    private String id;
    private String name;

    public IndustryClassificationCode(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Object, Object> toMap() {
        return new HashMap<Object, Object>() {{
            put("_", id);
            put("name", name);
        }};
    }
}
