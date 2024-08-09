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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaxExchangeRate {
    private BigDecimal calculationRate;
    private String sourceCurrencyCode;
    private String targetCurrencyCode;

    public TaxExchangeRate(BigDecimal calculationRate, String sourceCurrencyCode, String targetCurrencyCode) {
        this.calculationRate = calculationRate;
        this.sourceCurrencyCode = sourceCurrencyCode;
        this.targetCurrencyCode = targetCurrencyCode;
    }

    public BigDecimal getCalculationRate() {
        return calculationRate;
    }

    public String getSourceCurrencyCode() {
        return sourceCurrencyCode;
    }

    public String getTargetCurrencyCode() {
        return targetCurrencyCode;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("CalculationRate", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", calculationRate); }}); }});
        map.put("SourceCurrencyCode", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", sourceCurrencyCode); }}); }});
        map.put("TargetCurrencyCode", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", targetCurrencyCode); }}); }});
        return map;
    }
}
