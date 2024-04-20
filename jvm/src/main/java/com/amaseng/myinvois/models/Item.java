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
        map.put("OriginCountry", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("IdentificationCode", new LinkedHashMap<Object, Object>() {{
            put("_", originCountryCode);
        }}); }}); }});
        return map;
    }
}
