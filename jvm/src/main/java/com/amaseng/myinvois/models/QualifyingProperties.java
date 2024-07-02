package com.amaseng.myinvois.models;

import java.util.*;

public class QualifyingProperties{
    private SignedSignatureProperties signedSignatureProperties;
    private UnsignedProperties unsignedProperties;

    public QualifyingProperties(SignedSignatureProperties signedSignatureProperties, UnsignedProperties unsignedProperties)
    {
        this.signedSignatureProperties = signedSignatureProperties;
        this.unsignedProperties = unsignedProperties;
    }

    public SignedSignatureProperties getSignedSignatureProperties()
    {
        return signedSignatureProperties;
    }

    public UnsignedProperties getUnsignedProperties()
    {
        return unsignedProperties;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("QualifyingProperties", new ArrayList<Object>() {{ 
                add(new LinkedHashMap<Object, Object>() {{ 
                    put("SignedProperties", new ArrayList<Object>() {{ 
                        add(new LinkedHashMap<Object, Object>() {{ 
                            put("SignedSignatureProperties", new ArrayList<Object>() {{ add(signedSignatureProperties.toMap()); }});
                            put("UnsignedProperties", new ArrayList<Object>() {{ add(unsignedProperties.toMap()); }});
                        }});
                    }});
                }});
            }});
        }};
    }
}
