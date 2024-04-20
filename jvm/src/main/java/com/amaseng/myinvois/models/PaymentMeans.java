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

public class PaymentMeans {
    private String paymentMeansCode;
    private FinancialAccount payeeFinancialAccount;

    public PaymentMeans(String paymentMeansCode, FinancialAccount payeeFinancialAccount) {
        this.paymentMeansCode = paymentMeansCode;
        this.payeeFinancialAccount = payeeFinancialAccount;
    }

    public String getPaymentMeansCode() {
        return paymentMeansCode;
    }

    public FinancialAccount getPayeeFinancialAccount() {
        return payeeFinancialAccount;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("PaymentMeansCode", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", paymentMeansCode); }}); }});
            put("PayeeFinancialAccount", new ArrayList<Object>() {{ add(payeeFinancialAccount.toMap()); }});
        }};
    }
}
