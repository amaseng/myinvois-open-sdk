package com.amaseng.myinvois.models;

import java.util.*;

public class RSAKeyValue{
    
    private String modulus;
    private String exponent;

    public RSAKeyValue(String modulus, String exponent)
    {
        this.modulus = modulus;
        this.exponent = exponent;
    }

    public String getModulus()
    {
        return modulus;
    }

    public String getExponent()
    {
        return exponent;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("Modulus", new ArrayList<Object>() {{ 
                add(new LinkedHashMap<Object, Object>() {{ 
                    put("_", modulus); 
                }}); 
            }});
            put("Exponent", new ArrayList<Object>() {{ 
                add(new LinkedHashMap<Object, Object>() {{ 
                    put("_", exponent); 
                }}); 
            }});  
        }};
    }
}