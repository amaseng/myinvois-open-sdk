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

public class FreightAllowanceCharge {
    private boolean chargeIndicator;
    private String allowanceChargeReason;
    private BigDecimal amount;
    private String currencyID;

    public FreightAllowanceCharge(boolean chargeIndicator, String allowanceChargeReason, BigDecimal amount, String currencyID) {
        this.chargeIndicator = chargeIndicator;
        this.allowanceChargeReason = allowanceChargeReason;
        this.amount = amount;
        this.currencyID = currencyID;
    }

    public boolean getChargeIndicator() {
        return chargeIndicator;
    }

    public String getAllowanceChargeReason() {
        return allowanceChargeReason;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrencyID() {
        return currencyID;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("ChargeIndicator", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", chargeIndicator); }}); }});
            put("AllowanceChargeReason", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", allowanceChargeReason); }}); }});
            put("Amount", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{
                put("_", amount);
                put("currencyID", currencyID);
            }}); }});
        }};
    }
}
