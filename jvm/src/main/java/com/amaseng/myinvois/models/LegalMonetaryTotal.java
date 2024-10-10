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
import java.util.Optional;

public class LegalMonetaryTotal {
    private Optional<MonetaryAmount> lineExtensionAmount;
    private MonetaryAmount taxExclusiveAmount;
    private MonetaryAmount taxInclusiveAmount;
    private Optional<MonetaryAmount> allowanceTotalAmount;
    private Optional<MonetaryAmount> chargeTotalAmount;
    private Optional<MonetaryAmount> payableRoundingAmount;
    private MonetaryAmount payableAmount;

    public LegalMonetaryTotal(Optional<MonetaryAmount> lineExtensionAmount, MonetaryAmount taxExclusiveAmount, MonetaryAmount taxInclusiveAmount, Optional<MonetaryAmount> allowanceTotalAmount, Optional<MonetaryAmount> chargeTotalAmount, Optional<MonetaryAmount> payableRoundingAmount, MonetaryAmount payableAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
        this.taxExclusiveAmount = taxExclusiveAmount;
        this.taxInclusiveAmount = taxInclusiveAmount;
        this.allowanceTotalAmount = allowanceTotalAmount;
        this.chargeTotalAmount = chargeTotalAmount;
        this.payableRoundingAmount = payableRoundingAmount;
        this.payableAmount = payableAmount;
    }

    public Optional<MonetaryAmount> getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public MonetaryAmount getTaxExclusiveAmount() {
        return taxExclusiveAmount;
    }

    public MonetaryAmount getTaxInclusiveAmount() {
        return taxInclusiveAmount;
    }

    public Optional<MonetaryAmount> getAllowanceTotalAmount() {
        return allowanceTotalAmount;
    }

    public Optional<MonetaryAmount> getChargeTotalAmount() {
        return chargeTotalAmount;
    }

    public Optional<MonetaryAmount> getPayableRoundingAmount() {
        return payableRoundingAmount;
    }

    public MonetaryAmount getPayableAmount() {
        return payableAmount;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        lineExtensionAmount.ifPresent(lea -> map.put("LineExtensionAmount", new ArrayList<Object>() {{ add(lea.toMap()); }}));
        map.put("TaxExclusiveAmount", new ArrayList<Object>() {{ add(taxExclusiveAmount.toMap()); }});
        map.put("TaxInclusiveAmount", new ArrayList<Object>() {{ add(taxInclusiveAmount.toMap()); }});
        allowanceTotalAmount.ifPresent(ata -> map.put("AllowanceTotalAmount", new ArrayList<Object>() {{ add(ata.toMap()); }}));
        chargeTotalAmount.ifPresent(cta -> map.put("ChargeTotalAmount", new ArrayList<Object>() {{ add(cta.toMap()); }}));
        payableRoundingAmount.ifPresent(pra -> map.put("PayableRoundingAmount", new ArrayList<Object>() {{ add(pra.toMap()); }}));
        map.put("PayableAmount", new ArrayList<Object>() {{ add(payableAmount.toMap()); }});
        return map;
    }
}
