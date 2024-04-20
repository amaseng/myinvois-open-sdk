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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaxSubTotal {
    private MonetaryAmount taxableAmount;
    private MonetaryAmount taxAmount;
    private TaxCategory taxCategory;

    public TaxSubTotal(MonetaryAmount taxableAmount, MonetaryAmount taxAmount, TaxCategory taxCategory) {
        this.taxableAmount = taxableAmount;
        this.taxAmount = taxAmount;
        this.taxCategory = taxCategory;
    }

    public MonetaryAmount getTaxableAmount() {
        return taxableAmount;
    }

    public MonetaryAmount getTaxAmount() {
        return taxAmount;
    }

    public TaxCategory getTaxCategory() {
        return taxCategory;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("TaxableAmount", new ArrayList<Object>() {{ add(taxableAmount.toMap()); }});
        map.put("TaxAmount", new ArrayList<Object>() {{ add(taxAmount.toMap()); }});
        map.put("TaxCategory", new ArrayList<Object>() {{ add(taxCategory.toMap()); }});
        return map;
    }
}
