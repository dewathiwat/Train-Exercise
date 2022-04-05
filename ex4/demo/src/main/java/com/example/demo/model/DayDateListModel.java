package com.example.demo.model;

import java.util.List;

public class DayDateListModel {
    private Integer day;
    private String dateTh;
    private List<TimeTitleMinModel> list;

    public Integer getDay() {
        return this.day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getDateTh() {
        return this.dateTh;
    }

    public void setDateTh(String dateTh) {
        this.dateTh = dateTh;
    }

    public List<TimeTitleMinModel> getList() {
        return this.list;
    }

    public void setList(List<TimeTitleMinModel> list) {
        this.list = list;
    }

}
