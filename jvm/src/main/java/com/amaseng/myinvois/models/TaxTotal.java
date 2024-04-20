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
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaxTotal {
    private MonetaryAmount taxAmount;
    private TaxSubTotal[] taxSubTotal;

    public TaxTotal(MonetaryAmount taxAmount, TaxSubTotal[] taxSubTotal) {
        this.taxAmount = taxAmount;
        this.taxSubTotal = taxSubTotal;
    }

    public MonetaryAmount getTaxAmount() {
        return taxAmount;
    }

    public TaxSubTotal[] getTaxSubTotal() {
        return taxSubTotal;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("TaxAmount", new ArrayList<Object>() {{ add(taxAmount.toMap()); }});
        if (taxSubTotal != null && taxSubTotal.length > 0)
            map.put("TaxSubtotal", Arrays.stream(taxSubTotal).map(TaxSubTotal::toMap).toArray());
        return map;
    }
}
