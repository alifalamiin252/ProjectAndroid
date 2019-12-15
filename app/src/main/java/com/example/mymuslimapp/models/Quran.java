package com.example.mymuslimapp.models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Quran {
    String arab, indo;

    public Quran() {
    }

    public Quran(String arab, String indo) {
        this.arab = arab;
        this.indo = indo;
    }

    public String getArab() {
        return arab;
    }

    public void setArab(String arab) {
        this.arab = arab;
    }

    public String getIndo() {
        return indo;
    }

    public void setIndo(String indo) {
        this.indo = indo;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("arab", arab);
        result.put("indo", indo);
        return result;
    }
}
