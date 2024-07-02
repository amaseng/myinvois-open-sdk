package com.amaseng.myinvois.models;

import java.util.*;

public class TestingObject{

    private QualifyingProperties qualifyingProperties;

    public TestingObject(QualifyingProperties qualifyingProperties)
    {
        this.qualifyingProperties = qualifyingProperties;
    }

    public QualifyingProperties getQualifyingProperties()
    {
        return qualifyingProperties;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("SignedProperties", new ArrayList<Object>() {{ add(qualifyingProperties.toMap()); }});
        }};
    }
} 