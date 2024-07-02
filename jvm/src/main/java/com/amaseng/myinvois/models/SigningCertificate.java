package com.amaseng.myinvois.models;

import java.util.*;

public class SigningCertificate{

    private Cert cert;

    public SigningCertificate(Cert cert)
    {
        this.cert = cert;
    }

    public Cert getCert()
    {
        return cert;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{      
           put("Cert", new ArrayList<Object>() {{ add(cert.toMap()); }});
        }};
    }
    
}