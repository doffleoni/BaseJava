package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class ListPersonalQualities implements Section {
    private List<PersonalQualities> list;

    public ListPersonalQualities() {
        this.list = new ArrayList<PersonalQualities>();
    }

    @Override
    public void setSectionItem(String value) {
        if (getSearchKey(value) == null) {
            list.add(new PersonalQualities(value));
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for (PersonalQualities ps : list) {
            sb.append(" - ").append(ps.toString());
        }
        return sb.toString();
    }

    protected Integer getSearchKey(String value) {
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getDescription().equals(value))) {
                return i;
            }
        }
        return null;
    }
}