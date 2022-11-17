package com.xyzsoft.emanage;

import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;

public class Row {
    private HashMap<String, XSSFCell> attributes;

    public Row() {
        this.attributes = new HashMap<>();
    }

    public void addAttribute(String header, XSSFCell content) {
        attributes.put(header, content);
    }
}
