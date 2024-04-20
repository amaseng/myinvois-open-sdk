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

public class Address {
    private String cityName;
    private String postalZone;
    private String countrySubentityCode;
    private String[] addressLine;
    private Country country;

    public Address(String cityName, String postalZone, String countrySubentityCode, String[] addressLine, Country country) {
        this.cityName = cityName;
        this.postalZone = postalZone;
        this.countrySubentityCode = countrySubentityCode;
        this.addressLine = addressLine;
        this.country = country;
    }

    public String getCityName() {
        return cityName;
    }

    public String getPostalZone() {
        return postalZone;
    }

    public String getCountrySubentityCode() {
        return countrySubentityCode;
    }

    public String[] getAddressLine() {
        return addressLine;
    }

    public Country getCountry() {
        return country;
    }

    public Map<Object, Object> toMap() {
        return new LinkedHashMap<Object, Object>() {{
            put("CityName", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", cityName); }}); }});
            put("PostalZone", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", postalZone); }}); }});
            put("CountrySubentityCode", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", countrySubentityCode); }}); }});
            put("AddressLine", Arrays.stream(addressLine).map(line -> new LinkedHashMap<Object, Object>() {{ put("Line", new ArrayList<Object>() {{ add(new LinkedHashMap<Object, Object>() {{ put("_", line); }}); }}); }}).toArray());
            put("Country", new ArrayList<Object>() {{ add(country.toMap()); }});
        }};
    }
}