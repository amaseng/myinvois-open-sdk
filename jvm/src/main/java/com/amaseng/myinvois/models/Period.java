package com.amaseng.myinvois.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        return new HashMap<Object, Object>() {{
            put("StartDate", new ArrayList<Object>() {{
                add(new HashMap<Object, Object>() {{
                    put("_", dateFormatter.format(startDate));
                }});
            }});
            put("EndDate", new ArrayList<Object>() {{
                add(new HashMap<Object, Object>() {{
                    put("_", dateFormatter.format(endDate));
                }});
            }});
            put("Description", new ArrayList<Object>() {{
                add(new HashMap<Object, Object>() {{
                    put("_", description);
                }});
            }});
        }};
    }
}
