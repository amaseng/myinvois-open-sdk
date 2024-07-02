package com.amaseng.myinvois.models;

import java.util.*;

public class Cert{
    private CertDigest certDigest;
    private IssuerSerial issuerSerial;

    public Cert(CertDigest certDigest, IssuerSerial issuerSerial)
    {
        this.certDigest = certDigest;
        this.issuerSerial = issuerSerial;
    }

    public CertDigest getCertDigest()
    {
        return certDigest;
    }

    public IssuerSerial getIssuerSerial()
    {
        return issuerSerial;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("CertDigest", new ArrayList<Object>() {{ add(certDigest.toMap()); }});
            put("IssuerSerial", new ArrayList<Object>() {{ add(issuerSerial.toMap()); }}); 
        }};
    }
}