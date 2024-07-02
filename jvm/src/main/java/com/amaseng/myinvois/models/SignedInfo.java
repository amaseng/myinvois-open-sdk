package com.amaseng.myinvois.models;

import java.util.*;

public class SignedInfo{

    private String signedInfo;
    private String canonicalizationMethod;
    private String signatureMethod;
    private Reference[] reference;

    public SignedInfo(String signedInfo, String canonicalizationMethod, String signatureMethod, Reference[] reference)
    {
        this.signedInfo = signedInfo;
        this.canonicalizationMethod = canonicalizationMethod;
        this.signatureMethod = signatureMethod;
        this.reference = reference;
    }

    public String getSignedInfo()
    {
        return signedInfo;
    }

    public String getCanonicalizationMethod()
    {
        return canonicalizationMethod;
    }

    public String getSignatureMethod()
    {
        return signatureMethod;
    }

    public Reference[] getReference()
    {
        return reference;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
                    put("_", signedInfo);
                    put("CanonicalizationMethod", new ArrayList<Object>() {{
                        add(new LinkedHashMap<Object, Object>() {{
                            put("_", canonicalizationMethod);
                        }});
                    }});   
                    put("SignatureMethod", new ArrayList<Object>() {{
                        add(new LinkedHashMap<Object, Object>() {{
                            put("_", signatureMethod);
                        }});
                    }});
                    put("Reference", Arrays.stream(reference).map(Reference::toMap).toArray());
        }};
    }
}