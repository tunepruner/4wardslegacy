package com.tunepruner.fourwards.data.plan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.ArrayList;

public class Plan {
    private Timestamp timestamp;
    private ObservableList<PlanItem> planItems = FXCollections.observableArrayList();

    public Plan(){
//        this.timestamp.setTime(LocalDateTime.now().getLong());
    }

    public ObservableList<PlanItem> getPlanItems() {
        return planItems;
    }

    public void add(PlanItem planItem){
        planItems.add(planItem);
    }

    public int indexOf(String topicName) {
        int indexOf = -1;
        for (int i = 0; i < planItems.size(); i++) {
            String compareAgainst = planItems.get(i).getTopic().getName();
            if (compareAgainst.equals(topicName)) {
                indexOf = i;
                break;
            }
        }
        return indexOf;
    }
}
