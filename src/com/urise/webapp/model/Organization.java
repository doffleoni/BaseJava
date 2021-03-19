package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collection;

public class Organization implements Section {
    Collection<Experience> experiences;

    public Organization() {
        experiences = new ArrayList<>();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for (Experience ex : experiences) {
            sb.append(ex.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void setSectionItem(String value) {
        String[] sa = value.split(",", 4);
        experiences.add(new Experience(sa[0], YearMonth.parse(sa[1].trim()), YearMonth.parse(sa[2].trim()), sa[3]));
    }
}