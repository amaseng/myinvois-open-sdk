package com.amaseng.myinvois.models;

import java.util.*;

public class X509Data{
    private String x509Certificate;
    private String x509SubjectName;
    private X509IssuerSerial x509IssuerSerial;

    public X509Data(String x509Certificate, String x509SubjectName, X509IssuerSerial x509IssuerSerial)
    {
        this.x509Certificate = x509Certificate;
        this.x509SubjectName = x509SubjectName;
        this.x509IssuerSerial = x509IssuerSerial;
    }

    public String getX509Certificate()
    {
        return x509Certificate;
    }

    public String getX509SubjectName()
    {
        return x509SubjectName;
    }

    public X509IssuerSerial getX509IssuerSerial()
    {
        return x509IssuerSerial;
    }

        public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("X509Certificate", new ArrayList<Object>() {{ 
                add(new LinkedHashMap<Object, Object>() {{ 
                    put("_", x509Certificate); 
                }}); 
            }});
            put("X509SubjectName", new ArrayList<Object>() {{ 
                add(new LinkedHashMap<Object, Object>() {{ 
                    put("_", x509SubjectName); 
                }}); 
            }});  
            put("X509IssuerSerial", new ArrayList<Object>() {{ 
                add(x509IssuerSerial.toMap()); }});
        }};
    }
}