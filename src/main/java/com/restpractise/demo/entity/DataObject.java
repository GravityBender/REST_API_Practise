package com.restpractise.demo.entity;

public class DataObject {
    private String categoryCode;
    private Integer value;

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "categoryCode='" + categoryCode + '\'' +
                ", value=" + value +
                '}';
    }
}
