package com.tunepruner.fourwards.data.daylist;

import com.tunepruner.fourwards.data.log.Log;
import com.tunepruner.fourwards.data.plan.AdjustedPlan;
import com.tunepruner.fourwards.data.plan.Plan;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Day {
    private Timestamp timestamp;
    private int syntheticKey; /*Must be unique and effectively final*/
    private LocalDate date;/*Needn't be effectively final, but must be unique!*/
    private Plan plan;/*Instantiated only in constructor.*/
    private AdjustedPlan adjustedPlan;/*Instantiated only in constructor.*/
    private Log log;/*Instantiated only in constructor.*/

}
