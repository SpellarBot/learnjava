package com.rightkarma.hibernate.model;

import java.util.Date;

public class HiringData {
    private Date hireDate;
    private int hiringManagerId;

    public HiringData() {
    }

    public HiringData(Date hireDate, int hiringManagerId) {
        this.hireDate = hireDate;
        this.hiringManagerId = hiringManagerId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getHiringManagerId() {
        return hiringManagerId;
    }

    public void setHiringManagerId(int hiringManagerId) {
        this.hiringManagerId = hiringManagerId;
    }
}
