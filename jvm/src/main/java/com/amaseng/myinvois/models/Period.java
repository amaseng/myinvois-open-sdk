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
import java.util.Optional;

public class Period {
    private Date startDate;
    private Date endDate;
    private String description;

    public Period(Date startDate, Date endDate, String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public Map<Object, Object> toMap() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        return new LinkedHashMap<Object, Object>() {{
            put("StartDate", new ArrayList<Object>() {{
                add(new LinkedHashMap<Object, Object>() {{
                    put("_", dateFormatter.format(startDate));
                }});
            }});
            put("EndDate", new ArrayList<Object>() {{
                add(new LinkedHashMap<Object, Object>() {{
                    put("_", dateFormatter.format(endDate));
                }});
            }});
            put("Description", new ArrayList<Object>() {{
                add(new LinkedHashMap<Object, Object>() {{
                    put("_", description);
                }});
            }});
        }};
    }
}
