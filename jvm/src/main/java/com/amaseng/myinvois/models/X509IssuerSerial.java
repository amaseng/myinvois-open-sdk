package com.amaseng.myinvois.models;

import java.util.*;

public class X509IssuerSerial{
    private String x509IssuerName;
    private String x509SerialNumber;

    public X509IssuerSerial(String x509IssuerName, String x509SerialNumber)
    {
        this.x509IssuerName = x509IssuerName;
        this.x509SerialNumber = x509SerialNumber;
    }

    public String getX509IssuerName()
    {
        return x509IssuerName;
    }

    public String getX509SerialNumber()
    {
        return x509SerialNumber;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("X509IssuerName", new ArrayList<Object>() {{ 
                add(new LinkedHashMap<Object, Object>() {{ 
                    put("_", x509IssuerName); 
                }}); 
            }});
            put("X509SerialNumber", new ArrayList<Object>() {{ 
                add(new LinkedHashMap<Object, Object>() {{ 
                    put("_", x509SerialNumber); 
                }}); 
            }});  
        }};
    }
}