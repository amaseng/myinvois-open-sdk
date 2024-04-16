package com.amaseng.myinvois.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Contact {
    private String telephone;
    private String electronicMail;

    public Contact(String telephone, String electronicMail) {
        this.telephone = telephone;
        this.electronicMail = electronicMail;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getElectronicMail() {
        return electronicMail;
    }

    public Map<Object, Object> toMap() {
        return new HashMap<Object, Object>() {{
            put("Telephone", new ArrayList<Object>() {{
                add(new HashMap<Object, Object>() {{
                    put("_", telephone);
                }});
            }});
            put("ElectronicMail", new ArrayList<Object>() {{
                add(new HashMap<Object, Object>() {{
                    put("_", electronicMail);
                }});
            }});
        }};
    }
}
