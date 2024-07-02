package com.amaseng.myinvois.models;

import java.util.*;

public class SignedProperties{

    private SignedSignatureProperties signedSignatureProperties;

    public SignedProperties(SignedSignatureProperties signedSignatureProperties) 
    {
        this.signedSignatureProperties = signedSignatureProperties;
    }

    public SignedSignatureProperties getSignedSignatureProperties()
    {
        return signedSignatureProperties;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("SignedProperties", new ArrayList<Object>() {{ add(signedSignatureProperties.toMap()); }});
        }};
    }
   
}