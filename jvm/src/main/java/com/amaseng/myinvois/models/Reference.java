package com.amaseng.myinvois.models;

import java.util.*;

public class Reference{
    
    private Optional<Transform> transform; 
    private String digestValue;
    private String digestMethod;
    
    public Reference(Optional<Transform> transform, String digestValue, String digestMethod)
    {
        this.transform = transform;
        this.digestValue = digestValue;
        this.digestMethod = digestMethod;
    }

    public Optional<Transform> getTransform()
    {
        return transform;
    }

    public String getDigestValue()
    {
        return digestValue;
    }

    public String getDigestMethod()
    {
        return digestMethod;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{      
            transform.ifPresent(transform -> put("Transforms", new ArrayList<Object>() {{ add(transform.toMap()); }}));
            put("DigestValue", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", digestValue); }}); }});
            put("DigestMethod", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", digestMethod); }}); }});
        }};
    }

}