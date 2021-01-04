package com.tunepruner.fourwards.data.daylist;

import com.tunepruner.fourwards.data.general.DisplayableInDayList;
import com.tunepruner.fourwards.data.log.*;
import com.tunepruner.fourwards.data.plan.*;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Day implements DisplayableInDayList {
    private Timestamp timestamp;
    private LocalDate date;/*Needn't be effectively final, but must be unique! Used as key*/

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    private Plan plan;/*Instantiated only in constructor.*/

    private AdjustedPlan adjustedPlan;/*Instantiated only in constructor.*/
    private Log log;/*Instantiated only in constructor.*/
    public Day(){}

    public Day(LocalDate dateToday){
        this.date = dateToday;
    }
    public boolean isDay() {
        return true;
    }

    public LocalDate getDate() {
        return date;
    }

    public Plan getPlan() {
        return plan;
    }
}
