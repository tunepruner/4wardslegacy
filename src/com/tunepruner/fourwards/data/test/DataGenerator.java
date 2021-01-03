package com.tunepruner.fourwards.data.test;

import com.tunepruner.fourwards.data.daylist.Day;
import com.tunepruner.fourwards.data.log.Log;
import com.tunepruner.fourwards.data.plan.AdjustedPlan;
import com.tunepruner.fourwards.data.plan.Plan;
import com.tunepruner.fourwards.data.plan.PlanItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class DataGenerator {
     public static Day generate(){
         ObservableList<PlanItem> list = FXCollections.observableArrayList();
         String[] stringArray = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Twenty-one", "Twenty-two"};
         Plan plan = new Plan();
         for ( int i = 0; i < 10; i++ ) {
             PlanItem planItem = new PlanItem(stringArray[i]);
             plan.add(planItem);
         }
         Day day = new Day(plan, new AdjustedPlan(), new Log(), LocalDate.now());
         return day;
     }
}
