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
