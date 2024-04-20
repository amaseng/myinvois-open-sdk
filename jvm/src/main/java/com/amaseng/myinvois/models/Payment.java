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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Payment {
    private String id;
    private MonetaryAmount paidAmount;
    private Date paidDateTime;

    public Payment(String id, MonetaryAmount paidAmount, Date paidDateTime) {
        this.id = id;
        this.paidAmount = paidAmount;
        this.paidDateTime = paidDateTime;
    }

    public String getId() {
        return id;
    }

    public MonetaryAmount getPaidAmount() {
        return paidAmount;
    }

    public Date getPaidDateTime() {
        return paidDateTime;
    }

    public Map<Object, Object> toMap() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss'Z'");
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("ID", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", id); }}); }});
        map.put("PaidAmount", new ArrayList<Object>() {{ add(paidAmount.toMap()); }});
        map.put("PaidDate", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", dateFormatter.format(paidDateTime)); }}); }});
        map.put("PaidTime", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", timeFormatter.format(paidDateTime)); }}); }});
        return map;
    }
}
