package com.restpractise.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rest_practise")
public class DataObject {

    @Id
    @Column(name = "categorycode")
    private String categoryCode;

    @Column(name = "value")
    private Integer value;

    public DataObject() {

    }

    public DataObject(String categoryCode, Integer value) {
        this.categoryCode = categoryCode;
        this.value = value;
    }

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
