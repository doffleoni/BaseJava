package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BulletedListSection implements Section {
    private List<String> list;

    public BulletedListSection() {
        list = new ArrayList<>();
    }

    @Override
    public void setSectionItem(String value) {
        list.add(new SingleLineSection(value).toString());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for (String ps : list) {
            sb.append(" - ").append(ps.toString());
        }
        return sb.toString();
    }
}