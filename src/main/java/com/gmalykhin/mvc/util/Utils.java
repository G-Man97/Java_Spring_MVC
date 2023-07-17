package com.gmalykhin.mvc.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Utils {
    private List<String> strData = new ArrayList<>();

    public List<String> getStrData() {
        return strData;
    }

    public void setStrData(List<String> strData) {
        this.strData = strData;
    }
}
