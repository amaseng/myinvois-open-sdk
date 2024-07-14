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

public class DigestMethod{
    
    private String digestMethod;
    private String algorithm;

    public DigestMethod(String digestMethod, String algorithm)
    {
        this.digestMethod = digestMethod;
        this.algorithm = algorithm;
    }

    public String getDigestMethod()
    {
        return digestMethod;
    }

    public String getAlgorithm()
    {
        return algorithm;
    }

  public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{      
             put("_", digestMethod);
             put("Algorithm", algorithm);
        }};
    }

}

    