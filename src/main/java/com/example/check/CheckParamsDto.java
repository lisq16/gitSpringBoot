package com.example.check;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2023/11/12 14:19
 * 4
 */
public class CheckParamsDto {

    public String name;
    public String type;
    public Object value;
    public String needNotEmpty;
    public String length;
    public String[] specialType;

    public CheckParamsDto() {

    }

    public CheckParamsDto(String name, String type, Object value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public CheckParamsDto(String name, String type, Object value, String needNotEmpty,String length,String[] specialType) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.needNotEmpty = needNotEmpty;
        this.length = length;
        this.specialType = specialType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getNeedNotEmpty() {
        return needNotEmpty;
    }

    public void setNeedNotEmpty(String needNotEmpty) {
        this.needNotEmpty = needNotEmpty;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String[] getSpecialType() {
        return specialType;
    }

    public void setSpecialType(String[] specialType) {
        this.specialType = specialType;
    }
}
