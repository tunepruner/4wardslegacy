package com.tunepruner.fourwards.data.daylist;

import com.tunepruner.fourwards.data.general.DisplayableInDayList;
import com.tunepruner.fourwards.data.log.*;
import com.tunepruner.fourwards.data.plan.*;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Day implements DisplayableInDayList {
    private Timestamp timestamp;
    private LocalDate date;/*Needn't be effectively final, but must be unique! Used as key*/

    public Plan getPlan() {
        return plan;
    }

    private Plan plan;/*Instantiated only in constructor.*/
    private AdjustedPlan adjustedPlan;/*Instantiated only in constructor.*/
    private Log log;/*Instantiated only in constructor.*/

    public Day(){}
    public Day(LocalDate dateToday){
        this.date = dateToday;
    }
    public Day(Plan plan, AdjustedPlan adjustedPlan, Log log, LocalDate date){
        this.plan = plan;
        this.adjustedPlan = adjustedPlan;
        this.log = log;
        this.date = date;
    }

    public boolean isDay() {
        return true;
    }

    public LocalDate getDate() {
        return null;
    }
}
