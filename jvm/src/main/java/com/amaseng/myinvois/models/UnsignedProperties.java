package com.amaseng.myinvois.models;

import java.util.*;

public class UnsignedProperties{

    private String xmlTimeStamp;

    public UnsignedProperties(String xmlTimeStamp)
    {
        this.xmlTimeStamp = xmlTimeStamp;
    }

    public String getXMLTimeStamp()
    {
        return xmlTimeStamp;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("UnsignedSignatureProperties", new ArrayList<Object>() {{ 
                add(new LinkedHashMap<Object, Object>() {{ 
                    put("SignatureTimeStamp", new ArrayList<Object>() {{ 
                        add(new LinkedHashMap<Object, Object>() {{ 
                            put("XMLTimeStamp", new ArrayList<Object>() {{ 
                                add(new LinkedHashMap<Object, Object>() {{ 
                                    put("_", xmlTimeStamp);
                                }});
                            }}); 
                        }});
                    }});
                }});
            }});    
        }};
    }
}