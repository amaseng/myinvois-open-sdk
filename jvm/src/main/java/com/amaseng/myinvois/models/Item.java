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

public class Item {
    private ItemClassificationCode[] itemClassificationCode;
    private String description;
    private String originCountryCode;

    public Item(ItemClassificationCode[] itemClassificationCode, String description, String originCountryCode) {
        this.itemClassificationCode = itemClassificationCode;
        this.description = description;
        this.originCountryCode = originCountryCode;
    }

    public ItemClassificationCode[] getItemClassificationCode() {
        return itemClassificationCode;
    }

    public String getDescription() {
        return description;
    }

    public String getOriginCountryCode() {
        return originCountryCode;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        if (itemClassificationCode != null && itemClassificationCode.length > 0)
            map.put("CommodityClassification", Arrays.stream(itemClassificationCode).map(ItemClassificationCode::toMap).toArray());
        map.put("Description", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", description); }}); }});
        map.put("OriginCountry", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{
            put("IdentificationCode", new ArrayList<Object>() {{
                add(new LinkedHashMap<Object, Object>() {{
                    put("_", originCountryCode);
                }});
            }});
        }}); }});
        return map;
    }
}
