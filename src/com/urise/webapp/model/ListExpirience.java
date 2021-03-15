package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class ListExpirience implements Section {
    List<Expirience> list;

    public ListExpirience() {
        this.list = new ArrayList<Expirience>();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for (Expirience ex : list) {
            sb.append(ex.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void setSectionItem(String value) {
        String[] sa = value.split(",", 4);
        list.add(new Expirience(sa[0], YearMonth.parse(sa[1].trim()), YearMonth.parse(sa[2].trim()), sa[3]));
    }
}