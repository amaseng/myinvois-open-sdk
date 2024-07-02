package com.amaseng.myinvois.models;

import java.util.*;

public class Transform{

    private String xPath;

    public Transform(String xPath)
    {
        this.xPath = xPath;
    }

    public String getXPath()
    {
        return xPath;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("Transform", new ArrayList<Object>() {{ 
                add(new LinkedHashMap<Object, Object>() {{ 
                    put("XPath", new ArrayList<Object>() {{ 
                        add(new LinkedHashMap<Object, Object>() {{ 
                            put("_", xPath); 
                        }});
                    }});
                }});
            }});    
        }};
    }
}