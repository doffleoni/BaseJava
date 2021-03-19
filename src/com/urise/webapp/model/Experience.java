package com.urise.webapp.model;

import java.time.YearMonth;

public class Experience {
    private String location;
    private String description;
    private YearMonth startDate, finishDate;

    public Experience(String location, YearMonth startDate, YearMonth finishDate, String description) {
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public YearMonth getStartDate() {
        return startDate;
    }

    public void setStartDate(YearMonth startDate) {
        this.startDate = startDate;
    }

    public YearMonth getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(YearMonth finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(location).append('\n');
        sb.append(startDate).append(" - ");
        sb.append(finishDate).append("\t");
        sb.append(description);
        return sb.toString();
    }
}