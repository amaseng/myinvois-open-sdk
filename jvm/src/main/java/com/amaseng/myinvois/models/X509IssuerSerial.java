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

public class X509IssuerSerial{
    private String x509IssuerName;
    private String x509SerialNumber;

    public X509IssuerSerial(String x509IssuerName, String x509SerialNumber)
    {
        this.x509IssuerName = x509IssuerName;
        this.x509SerialNumber = x509SerialNumber;
    }

    public String getX509IssuerName()
    {
        return x509IssuerName;
    }

    public String getX509SerialNumber()
    {
        return x509SerialNumber;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("X509IssuerName", new ArrayList<Object>() {{ 
                add(new LinkedHashMap<Object, Object>() {{ 
                    put("_", x509IssuerName); 
                }}); 
            }});
            put("X509SerialNumber", new ArrayList<Object>() {{ 
                add(new LinkedHashMap<Object, Object>() {{ 
                    put("_", x509SerialNumber); 
                }}); 
            }});  
        }};
    }
}