package com.amaseng.myinvois.models;

import java.util.*;

public class KeyInfo{
    private RSAKeyValue rsaKeyValue;
    private X509Data x509Data;

    public KeyInfo(RSAKeyValue rsaKeyValue, X509Data x509Data)
    {
        this.rsaKeyValue = rsaKeyValue;
        this.x509Data = x509Data;
    }

    public RSAKeyValue getRSAKeyValue()
    {
        return rsaKeyValue;
    }

    public X509Data getX509Data()
    {
        return x509Data;
    }


    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("KeyValue", new ArrayList<Object>() {{ 
                add(new LinkedHashMap<Object, Object>() {{ 
                    put("RSAKeyValue", new ArrayList<Object>() {{ add(rsaKeyValue.toMap()); }});
                }});
            }});
            put("X509Data", new ArrayList<Object>() {{ add(x509Data.toMap()); }});
        }};
    }
}