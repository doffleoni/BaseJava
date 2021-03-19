package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.Collection;

public class BulletedListSection implements Section {
    private Collection<SingleLineSection> list;

    public BulletedListSection() {
        list = new ArrayList<>();
    }

    @Override
    public void setSectionItem(String value) {
        list.add(new SingleLineSection(value));
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for (SingleLineSection ps : list) {
            sb.append(" - ").append(ps.toString());
        }
        return sb.toString();
    }
}