package com.amaseng.myinvois.models;

import java.util.*;

public class Signature{
    private SignedInfo signedInfo;
    private String signatureValue;
    private KeyInfo keyInfo;
    private QualifyingProperties qualifyingProperties;

    public Signature(SignedInfo signedInfo, String signatureValue, KeyInfo keyInfo, QualifyingProperties qualifyingProperties)
    {
        this.signedInfo = signedInfo;
        this.signatureValue = signatureValue;
        this.keyInfo = keyInfo;
        this.qualifyingProperties = qualifyingProperties;
    }

    public SignedInfo getSignedInfo()
    {
        return signedInfo;
    }

    public String getSignatureValue()
    {
        return signatureValue;
    }

    public KeyInfo getKeyInfo()
    {
        return keyInfo;
    }

    public QualifyingProperties getQualifyingProperties()
    {
        return qualifyingProperties;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("SignedInfo", new ArrayList<Object>() {{ add(signedInfo.toMap()); }});
            put("SignatureValue", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", signatureValue); }}); }});
            put("KeyInfo", new ArrayList<Object>() {{ add(keyInfo.toMap()); }});
            put("Object", new ArrayList<Object>() {{ add(qualifyingProperties.toMap()); }});
        }};
    }
}