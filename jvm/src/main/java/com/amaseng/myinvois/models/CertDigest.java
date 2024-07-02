package com.amaseng.myinvois.models;

import java.util.*;

public class CertDigest{
    private String digestMethod;
    private String digestValue;

    public CertDigest(String digestMethod, String digestValue)
    {
        this.digestMethod = digestMethod;
        this.digestValue = digestValue;
    }

    public String getDigestMethod()
    {
        return digestMethod;
    }

    public String getDigestValue()
    {
        return digestValue;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("DigestMethod", new ArrayList<Object>() {{
                add(new LinkedHashMap<Object, Object>() {{
                    put("_", digestMethod);
                }});
            }});
            put("DigestValue", new ArrayList<Object>() {{
                add(new LinkedHashMap<Object, Object>() {{
                    put("_", digestValue);
                }});
            }});
        }};
    }
}