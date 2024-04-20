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

public class InvoiceLine {
    private String id;
    private QuantityUnit invoicedQuantity;
    private MonetaryAmount lineExtensionAmount;
    private Charge[] allowanceCharge;
    private TaxTotal taxTotal;
    private Item item;
    private MonetaryAmount price;
    private MonetaryAmount itemPriceExtension;

    public InvoiceLine(String id, QuantityUnit invoicedQuantity, MonetaryAmount lineExtensionAmount, Charge[] allowanceCharge,
                       TaxTotal taxTotal, Item item, MonetaryAmount price, MonetaryAmount itemPriceExtension) {
        this.id = id;
        this.invoicedQuantity = invoicedQuantity;
        this.lineExtensionAmount = lineExtensionAmount;
        this.allowanceCharge = allowanceCharge;
        this.taxTotal = taxTotal;
        this.item = item;
        this.price = price;
        this.itemPriceExtension = itemPriceExtension;
    }

    public String getId() {
        return id;
    }

    public QuantityUnit getInvoicedQuantity() {
        return invoicedQuantity;
    }

    public MonetaryAmount getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public Charge[] getAllowanceCharge() {
        return allowanceCharge;
    }

    public TaxTotal getTaxTotal() {
        return taxTotal;
    }

    public Item getItem() {
        return item;
    }

    public MonetaryAmount getPrice() {
        return price;
    }

    public MonetaryAmount getItemPriceExtension() {
        return itemPriceExtension;
    }

    public Map<Object, Object> toMap() {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("ID", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", id); }}); }});
        map.put("InvoicedQuantity", new ArrayList<Object>() {{ add(invoicedQuantity.toMap()); }});
        map.put("LineExtensionAmount", new ArrayList<Object>() {{ add(lineExtensionAmount.toMap()); }});
        if (allowanceCharge != null && allowanceCharge.length > 0)
            map.put("AllowanceCharge", Arrays.stream(allowanceCharge).map(Charge::toMap).toArray());
        map.put("TaxTotal", new ArrayList<Object>() {{ add(taxTotal.toMap()); }});
        map.put("Item", new ArrayList<Object>() {{ add(item.toMap()); }});
        map.put("Price", new ArrayList<Object>() {{
            add(new LinkedHashMap<Object, Object>() {{
                put("PriceAmount", new ArrayList<Object>() {{ add(price.toMap()); }});
            }});
        }});
        map.put("ItemPriceExtension", new ArrayList<Object>() {{
            add(new LinkedHashMap<Object, Object>() {{
                put("Amount", new ArrayList<Object>() {{ add(itemPriceExtension.toMap()); }});
            }});
        }});
        return map;
    }
}
