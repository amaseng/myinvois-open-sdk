/*
 * Copyright 2011-2024 AmaSeng Software Sdn. Bhd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amaseng.myinvois.models;

import java.util.*;

public class UBLSignature{
    private String id;
    private SignedInfo signedInfo;
    private String signatureValue;
    private KeyInfo keyInfo;
    private QualifyingProperties qualifyingProperties;

    public UBLSignature(String id, QualifyingProperties qualifyingProperties, KeyInfo keyInfo, String signatureValue, SignedInfo signedInfo)
    {
        this.id = id;
        this.signedInfo = signedInfo;
        this.signatureValue = signatureValue;
        this.keyInfo = keyInfo;
        this.qualifyingProperties = qualifyingProperties;
    }

    public String getId()
    {
        return id;
    }

    public SignedInfo getSignedInfo()
    {
        return signedInfo;
    }

    public String getSignatureValue()
    {
        return signatureValue;
    }

    public KeyInfo getKeyInfo()
    {
        return keyInfo;
    }
    

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("Id", id);
            put("Object", new ArrayList<Object>() {{ add(qualifyingProperties.toMap()); }});
            put("KeyInfo", new ArrayList<Object>() {{ add(keyInfo.toMap()); }});
            put("SignatureValue", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", signatureValue); }}); }});
            put("SignedInfo", new ArrayList<Object>() {{ add(signedInfo.toMap()); }});
        }};
    }
}