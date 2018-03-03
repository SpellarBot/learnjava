package com.rightkarma.learnjava.hibernate.model;

import java.util.Date;
import java.util.Objects;

public class EmployeeHistory {
    private int historyId;
    private int employeeId;
    private Date entryDate;
    private String entry;

    public EmployeeHistory() {
    }

    public EmployeeHistory(int employeeId, Date entryDate, String entry) {
        this.employeeId = employeeId;
        this.entryDate = entryDate;
        this.entry = entry;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return "EmployeeHistory{" +
                "historyId=" + historyId +
                ", employeeId=" + employeeId +
                ", entryDate=" + entryDate +
                ", entry='" + entry + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeHistory that = (EmployeeHistory) o;
        return historyId == that.historyId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(historyId);
    }
}
