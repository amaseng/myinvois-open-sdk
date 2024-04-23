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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Charge {
    private boolean chargeIndicator;
    private String allowanceChargeReason;
    private Optional<BigDecimal> multiplierFactorNumeric;
    private MonetaryAmount amount;

    public Charge(boolean chargeIndicator, String allowanceChargeReason, Optional<BigDecimal> multiplierFactorNumeric, MonetaryAmount amount) {
        this.chargeIndicator = chargeIndicator;
        this.allowanceChargeReason = allowanceChargeReason;
        this.multiplierFactorNumeric = multiplierFactorNumeric;
        this.amount = amount;
    }

    public boolean getChargeIndicator() {
        return chargeIndicator;
    }

    public String getAllowanceChargeReason() {
        return allowanceChargeReason;
    }

    public Optional<BigDecimal> getMultiplierFactorNumeric() {
        return multiplierFactorNumeric;
    }

    public MonetaryAmount getAmount() {
        return amount;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("ChargeIndicator", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", chargeIndicator); }}); }});
        map.put("AllowanceChargeReason", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", allowanceChargeReason); }}); }});
        multiplierFactorNumeric.ifPresent(multiplierFactorNumeric -> map.put("MultiplierFactorNumeric", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", multiplierFactorNumeric); }} ); }}));
        map.put("Amount", new ArrayList<Object>() {{ add(amount.toMap()); }});
        return map;
    }
}
