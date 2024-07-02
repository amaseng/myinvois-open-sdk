package com.amaseng.myinvois.models;

import java.util.*;

public class SignedSignatureProperties{

    private String signingTime;
    private SigningCertificate signingCertificate;
    
    public SignedSignatureProperties(String signingTime, SigningCertificate signingCertificate)
    {
        this.signingTime = signingTime;
        this.signingCertificate = signingCertificate;
    }
    public String getSigningTime()
    {
        return signingTime;
    }

    public SigningCertificate getSigningCertificate()
    {
        return signingCertificate;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{      
           put("SigningTime", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", signingTime); }}); }});
           put("SigningCertificate", new ArrayList<Object>() {{ add(signingCertificate.toMap()); }});
        }};
    }

}