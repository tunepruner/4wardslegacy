package com.tunepruner.fourwards.data.general;

import com.tunepruner.fourwards.data.log.*;
import com.tunepruner.fourwards.data.plan.*;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Day implements DisplayableInDayList {
    private Timestamp timestamp;
    private LocalDate date;/*Needn't be effectively final, but must be unique! Used as key*/
    private Plan plan;/*Instantiated only in constructor.*/
    private AdjustedPlan adjustedPlan;/*Instantiated only in constructor.*/
    private Log log;/*Instantiated only in constructor.*/

    public Day(){}
    public Day(LocalDate dateToday){}

    public boolean isDay() {
        return true;
    }

    public LocalDate getDate() {
        return null;
    }
}
