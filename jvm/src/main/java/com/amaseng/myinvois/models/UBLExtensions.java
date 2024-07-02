package com.amaseng.myinvois.models;

import java.util.*;

public class UBLExtensions{

    private Signature signature;

    public UBLExtensions(Signature signature)
    {
        this.signature = signature;
    }

    public Signature getSignature()
    {
        return signature;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
             put("UBLExtension", new ArrayList<Object>() {{ 
                add(new LinkedHashMap<Object, Object>() {{
                     put("ExtensionContent", new ArrayList<Object>() {{ 
                        add(new LinkedHashMap<Object, Object>() {{ 
                            put("UBLDocumentSignatures", new ArrayList<Object>() {{ 
                                add(new LinkedHashMap<Object, Object>() {{ 
                                    put("SignatureInformation", new ArrayList<Object>() {{ 
                                        add(new LinkedHashMap<Object, Object>() {{
                                            put("Signature", new ArrayList<Object>() {{ add(signature.toMap()); }});
                                        }});
                                    }});
                                }});
                            }});
                        }});
                    }});
                }});
            }});
        }};
    }
}