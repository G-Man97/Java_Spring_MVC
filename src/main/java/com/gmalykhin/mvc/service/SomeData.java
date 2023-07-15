package com.gmalykhin.mvc.service;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SomeData {
    private List<String> strData;

    public SomeData() {
    }

    public SomeData(List<String> strData) {
        this.strData = strData;
    }

    public List<String> getStrData() {
        return strData;
    }

    public void setStrData(List<String> strData) {
        this.strData = strData;
    }
}
