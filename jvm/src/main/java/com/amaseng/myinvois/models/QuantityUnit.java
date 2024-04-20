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
import java.util.LinkedHashMap;
import java.util.Map;

public class QuantityUnit {
    private BigDecimal quantity;
    private String unitCode;

    public QuantityUnit(BigDecimal quantity, String unitCode) {
        this.quantity = quantity;
        this.unitCode = unitCode;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("_", quantity);
        map.put("unitCode", unitCode);
        return map;
    }
}
