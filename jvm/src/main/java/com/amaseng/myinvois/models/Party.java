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

public class Party {
    private IndustryClassificationCode[] industryClassificationCode;
    private PartyIdentification[] partyIdentification;
    private Address postalAddress;
    private PartyLegalEntity partyLegalEntity;
    private Contact contact;

    public Party(IndustryClassificationCode[] industryClassificationCode, PartyIdentification[] partyIdentification, Address postalAddress, PartyLegalEntity partyLegalEntity, Contact contact) {
        this.industryClassificationCode = industryClassificationCode;
        this.partyIdentification = partyIdentification;
        this.postalAddress = postalAddress;
        this.partyLegalEntity = partyLegalEntity;
        this.contact = contact;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            if (industryClassificationCode != null && industryClassificationCode.length > 0)
                put("IndustryClassificationCode", Arrays.stream(industryClassificationCode).map(IndustryClassificationCode::toMap).toArray());
            put("PartyIdentification", Arrays.stream(partyIdentification).map(PartyIdentification::toMap).toArray());
            put("PostalAddress", new ArrayList<Object>() {{ add(postalAddress.toMap()); }});
            put("PartyLegalEntity", new ArrayList<Object>() {{ add(partyLegalEntity.toMap()); }});
            put("Contact", new ArrayList<Object>() {{ add(contact.toMap()); }});
        }};
    }
}
