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

public class LegalMonetaryTotal {
    private MonetaryAmount lineExtensionAmount;
    private MonetaryAmount taxExclusiveAmount;
    private MonetaryAmount taxInclusiveAmount;
    private MonetaryAmount allowanceTotalAmount;
    private MonetaryAmount chargeTotalAmount;
    private MonetaryAmount payableRoundingAmount;
    private MonetaryAmount payableAmount;

    public LegalMonetaryTotal(MonetaryAmount lineExtensionAmount, MonetaryAmount taxExclusiveAmount, MonetaryAmount taxInclusiveAmount, MonetaryAmount allowanceTotalAmount, MonetaryAmount chargeTotalAmount, MonetaryAmount payableRoundingAmount, MonetaryAmount payableAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
        this.taxExclusiveAmount = taxExclusiveAmount;
        this.taxInclusiveAmount = taxInclusiveAmount;
        this.allowanceTotalAmount = allowanceTotalAmount;
        this.chargeTotalAmount = chargeTotalAmount;
        this.payableRoundingAmount = payableRoundingAmount;
        this.payableAmount = payableAmount;
    }

    public MonetaryAmount getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public MonetaryAmount getTaxExclusiveAmount() {
        return taxExclusiveAmount;
    }

    public MonetaryAmount getTaxInclusiveAmount() {
        return taxInclusiveAmount;
    }

    public MonetaryAmount getAllowanceTotalAmount() {
        return allowanceTotalAmount;
    }

    public MonetaryAmount getChargeTotalAmount() {
        return chargeTotalAmount;
    }

    public MonetaryAmount getPayableRoundingAmount() {
        return payableRoundingAmount;
    }

    public MonetaryAmount getPayableAmount() {
        return payableAmount;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("LineExtensionAmount", new ArrayList<Object>() {{ add(lineExtensionAmount.toMap()); }});
        map.put("TaxExclusiveAmount", new ArrayList<Object>() {{ add(taxExclusiveAmount.toMap()); }});
        map.put("TaxInclusiveAmount", new ArrayList<Object>() {{ add(taxInclusiveAmount.toMap()); }});
        map.put("AllowanceTotalAmount", new ArrayList<Object>() {{ add(allowanceTotalAmount.toMap()); }});
        map.put("ChargeTotalAmount", new ArrayList<Object>() {{ add(chargeTotalAmount.toMap()); }});
        map.put("PayableRoundingAmount", new ArrayList<Object>() {{ add(payableRoundingAmount.toMap()); }});
        map.put("PayableAmount", new ArrayList<Object>() {{ add(payableAmount.toMap()); }});
        return map;
    }
}
