package com.amaseng.myinvois.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class PaymentTerms {
    private String note;

    public PaymentTerms(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("Note", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", note); }}); }});
        return map;
    }
}
